package com.driver.InsuranceManagementPlatform.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClaimResponseDTO
{
    String description;

    String claimDate;

    String claimStatus;
}
