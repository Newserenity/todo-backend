package com.janglabs.todolistserver.user.domain;

import com.janglabs.todolistserver.todo.domain.TodoEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Entity 에서는 setter 메서드의 사용을 지양
//이유는 변경되지 않는 인스턴스에 대해서도 setter 로 접근이 가능해지기 때문에 객체의 일관성, 안전성을 보장하기 힘들어짐

@Entity
@NoArgsConstructor //객체의 어떤 필드도 가지지 않는 기본 생성자 자동 생성
@Getter
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;
    private String isDeleted;


    public void update(String password, String name) {
        if(!Objects.equals(this.password, password) && password != null) {
            this.password = password;
        }

        if(!Objects.equals(this.name, name) && name != null) {
            this.name = name;
        }
    }

    public void delete() {
        this.isDeleted = "Y";
    }

    @Builder
    public UserEntity(Long id, String email, String password, String name, String isDeleted) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.isDeleted = isDeleted;
    }

}

