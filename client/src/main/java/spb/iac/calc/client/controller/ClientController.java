package spb.iac.calc.client.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spb.iac.calc.client.service.ClientService;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/calc")
public class ClientController {

    private final ClientService service;

    @GetMapping//(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> send(@RequestParam("a") int a,
                                       @RequestParam("b") int b,
                                       @RequestParam("c") int c){
        return new ResponseEntity<String>(service.request(a, b, c), HttpStatus.OK);
    }

}
