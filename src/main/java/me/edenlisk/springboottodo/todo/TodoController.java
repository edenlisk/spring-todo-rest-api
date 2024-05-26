package me.edenlisk.springboottodo.todo;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    public static final Logger log = LoggerFactory.getLogger(TodoController.class);
//    private TodoRepository todoRepository;
    private TodoJPARepository todoRepository;


    public TodoController(TodoJPARepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("")
    List<Todo> getTodos() {

        var todos = todoRepository.findAll();
        return todos;
    }

//    @GetMapping("/{id}")
//    Todo getTodoById(@PathVariable Integer id) {
//        Optional<Todo> todo = todoRepository.getTodoById(id);
//        if (todo.isEmpty()) {
//            throw new TodoNotFoundException();
//        }
//        return todo.get();
//    }
//
    @PostMapping("")
    Todo createTodo(@Valid @RequestBody Todo todo) {
        System.out.println("[createTodo]: " + todo.toString());
        todoRepository.addTodo();
        return todo;
    }
//
//    @PutMapping("/{id}")
//    void updateTodo(@PathVariable Integer id, @Valid @RequestBody Todo todo) {
//        todoRepository.updateTodo(todo, id);
//    }
//
//    @DeleteMapping("/{id}")
//    void deleteTodoById(@PathVariable Integer id) {
//        todoRepository.deleteTodo(id);
//    }

}
