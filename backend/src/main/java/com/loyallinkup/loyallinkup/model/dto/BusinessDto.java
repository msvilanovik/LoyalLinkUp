package com.loyallinkup.loyallinkup.model.dto;

import lombok.Data;
import com.loyallinkup.loyallinkup.model.Enum.TypeOfBusiness;

@Data
public class BusinessDto {

    private String name;

    private AddressDto address;

    private String phone_number;

    private TypeOfBusiness type_of_business;

}
