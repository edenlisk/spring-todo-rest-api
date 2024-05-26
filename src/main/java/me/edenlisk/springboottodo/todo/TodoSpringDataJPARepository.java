package me.edenlisk.springboottodo.todo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoSpringDataJPARepository extends JpaRepository<Todo, Integer>{

}
