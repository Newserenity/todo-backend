package com.janglabs.todolistserver.todo.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class TodoDto {
    @Getter
    public static class Create {
        private Long userId;
        private String description;
    }

    @Getter
    public static class Update {
        private Long id;
        private String status;
        private String description;
    }

    @Getter
    public static class Delete {
        private Long id;
    }

    @Getter
    public static class Search {
        private Long userId;
    }
}
