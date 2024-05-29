package me.edenlisk.springboottodo.todo;

import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        log.info("Getting all todos" + todoRepository.findAll());
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
        Todo createdTodo = todoRepository.save(todo);
        return createdTodo;
    }

    @PatchMapping("/{id}")
    Todo updateTodo(@PathVariable ObjectId id, @RequestBody Todo todo) {
        Optional<Todo> existingTodo = todoRepository.findById(id);
        existingTodo.ifPresent(t -> {
            t.setCategory(todo.getCategory());
            t.setDescription(todo.getDescription());
            t.setTargetDate(todo.getTargetDate());
            t.setCompleted(todo.getCompleted());
            todoRepository.save(t);
        });
        return existingTodo.orElse(null);
    }

}
