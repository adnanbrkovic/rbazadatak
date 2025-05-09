package hr.adnanb.rbazadatak.controller;

import hr.adnanb.rbazadatak.domain.entity.Client;
import hr.adnanb.rbazadatak.service.ClientService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client/")
@Log4j2
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("find/{oib}")
    public ResponseEntity<Client> findByOib(@PathVariable String oib){

        log.info("Find person request received for oib {}", oib);
        return ResponseEntity.ok(clientService.findByOib(oib));
    }

    @GetMapping("findAll")
    public ResponseEntity<List<Client>> findAll(){
        return ResponseEntity.ok(clientService.findAll());
    }

    @DeleteMapping("delete/{oib}")
    public void deleteByOib(@PathVariable String oib){

        log.info("Delete person request received oib {}", oib);
        clientService.deleteByOib(oib);
    }

    @PostMapping("sendToKafka")
    public void sendClientToKafka(@RequestBody Client client){
        log.info("Send client to kafka received {}", client);
        clientService.sendClientToKafka(client);
    }

}
