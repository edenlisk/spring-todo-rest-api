package me.edenlisk.springboottodo.todo;

import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class TodoJDBCRepository {

    private JdbcTemplate todoJdbcTemplate;

    public TodoJDBCRepository(JdbcTemplate todoJdbcTemplate) {
        this.todoJdbcTemplate = todoJdbcTemplate;
    }

    String INSERT_QUERY =
            """
                INSERT INTO TODO(userId, description, category, isCompleted, targetDate)
                    VALUES(?, ?, ?, ?, ?);
                """;

    @PostConstruct
    public void init() {
        todoJdbcTemplate.update(INSERT_QUERY, "1", "Buy Groceries", "Shopping", false, LocalDateTime.now().plusDays(3));
        todoJdbcTemplate.update(INSERT_QUERY, "1", "Do Laundry", "Housework", false, LocalDateTime.now().plusDays(3));
        todoJdbcTemplate.update(INSERT_QUERY, "1", "Finish Assignment", "School", false, LocalDateTime.now().plusDays(3));
        todoJdbcTemplate.update(INSERT_QUERY, "1", "Go for a run", "Exercise", false, LocalDateTime.now().plusDays(3));
        todoJdbcTemplate.update(INSERT_QUERY, "1", "Read a book", "Leisure", false, LocalDateTime.now().plusDays(3));
    }

    ArrayList<Todo> todoList = new ArrayList<>();

    List<Map<String, Object>> findAll() {
        String SEARCH_QUERY =
                """
                        SELECT * FROM TODO;
                        """;
        return todoJdbcTemplate.queryForList(SEARCH_QUERY);
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
