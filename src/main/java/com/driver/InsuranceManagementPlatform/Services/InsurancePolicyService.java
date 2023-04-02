package com.driver.InsuranceManagementPlatform.Services;

import com.driver.InsuranceManagementPlatform.DTOs.InsurancePolicyRequestDTO;
import com.driver.InsuranceManagementPlatform.DTOs.InsurancePolicyResponseDTO;
import com.driver.InsuranceManagementPlatform.Exceptions.InsuranceNotFoundException;
import com.driver.InsuranceManagementPlatform.Models.Client;
import com.driver.InsuranceManagementPlatform.Models.InsurancePolicy;
import com.driver.InsuranceManagementPlatform.Repository.ClientRepository;
import com.driver.InsuranceManagementPlatform.Repository.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsurancePolicyService
{
    @Autowired
    InsurancePolicyRepository insurancePolicyRepository;
    @Autowired
    ClientRepository clientRepository;

    public InsurancePolicyResponseDTO addPolicy(InsurancePolicyRequestDTO insurancePolicyRequestDTO)
    {
        Client client = clientRepository.findById(insurancePolicyRequestDTO.getClientId()).get();
        InsurancePolicy policy = new InsurancePolicy();

        policy.setStartDate(insurancePolicyRequestDTO.getStartDate());
        policy.setEndDate(insurancePolicyRequestDTO.getEndDate());
        policy.setPremium(insurancePolicyRequestDTO.getPremium());
        policy.setCoverageAmount(insurancePolicyRequestDTO.getCoverageAmount());
        policy.setType(insurancePolicyRequestDTO.getType());
        policy.setClient(client);

        client.setInsurancePolicy(policy);

        clientRepository.save(client);

        return new InsurancePolicyResponseDTO(client.getName(), policy.getCoverageAmount());
    }

    public InsurancePolicy getPolicy(int id) throws Exception
    {
        try
        {
            return insurancePolicyRepository.findById(id).get();
        }
        catch (Exception e)
        {
            throw new Exception("Policy Not Found");
        }
    }

    public List<InsurancePolicy> getAllPolicies()
    {
        return insurancePolicyRepository.findAll();
    }

    public InsurancePolicyResponseDTO updatePolicy(InsurancePolicy insurancePolicy, int id)
    {
        InsurancePolicy policy = insurancePolicyRepository.findById(id).get();
        policy.setCoverageAmount(insurancePolicy.getCoverageAmount());
        policy.setType(insurancePolicy.getType());
        policy.setPremium(insurancePolicy.getPremium());
        policy.setStartDate(insurancePolicy.getStartDate());
        policy.setEndDate(insurancePolicy.getEndDate());

        insurancePolicyRepository.save(policy);

        return new InsurancePolicyResponseDTO(policy.getClient().getName(), policy.getCoverageAmount());
    }

    public String deletePolicy(int id) throws InsuranceNotFoundException
    {
        try
        {
            insurancePolicyRepository.deleteById(id);
            return "Successfully deleted";
        }
        catch (Exception e)
        {
            throw new InsuranceNotFoundException("Insurance Not Found");
        }

    }
}
