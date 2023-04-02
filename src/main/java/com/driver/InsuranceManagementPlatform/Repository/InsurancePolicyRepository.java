package com.driver.InsuranceManagementPlatform.Repository;

import com.driver.InsuranceManagementPlatform.Models.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Integer>
{
}
