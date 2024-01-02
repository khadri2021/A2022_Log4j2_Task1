package com.khadri.log4j.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StudentRequest {
    private String stdFirstName;
    private String stdLastName;
    private String stdFatherName;
    private Integer stdAge;
    private Address address;
    private Group group;
}