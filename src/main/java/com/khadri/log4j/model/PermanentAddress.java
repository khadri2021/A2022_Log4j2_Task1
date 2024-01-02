package com.khadri.log4j.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PermanentAddress {
    private String doorNo;
    private String streetName;
    private String landmark;
    private String phoneNo;
}
