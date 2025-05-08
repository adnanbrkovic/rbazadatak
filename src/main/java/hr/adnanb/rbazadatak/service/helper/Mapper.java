package hr.adnanb.rbazadatak.service.helper;

import hr.adnanb.rbazadatak.domain.entity.Client;
import hr.adnanb.rbazadatak.domain.entity.StatusKartice;
import hr.adnanb.rbazadatak.model.NewCardRequest;

public class Mapper {

    public static Client toClient(NewCardRequest cardRequest){
        if(cardRequest == null){
            return null;
        }
        Client client = new Client();
        client.setOib(cardRequest.getOib());
        client.setIme(cardRequest.getFirstName());
        client.setPrezime(cardRequest.getLastName());
        client.setStatusKartice(StatusKartice.valueOf(cardRequest.getStatus()));
        return client;
    }
}
