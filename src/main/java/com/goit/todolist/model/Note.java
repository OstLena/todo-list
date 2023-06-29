package com.goit.todolist.model;

import lombok.Builder;
import lombok.Data;
import lombok.With;

@Data
@Builder
public class Note {

    private Long id;
    @With
    private String title;
    @With
    private String content;
}
