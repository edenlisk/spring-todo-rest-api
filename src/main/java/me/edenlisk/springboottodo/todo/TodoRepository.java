package me.edenlisk.springboottodo.todo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class TodoRepository {

    ArrayList<Todo> todoList = new ArrayList<>();

    @PostConstruct
    public void init() {
        todoList.add(new Todo(1, "1", "Buy Groceries", "Shopping", false, LocalDateTime.now().plusDays(3)));
        todoList.add(new Todo(2, "1", "Do Laundry", "Housework", false, LocalDateTime.now().plusDays(3)));
        todoList.add(new Todo(3, "1", "Finish Assignment", "School", false, LocalDateTime.now().plusDays(3)));
        todoList.add(new Todo(4, "1", "Go for a run", "Exercise", false, LocalDateTime.now().plusDays(3)));
        todoList.add(new Todo(5, "1", "Read a book", "Leisure", false, LocalDateTime.now().plusDays(3)));
    }

    ArrayList<Todo> findAll() {
        return todoList;
    }

    Optional<Todo> getTodoById(Integer id) {
        return todoList.stream()
                .filter(t -> t.id().equals(id))
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
        todoList.removeIf(t -> t.id().equals(id));
    }
}
