package demo.todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Todo {
    @Id
    @GeneratedValue
    private Long todoId;
    private String todoTitle;
    private boolean finished = false;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Version
    private Long version;
}
