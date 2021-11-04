package com.example.datarestapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    private Category category;

    @OneToOne(fetch = FetchType.LAZY)
    private Attachment photo;

    private Integer code;

    @ManyToOne(fetch = FetchType.LAZY)
    private Measurement measurement;

    private boolean active;
}
