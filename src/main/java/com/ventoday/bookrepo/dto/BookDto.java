package com.ventoday.bookrepo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDto {

    private long id;
    private String name;
    private String category;
    private int price;
    private int quantity;
    private String author;
}

