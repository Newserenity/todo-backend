package com.janglabs.todolistserver.test.controller;

import com.janglabs.todolistserver.test.domain.TestEntity;
import com.janglabs.todolistserver.test.dto.TestDto;
import com.janglabs.todolistserver.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tests")
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    //ResponseEntity 규격
    //DTO 타입 선언을 위해 만드는 느낌적인 느낌
    @PostMapping
    public ResponseEntity<TestEntity> create(@RequestBody TestDto req) {

        return new ResponseEntity<>(testService.add(req), HttpStatus.OK);
    }
}
