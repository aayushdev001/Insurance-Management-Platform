package com.driver.InsuranceManagementPlatform.Controllers;

import com.driver.InsuranceManagementPlatform.DTOs.ClaimRequestDTO;
import com.driver.InsuranceManagementPlatform.DTOs.ClaimResponseDTO;
import com.driver.InsuranceManagementPlatform.Exceptions.ClaimNotFoundException;
import com.driver.InsuranceManagementPlatform.Models.Claim;
import com.driver.InsuranceManagementPlatform.Repository.ClaimRepository;
import com.driver.InsuranceManagementPlatform.Services.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/claims")
@RestController
public class ClaimController
{
    @Autowired
    ClaimService claimService;

    @PostMapping("")
    public String addClaim(@RequestBody ClaimRequestDTO claimRequestDTO)
    {
       return claimService.addClaim(claimRequestDTO);
    }

    @GetMapping("/{id}")
    public ClaimResponseDTO getClaim(@PathVariable int id) throws ClaimNotFoundException
    {
        return claimService.getClaim(id);
    }

    @GetMapping("")
    public List<ClaimResponseDTO> getAllClaims()
    {
        return claimService.getAllClaim();
    }

    @PutMapping("/{id}")
    public ClaimResponseDTO updateClaim(@RequestBody ClaimRequestDTO claimRequestDTO, @PathVariable int id)
    {
        return claimService.updateClaim(claimRequestDTO, id);
    }

    @DeleteMapping("/{id}")
    public String deleteClaim(@PathVariable int id) throws ClaimNotFoundException
    {
        return claimService.deleteClaim(id);
    }
}
