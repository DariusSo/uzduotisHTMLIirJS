package com.example.uzduotisHTMLIirJS.controllers;

import com.example.uzduotisHTMLIirJS.models.Klientas;
import com.example.uzduotisHTMLIirJS.services.KlientasService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class KlientasController {
    KlientasService ks = new KlientasService();
    @CrossOrigin
    @PostMapping("/add")
    public String addClient(@RequestBody Klientas k) throws SQLException {
        return ks.addClient(k);
    }
    @GetMapping("/get-client")
    public Klientas getClient(String elPastas) throws SQLException {
        return ks.getClient(elPastas);
    }
}
