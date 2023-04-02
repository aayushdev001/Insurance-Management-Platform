package com.driver.InsuranceManagementPlatform.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsurancePolicyResponseDTO
{
    String clientName;

    int coverageAmount;
}
