package com.example.email.DTO;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmailDTO {

    private String to;
    private String subject;
    private String body;
}
