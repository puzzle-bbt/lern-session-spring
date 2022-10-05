package com.example.springrestdb.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@Entity
@Table(name = "person") // "user" table is not allowed in PostgreSQL
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private @Id @GeneratedValue Long id;
    @NotBlank
    @Size(min = 2, max = 20)
    private String firstname;
    @NotBlank
    @Size(min = 2, max = 20)
    private String lastname;
    private String email;
    @NotNull
    @Size(min = 0, max = 150)
    private Integer age;
}
