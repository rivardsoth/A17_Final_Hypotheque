package modele;

import java.io.Serializable;

public class Hypotheque implements Serializable {
    private double tauxAnnuel;
    private double emprunt;
    private double Map;
    private double montantTotaleApresHyp;
    private double difference;
    private int nbAnnee;

    public Hypotheque(double tauxAnnuel, double emprunt, double map, int nbAnnee) {
        this.tauxAnnuel = tauxAnnuel;
        this.emprunt = emprunt;
        this.Map = map;
        this.nbAnnee = nbAnnee;
        this.montantTotaleApresHyp = map*nbAnnee*12;
        this.difference = montantTotaleApresHyp - emprunt;

    }

    public int getNbAnnee() {
        return nbAnnee;
    }

    public void setNbAnnee(int nbAnnee) {
        this.nbAnnee = nbAnnee;
    }

    public double getTauxAnnuel() {
        return tauxAnnuel;
    }

    public void setTauxAnnuel(double tauxAnnuel) {
        this.tauxAnnuel = tauxAnnuel;
    }

    public double getEmprunt() {
        return emprunt;
    }

    public void setEmprunt(double emprunt) {
        this.emprunt = emprunt;
    }

    public double getMap() {
        return Map;
    }

    public void setMap(double map) {
        Map = map;
    }

    public double getMontantTotaleApresHyp() {
        return montantTotaleApresHyp;
    }

    public void setMontantTotaleApresHyp(double montantTotaleApresHyp) {
        this.montantTotaleApresHyp = montantTotaleApresHyp;
    }

    public double getDifference() {
        return difference;
    }

    public void setDifference(double difference) {
        this.difference = difference;
    }

    @Override
    public String toString() {
        return "Hypotheque{" +
                "tauxAnnuel=" + tauxAnnuel +
                ", emprunt=" + emprunt +
                ", Map=" + Map +
                ", montantTotaleApresHyp=" + montantTotaleApresHyp +
                ", difference=" + difference +
                '}';
    }
}
