package com.example.uzduotisHTMLIirJS.repositories;

import com.example.uzduotisHTMLIirJS.models.Klientas;
import com.example.uzduotisHTMLIirJS.utils.Connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KlientasRepositorie {
    public void addClient(Klientas k) throws SQLException {
        PreparedStatement ps = Connect.SQLConnection("INSERT INTO klientai (vardas, pavarde, el_pastas, numeris, slaptazodis)" +
                "VALUES (?,?,?,?,?)");
        ps.setString(1, k.getVardas());
        ps.setString(2, k.getPavarde());
        ps.setString(3, k.getElPastas());
        ps.setLong(4, k.getNumeris());
        ps.setString(5, k.getSlaptazodis());
        ps.execute();
    }
    public Klientas getClient(String elPastas) throws SQLException {
        Klientas k = null;
        PreparedStatement ps = Connect.SQLConnection("SELECT * FROM klientai WHERE el_pastas = ? AND slaptazodis = ? LIMIT 1");
        ps.setString(1, elPastas);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            k = new Klientas(rs.getInt("id"), rs.getString("vardas"),
                    rs.getString("pavarde"), rs.getString("el_pastas"), rs.getLong("numeris"));
        }
        return k;
    }
}
