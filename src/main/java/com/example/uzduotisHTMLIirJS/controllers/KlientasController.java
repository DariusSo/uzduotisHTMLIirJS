package com.example.uzduotisHTMLIirJS.controllers;

import com.example.uzduotisHTMLIirJS.models.Klientas;
import com.example.uzduotisHTMLIirJS.services.KlientasService;
import org.springframework.web.bind.annotation.*;

import java.security.SignatureException;
import java.sql.SQLException;
import java.util.List;

@RestController
public class KlientasController {
    KlientasService ks = new KlientasService();
    @CrossOrigin
    @PostMapping("/add")
    public String addClient(@RequestBody Klientas k) throws SQLException {
        return ks.addClient(k);
    }
    @CrossOrigin
    @GetMapping("/get-client")
    public Klientas getClient(String elPastas, @RequestHeader("Authorization") String auth) throws SQLException {
        return ks.getClient(elPastas, auth, "/get-client");
    }
    @CrossOrigin
    @GetMapping("/getClientList")
    public List<Klientas> getClientList(@RequestHeader("Authorization") String auth) throws SQLException, SignatureException {
        return ks.getClientList(auth, "/getClientList", "");
    }
    @CrossOrigin
    @GetMapping("/deleteClient")
    public void deleteClient(int id, @RequestHeader("Authorization") String auth) throws SQLException {
        ks.deleteClient(id, auth, "/deleteClient");
    }
    @CrossOrigin
    @PostMapping("/modifyClient")
    public String modifyClient(@RequestBody Klientas k, @RequestHeader("Authorization") String auth) throws SQLException {
        return ks.modifyClient(k , auth, "/modifyClient");
    }
}
