package com.example.datarestapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Output {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    private  String datee;

    @ManyToOne(fetch = FetchType.LAZY)
    private  WareHouse wareHouse;

    @ManyToOne(fetch = FetchType.LAZY)
    private Currency currency;

    private Integer facture_number;

    private  Integer code;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;
    

}
