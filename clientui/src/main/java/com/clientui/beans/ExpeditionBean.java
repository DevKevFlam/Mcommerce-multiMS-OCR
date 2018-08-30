package com.clientui.beans;

public class ExpeditionBean {

    private Integer id;

    private Integer idCommande;

    private Integer etat;

    public ExpeditionBean() {
    }

    public ExpeditionBean(int id, int idCommande, int etat) {
        this.id = id;
        this.idCommande = idCommande;
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "ExpeditionBean{" +
                "id=" + id +
                ", idCommande=" + idCommande +
                ", etat=" + etat +
                '}';
    }
}
