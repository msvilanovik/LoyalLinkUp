package com.loyallinkup.loyallinkup.model;

import com.loyallinkup.loyallinkup.model.dto.AddressDto;
import jakarta.persistence.*;
import lombok.Data;
import com.loyallinkup.loyallinkup.model.Enum.TypeOfBusiness;

@Table(name = "businesses")
@Entity
@Data
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="business_id")
    private Long id = 0L;

    private String name;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "address_id")
    private Address address;

    private String phone_number;

    @Enumerated(value = EnumType.STRING)
    private TypeOfBusiness type_of_business;

    public Business(){

    }

    public Business(String name, Address address, String phone_number, TypeOfBusiness type_of_business) {
      this.name = name;
      this.address = address;
      this.phone_number = phone_number;
      this.type_of_business = type_of_business;
    }


}
