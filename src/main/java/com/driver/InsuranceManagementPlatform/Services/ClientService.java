package com.driver.InsuranceManagementPlatform.Services;

import com.driver.InsuranceManagementPlatform.DTOs.ClientRequestDTO;
import com.driver.InsuranceManagementPlatform.DTOs.ClientResponseDTO;
import com.driver.InsuranceManagementPlatform.Exceptions.ClientNotFoundException;
import com.driver.InsuranceManagementPlatform.Models.Client;
import com.driver.InsuranceManagementPlatform.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService
{
    @Autowired
    ClientRepository clientRepository;

    public ClientResponseDTO addClient(ClientRequestDTO clientRequestDTO)
    {
        Client client = new Client(clientRequestDTO.getName(), clientRequestDTO.getDob(), clientRequestDTO.getAddress(), clientRequestDTO.getMobileNo());
        clientRepository.save(client);

        return new ClientResponseDTO(client.getName(), client.getDob(), client.getAddress(), client.getMobileNo());
    }

    public Client getClient(int id) throws Exception
    {
        try
        {
            return clientRepository.findById(id).get();
        }
        catch (Exception e)
        {
            throw  new ClientNotFoundException("Client Not Found");
        }
    }

    public ClientResponseDTO updateClient(ClientRequestDTO clientRequestDTO, int id) throws Exception
    {
        try
        {
            Client client = clientRepository.findById(id).get();
            client.setName(clientRequestDTO.getName());
            client.setAddress(clientRequestDTO.getAddress());
            client.setDob(clientRequestDTO.getDob());
            client.setMobileNo(clientRequestDTO.getMobileNo());

            clientRepository.save(client);

            return new ClientResponseDTO(client.getName(), client.getDob(), client.getAddress(), clientRequestDTO.getMobileNo());
        }
        catch (Exception e)
        {
            throw new ClientNotFoundException("Client Not Found");
        }
    }

    public List<Client> getAllClients()
    {
        return clientRepository.findAll();
    }

    public String deleteClient(int id) throws ClientNotFoundException
    {
        try
        {
            clientRepository.deleteById(id);
            return "Succesfully deleted";
        }
        catch (Exception e)
        {
            throw  new ClientNotFoundException("Client Not Found");
        }
    }
}
