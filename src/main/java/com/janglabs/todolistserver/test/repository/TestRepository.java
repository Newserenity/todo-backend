package com.janglabs.todolistserver.test.repository;

import com.janglabs.todolistserver.test.domain.TestEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


//JpaRepository 페이징 기능이 있음
@Repository
public interface TestRepository extends CrudRepository<TestEntity, Long> {
}
