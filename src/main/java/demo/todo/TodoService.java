package demo.todo;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Named
@Transactional
public class TodoService {
    @Inject
    TodoRepository todoRepository;

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Todo create(Todo todo) {
        todo.setCreatedAt(new Date());
        return todoRepository.save(todo);
    }

    public Todo findOne(Long todoId) {
        return todoRepository.findOne(todoId);
    }

    public Todo update(Todo todo) {
        return todoRepository.save(todo);
    }

    public void delete(Long todoId) {
        todoRepository.delete(todoId);
    }
}
