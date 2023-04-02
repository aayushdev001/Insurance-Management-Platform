package com.driver.InsuranceManagementPlatform.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InsurancePolicyRequestDTO
{
    int clientId;

    String type;

    int coverageAmount;

    int premium;

    String startDate;

    String endDate;
}
