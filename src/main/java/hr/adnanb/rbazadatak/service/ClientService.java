package hr.adnanb.rbazadatak.service;

import hr.adnanb.rbazadatak.domain.entity.Client;

public interface ClientService {

    Client findByOib(String oib);
}
