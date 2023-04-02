package com.driver.InsuranceManagementPlatform.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    String dob;

    String address;

    String mobileNo;

    @OneToOne (mappedBy = "client", cascade = CascadeType.ALL)
    InsurancePolicy insurancePolicy;

    public Client(String name, String dob, String address, String mobileNo)
    {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.mobileNo = mobileNo;
    }
}
