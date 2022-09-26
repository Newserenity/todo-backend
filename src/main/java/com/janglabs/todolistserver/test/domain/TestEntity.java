package com.janglabs.todolistserver.test.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name="test")
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String isDeleted;

    @Builder
    public TestEntity(Long id, String name, String isDeleted) {
        this.id = id;
        this.name = name;
        this.isDeleted = isDeleted;
    }
}
