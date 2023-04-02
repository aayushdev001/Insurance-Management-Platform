package com.driver.InsuranceManagementPlatform.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InsurancePolicy
{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int id;

    String type;

    int coverageAmount;

    int premium;

    String startDate;

    String endDate;

    @OneToOne
    @JoinColumn
    Client client;

    @OneToMany (mappedBy = "insurancePolicy", cascade = CascadeType.ALL)
    List<Claim> claimList = new ArrayList<>();
}
