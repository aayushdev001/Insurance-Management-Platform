package com.driver.InsuranceManagementPlatform.Repository;

import com.driver.InsuranceManagementPlatform.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer>
{
}
