package com.driver.InsuranceManagementPlatform.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Claim
{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int id;

    String description;

    String claimDate;

    String claimStatus;

    @ManyToOne
    @JoinColumn
    InsurancePolicy insurancePolicy;
}



//claim number,
//description, claim date, and claim statu