package com.driver.InsuranceManagementPlatform.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientResponseDTO
{
    String name;

    String dob;

    String address;

    String mobileNo;
}
