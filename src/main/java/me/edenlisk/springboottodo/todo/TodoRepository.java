package me.edenlisk.springboottodo.todo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class TodoRepository {

    ArrayList<Todo> todoList = new ArrayList<>();

    ArrayList<Todo> findAll() {
        return todoList;
    }

    Optional<Todo> getTodoById(Integer id) {
        return todoList.stream()
                .filter(t -> t.getId().toString().equals(id.toString()))
                .findFirst();
    }

    void addTodo(Todo todo) {
        todoList.add(todo);
    }

    void updateTodo(Todo todo, Integer id) {
        Optional<Todo> existingTodo = getTodoById(id);
        existingTodo.ifPresent(t -> todoList.set(todoList.indexOf(existingTodo.get()), todo));
    }

    void deleteTodo(Integer id) {
        todoList.removeIf(t -> t.getId().toString().equals(id.toString()));
    }
}
