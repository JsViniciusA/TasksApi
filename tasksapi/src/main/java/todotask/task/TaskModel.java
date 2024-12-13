package br.com.thiagomota.todolist.todotask.task;

import br.com.thiagomota.todolist.category.CategoryModel;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "tb_tasks")
public class TaskModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String description;

    @Column(length = 50)
    private String title;
    private LocalDateTime start_date;
    private LocalDateTime finish_date;
    private String priority;
    private String status;
    private UUID idUser;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = true)
    private CategoryModel category;

    @CreationTimestamp
    private LocalDateTime createAt;

public void setTitle(String title) throws Exception{
    if (title.length() > 50) {
        throw new Exception("O campo title deve conter no máximo 50 caracteres");
    }
    this.title = title;
}


}
