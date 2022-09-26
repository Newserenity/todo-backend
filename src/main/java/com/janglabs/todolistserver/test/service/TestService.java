package com.janglabs.todolistserver.test.service;

import com.janglabs.todolistserver.test.domain.TestEntity;
import com.janglabs.todolistserver.test.dto.TestDto;
import com.janglabs.todolistserver.test.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public TestEntity add(TestDto req) {
        TestEntity test = TestEntity.builder()
                .name(req.getName())
                .isDeleted("N")
                .build();

        //save 생성이랑 수정
        return testRepository.save(test);
    }
}
