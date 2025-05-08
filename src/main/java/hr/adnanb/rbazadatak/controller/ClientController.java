package hr.adnanb.rbazadatak.controller;

import hr.adnanb.rbazadatak.domain.entity.Client;
import hr.adnanb.rbazadatak.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/find/{oib}")
    public ResponseEntity<Client> findByOib(@PathVariable String oib){

        Client client = clientService.findByOib(oib);
        return ResponseEntity.ok(client);
    }
}
