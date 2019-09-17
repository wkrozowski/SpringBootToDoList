package io.github.wkr1u18.hello.todo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/todos")
class TodoServlet {
    private final Logger logger = LoggerFactory.getLogger(TodoServlet.class);
    private TodoRepository repository;

    public TodoServlet(TodoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    ResponseEntity<List<Todo>> findAllTodos() {
        logger.info("Request got");

        return ResponseEntity.ok(repository.findAll());
    }

    @PutMapping("/{id}")
    ResponseEntity<Todo> toggleTodo(@PathVariable Integer id) {
       var todo = repository.findById(id);
       todo.ifPresent(t -> {
           t.setDone(!t.getDone());
           repository.save(t);
       });
       return todo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    ResponseEntity<Todo> saveTodo(@RequestBody Todo todo) {
        return ResponseEntity.ok(repository.save(todo));
    }

}
