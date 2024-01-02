package com.khadri.log4j.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Address {
    private PresentAddress presentAddress;
    private PermanentAddress permanentAddress;
}