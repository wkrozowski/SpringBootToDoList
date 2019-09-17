package io.github.wkr1u18.hello.todo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TodoRepository extends JpaRepository<Todo, Integer> {

}
