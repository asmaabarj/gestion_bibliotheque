package metier;

import java.time.LocalDate;

public class Magazine extends Document {
    private int numero;

    public Magazine(String titre, String auteur, LocalDate datePublication, int nombreDePages, int numero) {
        super(titre, auteur, datePublication, nombreDePages);
        this.numero = numero;
    }

    @Override
    public void emprunter() { 
        System.out.println("Le magazine " + getTitre() + " numéro " + numero + " a été emprunté.");
    }

    @Override
    public void retourner() {
        System.out.println("Le magazine " + getTitre() + " numéro " + numero + " a été retourné.");
    }

    @Override
    public void afficherDetails() {
        System.out.println("Magazine: " + getTitre() + " | Auteur: " + getAuteur() + " | Numéro: " + numero);
    }

    public int getNumero() {
        return numero;
    }
}
