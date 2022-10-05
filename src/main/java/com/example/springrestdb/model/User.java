package com.example.springrestdb.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private String firstname;
    private String lastname;
    private String email;
    private Integer age;
}
