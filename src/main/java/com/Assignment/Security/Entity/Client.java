package com.Assignment.Security.Entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "client")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Client {
    @Id
    private  String id;
    private String name;
    private String message;
}
