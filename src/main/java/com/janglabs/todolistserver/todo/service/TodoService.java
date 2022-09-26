package com.janglabs.todolistserver.todo.service;

import com.janglabs.todolistserver.todo.domain.TodoEntity;
import com.janglabs.todolistserver.todo.dto.TodoDto;
import com.janglabs.todolistserver.todo.repository.TodoRepository;
import com.janglabs.todolistserver.user.domain.UserEntity;
import com.janglabs.todolistserver.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoEntity create(TodoDto.Create req) {
        TodoEntity todo = TodoEntity.builder()
                .description(req.getDescription())
                .userId(req.getUserId())
                .status("TODO")
                .isDeleted("N")
                .build();

        return todoRepository.save(todo);
    }

    public List<TodoEntity> findByUserId(Long userId) {

        return todoRepository.findByUserId(userId);
    }

    public List<TodoEntity> trashFindByUserId(Long userId) {

        return todoRepository.trashFindByUserId(userId);
    }

    public TodoEntity update(TodoDto.Update req) {
        TodoEntity todo = todoRepository.findById(req.getId()).orElseThrow();
        todo.update(req.getStatus(), req.getDescription());

        return todoRepository.save(todo);
    }

    public TodoEntity softDelete(Long id) {
        TodoEntity todo = todoRepository.findById(id).orElseThrow();
        todo.delete();

        return todoRepository.save(todo);
    }
}
