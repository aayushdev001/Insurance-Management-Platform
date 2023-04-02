package com.driver.InsuranceManagementPlatform.Repository;

import com.driver.InsuranceManagementPlatform.Models.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim, Integer>
{
}
