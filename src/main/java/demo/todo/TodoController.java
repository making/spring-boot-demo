package demo.todo;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("api/todos")
public class TodoController {
    @Inject
    TodoService todoService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Todo> getTodos() {
        List<Todo> todos = todoService.findAll();
        return todos;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Todo> postTodos(@RequestBody Todo todo) {
        Todo created = todoService.create(todo);
        return new ResponseEntity<Todo>(created, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{todoId}", method = RequestMethod.GET)
    public Todo getTodo(@PathVariable("todoId") Long todoId) {
        Todo todo = todoService.findOne(todoId);
        return todo;
    }

    @RequestMapping(value = "{todoId}", method = RequestMethod.PUT)
    public Todo putTodo(@PathVariable("todoId") Long todoId, @RequestBody Todo todo) {
        Todo target = todoService.findOne(todoId);
        BeanUtils.copyProperties(todo, target, "createdAt");
        Todo updated = todoService.update(target);
        return updated;
    }

    @RequestMapping(value = "{todoId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> putTodo(@PathVariable("todoId") Long todoId) {
        todoService.delete(todoId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
