package hr.adnanb.rbazadatak.service.impl;

import hr.adnanb.rbazadatak.domain.entity.Client;
import hr.adnanb.rbazadatak.repository.ClientRepository;
import hr.adnanb.rbazadatak.service.ClientService;
import hr.adnanb.rbazadatak.service.KafkaProducerService;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Override
    public Client findByOib(String oib){
        return clientRepository.findByOib(oib);
    }

    @Override
    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    @Override
    @Transactional
    public Client save(Client client){
         client = clientRepository.save(client);
         log.info("Client sucessfuly saved: {}", client);
         return client;
    }

    @Override
    @Transactional
    public void deleteByOib(String oib){
        Client client = this.findByOib(oib);
        if(client == null){
            throw new RuntimeException(new StringBuilder().append("Client with oib ")
                    .append(oib).append(" does not exist!").toString());
        }

        clientRepository.deleteByOib(oib);
    }

    @Override
    public void sendClientToKafka(Client client){
        kafkaProducerService.sendMessage("rbazadatak-topic", client.toString());
    }

}
