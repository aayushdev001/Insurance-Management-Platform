package com.driver.InsuranceManagementPlatform.Controllers;

import com.driver.InsuranceManagementPlatform.DTOs.ClientRequestDTO;
import com.driver.InsuranceManagementPlatform.DTOs.ClientResponseDTO;
import com.driver.InsuranceManagementPlatform.Exceptions.ClientNotFoundException;
import com.driver.InsuranceManagementPlatform.Models.Client;
import com.driver.InsuranceManagementPlatform.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clients")
public class ClientController
{
    @Autowired
    ClientService clientService;

    @PostMapping("")
    public ClientResponseDTO addClient(@RequestBody ClientRequestDTO clientRequestDTO)
    {
        return clientService.addClient(clientRequestDTO);
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable int id) throws Exception
    {
        return clientService.getClient(id);
    }

    @GetMapping("")
    public List<Client> getAllClients()
    {
        return clientService.getAllClients();
    }

    @PutMapping("/{id}")
    public ClientResponseDTO updateClient(@RequestBody ClientRequestDTO clientRequestDTO, @PathVariable int id) throws Exception
    {
        return clientService.updateClient(clientRequestDTO, id);
    }

    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable int id) throws ClientNotFoundException
    {
        return clientService.deleteClient(id);
    }

}
