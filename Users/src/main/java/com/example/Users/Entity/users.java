package com.example.Users.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
public class users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column()
    private Integer id;

    @Column(name = "User_Name")
    private String username;

}
