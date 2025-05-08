package hr.adnanb.rbazadatak.service.impl;

import hr.adnanb.rbazadatak.domain.entity.Client;
import hr.adnanb.rbazadatak.repository.ClientRepository;
import hr.adnanb.rbazadatak.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client findByOib(String oib){
        return clientRepository.findByOib(oib);
    }

}
