package com.example.uzduotisHTMLIirJS.services;

import com.example.uzduotisHTMLIirJS.models.Klientas;
import com.example.uzduotisHTMLIirJS.repositories.KlientasRepositorie;

import java.sql.SQLException;

public class KlientasService {
    KlientasRepositorie kr = new KlientasRepositorie();
    public String addClient(Klientas k) throws SQLException {
        if(k.getVardas().isEmpty() || k.getPavarde().isEmpty() || k.getElPastas().isEmpty()
        || k.getSlaptazodis().isEmpty() || k.getNumeris() == 0){
            return "Visi laukeliai yra privalomi.";
        }
        kr.addClient(k);
        return "Registracija sekminga. Prisijunkite.";
    }
    public Klientas getClient(String elPastas) throws SQLException {
        return kr.getClient(elPastas);
    }
}
