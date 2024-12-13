package br.com.thiagomota.todolist.todotask.task;

import br.com.thiagomota.todolist.category.CategoryRepository;
import br.com.thiagomota.todolist.utils.Utils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Tag(name = "Gerenciamento de Tarefas", description = "Rotas para gerenciar tarefas")

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    ITaskRepository taskRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Operation(
            summary = "Criar tarefa",
            description = "Esta rota serve para criar uma nova tarefa vinculada ao usuário autenticado."
    )
    @ApiResponse(responseCode = "201", description = "Tarefa criada com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos ou categoria não pertence ao usuário")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @PostMapping("/")
    public ResponseEntity create(@RequestBody TaskModel taskModel, HttpServletRequest request) {
        var idUser = request.getAttribute("idUser");
        taskModel.setIdUser((UUID) idUser);

        // Verifica se a categoria pertence ao usuário (se for especificada)
        if (taskModel.getCategory() != null) {
            var category = categoryRepository.findById(taskModel.getCategory().getId()).orElse(null);
            if (category == null || !category.getUser().getId().equals(idUser)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Categoria inválida ou não pertence ao usuário.");
            }
            taskModel.setCategory(category);
        }

        // Validações de datas
        var currentDate = LocalDateTime.now();
        if (currentDate.isAfter(taskModel.getStart_date()) || currentDate.isAfter(taskModel.getFinish_date())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A data de início / término deve ser futura.");
        } else if (taskModel.getStart_date().isAfter(taskModel.getFinish_date())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A data de início deve ser anterior à data de término.");
        }

        var task = this.taskRepository.save(taskModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }


    @Operation(
            summary = "Listar tarefas",
            description = "Esta rota retorna todas as tarefas vinculadas ao usuário autenticado."
    )
    @ApiResponse(responseCode = "200", description = "Lista de tarefas retornada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @GetMapping("/")
    public ResponseEntity list( HttpServletRequest request) {
        var idUser = request.getAttribute("idUser");
        var tasks = this.taskRepository.findByIdUser((UUID) idUser);
        return ResponseEntity.status(HttpStatus.OK).body(tasks);
    }

    @Operation(
            summary = "Atualizar tarefa",
            description = "Esta rota permite atualizar uma tarefa existente vinculada ao usuário autenticado."
    )
    @ApiResponse(responseCode = "200", description = "Tarefa atualizada com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não tem permissão para alterar esta tarefa")
    @ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody TaskModel taskModel, HttpServletRequest request, @PathVariable UUID id) {
        var task = this.taskRepository.findById(id).orElse(null);

        if (task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada.");
        }

        var idUser = request.getAttribute("idUser");

        if (!task.getIdUser().equals(idUser)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Usuário não tem permissão para alterar essa tarefa.");
        }

        // Valida a nova categoria, se fornecida
        if (taskModel.getCategory() != null) {
            var category = categoryRepository.findById(taskModel.getCategory().getId()).orElse(null);
            if (category == null || !category.getUser().getId().equals(idUser)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Categoria inválida ou não pertence ao usuário.");
            }
            task.setCategory(category);
        }

        // Atualiza os demais campos
        Utils.copyNoNullProperties(taskModel, task);
        var taskUpdated = this.taskRepository.save(task);
        return ResponseEntity.status(HttpStatus.OK).body(taskUpdated);
    }

    @Operation(
            summary = "Listar tarefas por categoria",
            description = "Esta rota retorna todas as tarefas vinculadas a uma categoria específica, do usuário autenticado."
    )
    @ApiResponse(responseCode = "200", description = "Lista de tarefas retornada com sucesso")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada ou não pertence ao usuário")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @GetMapping("/category/{categoryId}")
    public ResponseEntity listTasksByCategory(@PathVariable UUID categoryId, HttpServletRequest request) {
        var idUser = request.getAttribute("idUser");

        var category = categoryRepository.findById(categoryId).orElse(null);
        if (category == null || !category.getUser().getId().equals(idUser)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada ou não pertence ao usuário.");
        }

        var tasks = taskRepository.findByCategoryId(categoryId);
        return ResponseEntity.status(HttpStatus.OK).body(tasks);
    }


}
