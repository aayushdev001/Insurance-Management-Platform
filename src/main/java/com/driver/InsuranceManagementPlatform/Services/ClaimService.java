package com.driver.InsuranceManagementPlatform.Services;

import com.driver.InsuranceManagementPlatform.DTOs.ClaimRequestDTO;
import com.driver.InsuranceManagementPlatform.DTOs.ClaimResponseDTO;
import com.driver.InsuranceManagementPlatform.Exceptions.ClaimNotFoundException;
import com.driver.InsuranceManagementPlatform.Models.Claim;
import com.driver.InsuranceManagementPlatform.Models.InsurancePolicy;
import com.driver.InsuranceManagementPlatform.Repository.ClaimRepository;
import com.driver.InsuranceManagementPlatform.Repository.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClaimService
{
    @Autowired
    InsurancePolicyRepository insurancePolicyRepository;
    @Autowired
    ClaimRepository claimRepository;

    public String addClaim(ClaimRequestDTO claimRequestDTO)
    {
        InsurancePolicy policy = insurancePolicyRepository.findById(claimRequestDTO.getInsurancePolicyId()).get();

        Claim claim = new Claim();
        claim.setClaimDate(claimRequestDTO.getClaimDate());
        claim.setClaimStatus(claimRequestDTO.getClaimStatus());
        claim.setDescription(claimRequestDTO.getDescription());
        claim.setInsurancePolicy(policy);

        policy.getClaimList().add(claim);

        claimRepository.save(claim);
        return "Claim added";
    }

    public ClaimResponseDTO getClaim(int id) throws ClaimNotFoundException
    {
        try
        {
            Claim claim = claimRepository.findById(id).get();
            return new ClaimResponseDTO(claim.getDescription(), claim.getClaimDate(), claim.getClaimStatus());
        }
        catch (Exception e)
        {
            throw new ClaimNotFoundException("Claim Not Found");
        }
    }

    public List<ClaimResponseDTO> getAllClaim()
    {
        List<Claim> list = claimRepository.findAll();
        List<ClaimResponseDTO> ans = new ArrayList<>();

        for(Claim claim : list) ans.add(new ClaimResponseDTO(claim.getDescription(), claim.getClaimDate(), claim.getClaimStatus()));
        return ans;
    }

    public ClaimResponseDTO updateClaim(ClaimRequestDTO claimRequestDTO, int id)
    {
        Claim claim = claimRepository.findById(id).get();
        claim.setClaimDate(claimRequestDTO.getClaimDate());
        claim.setClaimStatus(claimRequestDTO.getClaimStatus());
        claim.setDescription(claimRequestDTO.getDescription());

        claimRepository.save(claim);

        return new ClaimResponseDTO(claim.getDescription(), claim.getClaimDate(), claim.getClaimStatus());
    }

    public String deleteClaim(int id) throws ClaimNotFoundException
    {
        try
        {
            claimRepository.deleteById(id);
            return "Successfully deleted";
        }
        catch (Exception e)
        {
            throw new ClaimNotFoundException("Claim Not Found");
        }
    }
}
