package me.edenlisk.springboottodo.todo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class TodoJPARepository {

    private TodoSpringDataJPARepository todoSpringDataJPARepository;


    public TodoJPARepository(TodoSpringDataJPARepository todoSpringDataJPARepository) {
        this.todoSpringDataJPARepository = todoSpringDataJPARepository;
    }

//    @PostConstruct
//    public void init() {
//        System.out.println("[init]");
//        todoSpringDataJPARepository.save(new Todo("1", "Buy Groceries", "Shopping", false, LocalDateTime.now().plusDays(3)));
//    }

    List<Todo> findAll() {
        return todoSpringDataJPARepository.findAll();
    }

    public void addTodo() {
        Todo todo = new Todo("1", "Buy Groceries", "Shopping", false, LocalDateTime.now().plusDays(3));
        todoSpringDataJPARepository.save(todo);
    }
}
