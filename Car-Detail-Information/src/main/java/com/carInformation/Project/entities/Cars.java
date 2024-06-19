package com.carInformation.Project.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@Getter
@Setter
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "company_name",nullable = false,length = 50)
    private String companyName;

    @Column(name = "car_name",nullable = false,length = 100)
    private String CarName;


    private String Engine;
    private String power;
    private  String torque;
    private String displacement;

}
