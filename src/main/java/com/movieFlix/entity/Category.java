package com.movieFlix.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String name;

    private String description;
}
