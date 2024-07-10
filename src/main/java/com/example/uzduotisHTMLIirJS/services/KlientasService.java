package com.example.uzduotisHTMLIirJS.services;

import com.example.uzduotisHTMLIirJS.models.Klientas;
import com.example.uzduotisHTMLIirJS.repositories.KlientasRepositorie;
import com.example.uzduotisHTMLIirJS.repositories.TransactionRepository;
import com.example.uzduotisHTMLIirJS.utils.JwtDecoder;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;

import java.security.SignatureException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public Klientas getClient(String elPastas, String auth, String endpoint) throws SQLException {
        try{
            Claims claims = JwtDecoder.decodeJwt(auth);
            TransactionRepository.registerTransactions(claims, endpoint, elPastas);
            return kr.getClient(elPastas);
        }catch (JwtException e){
            TransactionRepository.registerTransactions(endpoint, elPastas);
            return new Klientas();
        }
    }
    public List<Klientas> getClientList(String auth, String endpoint, String request) throws SQLException, SignatureException {
        try{
            Claims claims = JwtDecoder.decodeJwt(auth);
            TransactionRepository.registerTransactions(claims, endpoint, request);
            return kr.getClientList();
        }catch (JwtException e){
            TransactionRepository.registerTransactions(endpoint, request);
            return new ArrayList<>();
        }
    }
    public String deleteClient(int id, String auth, String endpoint) throws SQLException {
        try{
            Claims claims = JwtDecoder.decodeJwt(auth);
            kr.deleteClient(id);
            TransactionRepository.registerTransactions(claims, endpoint, String.valueOf(id));
            return "Authorized";
        }catch (JwtException e){
            TransactionRepository.registerTransactions(endpoint, String.valueOf(id));
            return "Not authorized";
        }
    }
    public String modifyClient(Klientas k, String auth, String endpoint) throws SQLException {
        try{
            Claims claims = JwtDecoder.decodeJwt(auth);
            kr.modifyClient(k);
            TransactionRepository.registerTransactions(claims, endpoint, k.toString());
            return "Authorized";
        }catch (JwtException e){
            TransactionRepository.registerTransactions(endpoint, k.toString());
            return "Not authorized";
        }
    }
}
