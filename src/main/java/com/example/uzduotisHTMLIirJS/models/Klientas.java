package com.example.uzduotisHTMLIirJS.models;

public class Klientas {
    private int id;
    private String vardas;
    private String pavarde;
    private String elPastas;
    private long numeris;
    private String slaptazodis;

    public Klientas(int id, String vardas, String pavarde, String elPastas, long numeris, String slaptazodis) {
        this.id = id;
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.elPastas = elPastas;
        this.numeris = numeris;
        this.slaptazodis = slaptazodis;
    }

    public Klientas(int id, String vardas, String pavarde, String elPastas, long numeris) {
        this.id = id;
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.elPastas = elPastas;
        this.numeris = numeris;
    }

    public Klientas(String vardas, String pavarde, String elPastas, long numeris) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.elPastas = elPastas;
        this.numeris = numeris;
    }

    public Klientas() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public long getNumeris() {
        return numeris;
    }

    public void setNumeris(long numeris) {
        this.numeris = numeris;
    }

    public String getElPastas() {
        return elPastas;
    }

    public void setElPastas(String elPastas) {
        this.elPastas = elPastas;
    }

    public String getSlaptazodis() {
        return slaptazodis;
    }

    public void setSlaptazodis(String slaptazodis) {
        this.slaptazodis = slaptazodis;
    }

    @Override
    public String toString() {
        return "Klientas{" +
                "id=" + id +
                ", vardas='" + vardas + '\'' +
                ", pavarde='" + pavarde + '\'' +
                ", elPastas='" + elPastas + '\'' +
                ", numeris=" + numeris +
                '}';
    }
}
