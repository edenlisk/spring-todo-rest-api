package me.edenlisk.springboottodo.todo;

import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    public static final Logger log = LoggerFactory.getLogger(TodoController.class);

    private TodoMongoRepository todoRepository;

    public TodoController(TodoMongoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("")
    List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    @GetMapping("/{id}")
    Todo getTodoById(@PathVariable ObjectId id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isEmpty()) {
            throw new TodoNotFoundException();
        }
        return todo.get();
    }

    @PostMapping("")
    Todo createTodo(@Valid @RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    @PatchMapping("/{id}")
    Todo updateTodo(@PathVariable ObjectId id, @RequestBody Todo todo) {
        Optional<Todo> existingTodo = todoRepository.findById(id);
        existingTodo.ifPresent(t -> {
            if (t.getCategory() != null) {
                t.setCategory(todo.getCategory());
            }
            if (todo.getDescription() != null) {
                t.setDescription(todo.getDescription());
            }
            if (todo.getTargetDate() != null) {
                t.setTargetDate(todo.getTargetDate());
            }
            if (todo.getCompleted() != null) {
                t.setCompleted(todo.getCompleted());
            }
            todoRepository.save(t);
        });
        return existingTodo.orElse(null);
    }

    @DeleteMapping("/{id}")
    void deleteTodo(@PathVariable ObjectId id) {
        todoRepository.deleteById(id);
    }

}
