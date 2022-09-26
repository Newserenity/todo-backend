package com.janglabs.todolistserver.todo.domain;

import com.janglabs.todolistserver.user.domain.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;


@Entity
@NoArgsConstructor //객체의 어떤 필드도 가지지 않는 기본 생성자 자동 생성
@Getter
@Table(name = "todolist")
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String description;
    private String isDeleted;
    private Long userId;

    public void delete() {
        this.isDeleted = "Y";
    }

    public void update(String status, String description) {
        if(!Objects.equals(this.status, status) && status != null) {
            this.status = status;
        }

        if(!Objects.equals(this.description, description) && description != null) {
            this.description = description;
        }
    }

    @Builder
    public TodoEntity(Long id, String status, String description, String isDeleted, Long userId) {
        this.id = id;
        this.status = status;
        this.description = description;
        this.userId = userId;
        this.isDeleted = isDeleted;
    }
}

