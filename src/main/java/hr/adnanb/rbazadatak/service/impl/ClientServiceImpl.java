package hr.adnanb.rbazadatak.service.impl;

import hr.adnanb.rbazadatak.domain.entity.Client;
import hr.adnanb.rbazadatak.repository.ClientRepository;
import hr.adnanb.rbazadatak.service.ClientService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client findByOib(String oib){
        return clientRepository.findByOib(oib);
    }

    @Override
    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    @Override
    public Client save(Client client){
         client = clientRepository.save(client);
         log.info("Client sucessfuly saved: {}", client);
         return client;
    }

    @Override
    public void deleteByOib(String oib){
        clientRepository.deleteByOib(oib);
    }

}
