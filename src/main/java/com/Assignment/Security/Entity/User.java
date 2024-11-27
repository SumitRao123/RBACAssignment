package com.Assignment.Security.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Document(collection = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
//@ToString
public class User {
    @Id
    private  String id;
    private  String username;
    private  String password;
    private List<String> roles;
}
