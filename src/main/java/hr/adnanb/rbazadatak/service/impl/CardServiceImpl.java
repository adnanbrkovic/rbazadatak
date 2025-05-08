package hr.adnanb.rbazadatak.service.impl;

import hr.adnanb.rbazadatak.domain.entity.Client;
import hr.adnanb.rbazadatak.domain.entity.StatusKartice;
import hr.adnanb.rbazadatak.model.NewCardRequest;
import hr.adnanb.rbazadatak.service.CardService;
import hr.adnanb.rbazadatak.service.ClientService;
import hr.adnanb.rbazadatak.service.helper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private ClientService clientService;

    @Override
    public void saveCardRequest(NewCardRequest request){

        //VALIDACIJA STATUSA
        if(!StatusKartice.exists(request.getStatus())){
            throw new IllegalArgumentException("Card status not valid!");
        }
        Client client = Mapper.toClient(request);
        clientService.save(client);
    }
}
