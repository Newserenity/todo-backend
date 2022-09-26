package com.janglabs.todolistserver.todo.controller;

import com.janglabs.todolistserver.security.JwtDto;
import com.janglabs.todolistserver.todo.domain.TodoEntity;
import com.janglabs.todolistserver.todo.dto.TodoDto;
import com.janglabs.todolistserver.todo.service.TodoService;
import com.janglabs.todolistserver.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoEntity> create(@RequestBody TodoDto.Create req) {
        return new ResponseEntity<>(todoService.create(req), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TodoEntity>> detail(@RequestBody TodoDto.Search req) {
        return new ResponseEntity<>(todoService.findByUserId(req.getUserId()), HttpStatus.OK);
    }

    @GetMapping("/trash")
    public ResponseEntity<List<TodoEntity>> trashDetail(@RequestBody TodoDto.Search req) {
        return new ResponseEntity<>(todoService.trashFindByUserId(req.getUserId()), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<TodoEntity> update(@RequestBody TodoDto.Update req) {
        return new ResponseEntity<>(todoService.update(req), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<TodoEntity> softDelete(@RequestBody TodoDto.Delete req) {
        return new ResponseEntity<>(todoService.softDelete(req.getId()), HttpStatus.OK);
    }
}
