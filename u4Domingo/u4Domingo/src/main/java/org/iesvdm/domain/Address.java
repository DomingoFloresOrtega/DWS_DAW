package org.iesvdm.domain;

import jakarta.persistence.Embeddable;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Embeddable
public class Address {
    private Integer id;
    private String street;
    private Integer houseNumber;
    private String city;
    private Integer zipCode;
}
