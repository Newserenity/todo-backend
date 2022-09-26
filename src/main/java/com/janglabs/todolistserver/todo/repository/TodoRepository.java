package com.janglabs.todolistserver.todo.repository;

import com.janglabs.todolistserver.todo.domain.TodoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 *     TodoRepository todoRepository = new TodoRepository();
 * </pre>
 * @author 장현준
 * @makeDate 2022.09.18
 * @since 1.0.0
 * @description todolist 카드 관련 레포지토리 인터페이스 클래스
 */
@Repository
public interface TodoRepository extends CrudRepository<TodoEntity, Long> {

    /**
     * @makeDate 2022.09.21
     * @param  userId 조회할 유저 id
     * @description  dataBase에서 유저 id 로 카드를 조회하는 쿼리메서드
     * @return 유효한 카드
     */
    @Query("select list from TodoEntity as list where list.userId = :userId and list.isDeleted = 'N'")
    List<TodoEntity> findByUserId(@Param("userId") Long userId);


    /**
     * @makeDate 2022.09.22
     * @param  userId 조회할 유저 id
     * @description  dataBase에서 유저 id 로 softDelete 된 카드를 조회하는 쿼리메서드
     * @return 삭제된 카드
     */
    @Query("select list from TodoEntity as list where list.userId = :userId and list.isDeleted = 'Y'")
    List<TodoEntity> trashFindByUserId(@Param("userId") Long userId);
}
