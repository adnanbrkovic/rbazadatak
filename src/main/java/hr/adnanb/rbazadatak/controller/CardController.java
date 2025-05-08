package hr.adnanb.rbazadatak.controller;

import hr.adnanb.rbazadatak.example.api.NewCardRequestApi;
import hr.adnanb.rbazadatak.model.NewCardRequest;
import hr.adnanb.rbazadatak.service.CardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class CardController implements NewCardRequestApi {

    @Autowired
    private CardService cardService;

    public ResponseEntity<Void> apiV1CardRequestPost(
            @RequestBody NewCardRequest newCardRequest){

        log.info("New card request received with params {}", newCardRequest);
        cardService.saveCardRequest(newCardRequest);
        return ResponseEntity.ok().build();

    }



}
