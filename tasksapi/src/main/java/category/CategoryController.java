package br.com.thiagomota.todolist.category;


import br.com.thiagomota.todolist.todotask.task.ITaskRepository;
import br.com.thiagomota.todolist.user.UserModel;
import br.com.thiagomota.todolist.user.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@Tag(name = "Gerenciamento de Categorias", description = "Rotas para gerenciar categorias e vincular tarefas")
@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ITaskRepository taskRepository;

    @Operation(
            summary = "Criar categoria",
            description = "Esta rota cria uma nova categoria vinculada a um usuário específico."
    )
    @ApiResponse(responseCode = "201", description = "Categoria criada com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @PostMapping("/{userId}")
    public ResponseEntity createCategory(@RequestParam UUID userId, @RequestBody CategoryDto categoryDto) {

        UserModel user = userRepository.findById((UUID) userId).orElse(null);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }

        // Cria uma nova categoria associada ao usuário
        CategoryModel category = new CategoryModel();
        category.setName(categoryDto.name());
        category.setUser(user);

        // Salva a categoria no banco de dados
        CategoryModel createdCategory = categoryRepository.save(category);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @Operation(
            summary = "Listar categorias",
            description = "Esta rota lista todas as categorias de um usuário específico."
    )
    @ApiResponse(responseCode = "200", description = "Lista de categorias retornada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @GetMapping("/")
    public ResponseEntity listCategories(@RequestParam UUID userId) {
        List<CategoryModel> categories = categoryRepository.findByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @Operation(
            summary = "Buscar categoria",
            description = "Esta rota retorna uma categoria específica vinculada a um usuário."
    )
    @ApiResponse(responseCode = "200", description = "Categoria encontrada com sucesso")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada ou não pertence ao usuário")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @GetMapping("/{id}")
    public ResponseEntity getCategory(@PathVariable UUID id, @RequestParam UUID userId) {
        CategoryModel category = categoryRepository.findById(id).orElse(null);
        if (category == null || !category.getUser().getId().equals(userId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @Operation(
            summary = "Atualizar categoria",
            description = "Esta rota atualiza as informações de uma categoria específica."
    )
    @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada ou não pertence ao usuário")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @PutMapping("/{id}")
    public ResponseEntity updateCategory(@PathVariable UUID id, @RequestParam UUID userId, @RequestBody CategoryModel updatedCategory) {
        CategoryModel category = categoryRepository.findById(id).orElse(null);
        if (category == null || !category.getUser().getId().equals(userId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada.");
        }

        category.setName(updatedCategory.getName());
        categoryRepository.save(category);
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @Operation(
            summary = "Deletar categoria",
            description = "Esta rota exclui uma categoria vinculada a um usuário."
    )
    @ApiResponse(responseCode = "204", description = "Categoria excluída com sucesso")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada ou não pertence ao usuário")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable UUID id, @RequestParam UUID userId) {
        CategoryModel category = categoryRepository.findById(id).orElse(null);
        if (category == null || !category.getUser().getId().equals(userId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada.");
        }

        categoryRepository.delete(category);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(
            summary = "Adicionar tarefa à categoria",
            description = "Esta rota vincula uma tarefa a uma categoria específica."
    )
    @ApiResponse(responseCode = "200", description = "Tarefa adicionada à categoria com sucesso")
    @ApiResponse(responseCode = "404", description = "Categoria ou tarefa não encontrada, ou não pertencem ao usuário")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @PostMapping("/{categoryId}/tasks/{taskId}")
    public ResponseEntity addTaskToCategory(@PathVariable UUID categoryId, @PathVariable UUID taskId, @RequestParam UUID userId) {
        var category = categoryRepository.findById(categoryId).orElse(null);
        if (category == null || !category.getUser().getId().equals(userId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada ou não pertence ao usuário.");
        }

        var task = taskRepository.findById(taskId).orElse(null);
        if (task == null || !task.getIdUser().equals(userId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada ou não pertence ao usuário.");
        }

        task.setCategory(category);
        taskRepository.save(task);
        return ResponseEntity.status(HttpStatus.OK).body("Tarefa adicionada à categoria.");
    }

    @Operation(
            summary = "Remover tarefa da categoria",
            description = "Esta rota desvincula uma tarefa de uma categoria específica."
    )
    @ApiResponse(responseCode = "200", description = "Tarefa removida da categoria com sucesso")
    @ApiResponse(responseCode = "404", description = "Categoria ou tarefa não encontrada, ou não pertencem ao usuário")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @DeleteMapping("/{categoryId}/tasks/{taskId}")
    public ResponseEntity removeTaskFromCategory(@PathVariable UUID categoryId, @PathVariable UUID taskId, @RequestParam UUID userId) {
        var category = categoryRepository.findById(categoryId).orElse(null);
        if (category == null || !category.getUser().getId().equals(userId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada ou não pertence ao usuário.");
        }

        var task = taskRepository.findById(taskId).orElse(null);
        if (task == null || !task.getIdUser().equals(userId) || task.getCategory() == null || !task.getCategory().getId().equals(categoryId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada ou não pertence à categoria.");
        }

        task.setCategory(null);
        taskRepository.save(task);
        return ResponseEntity.status(HttpStatus.OK).body("Tarefa removida da categoria.");
    }

}
