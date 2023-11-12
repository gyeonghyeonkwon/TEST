package com.ll.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Inventory {
    @Getter
    private int id;
    @Getter
    @Setter
    private String wiseSaying;
    @Getter
    @Setter
    private String author;

}
