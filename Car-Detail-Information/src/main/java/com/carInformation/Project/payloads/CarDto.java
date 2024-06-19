package com.carInformation.Project.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CarDto {

    private int id;
    private String companyName;
    private String CarName;
    private String Engine;
    private String power;
    private  String torque;
    private String displacement;

}
