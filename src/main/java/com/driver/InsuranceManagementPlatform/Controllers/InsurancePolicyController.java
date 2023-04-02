package com.driver.InsuranceManagementPlatform.Controllers;

import com.driver.InsuranceManagementPlatform.DTOs.InsurancePolicyRequestDTO;
import com.driver.InsuranceManagementPlatform.DTOs.InsurancePolicyResponseDTO;
import com.driver.InsuranceManagementPlatform.Exceptions.InsuranceNotFoundException;
import com.driver.InsuranceManagementPlatform.Models.InsurancePolicy;
import com.driver.InsuranceManagementPlatform.Services.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/policies")
@RestController
public class InsurancePolicyController
{
    @Autowired
    InsurancePolicyService insurancePolicyService;

    @PostMapping("")
    public InsurancePolicyResponseDTO addPolicy(@RequestBody InsurancePolicyRequestDTO insurancePolicyRequestDTO)
    {
        return insurancePolicyService.addPolicy(insurancePolicyRequestDTO);
    }

    @GetMapping("/{id}")
    public InsurancePolicy getPolicy(@PathVariable int id) throws Exception
    {
        return insurancePolicyService.getPolicy(id);
    }

    @GetMapping("")
    public List<InsurancePolicy> getAllPolicies()
    {
        return insurancePolicyService.getAllPolicies();
    }

    @PutMapping("/{id}")
    public InsurancePolicyResponseDTO updatePolicy(@RequestBody InsurancePolicy insurancePolicy, @PathVariable int id)
    {
        return insurancePolicyService.updatePolicy(insurancePolicy, id);
    }

    @DeleteMapping("/{id}")
    public String deletePolicy(@PathVariable int id) throws InsuranceNotFoundException
    {
        return insurancePolicyService.deletePolicy(id);
    }
}
