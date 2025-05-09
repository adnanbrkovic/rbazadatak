package hr.adnanb.rbazadatak.service;

import hr.adnanb.rbazadatak.domain.entity.Client;

import java.util.List;

public interface ClientService {

    Client findByOib(String oib);

    List<Client> findAll();

    Client save(Client client);

    void deleteByOib(String oib);

    void sendClientToKafka(Client client);


}
