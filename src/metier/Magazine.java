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
        if (!isEmprunte()) {
            System.out.println("Le magazine " + getTitre() + " numéro " + numero + " a été emprunté.");
            setEmprunte(true);
        } else {
            System.out.println("Le magazine " + getTitre() + " numéro " + numero + " est déjà emprunté.");
        }
    }

    @Override
    public void retourner() {
        if (isEmprunte()) {
            System.out.println("Le magazine " + getTitre() + " numéro " + numero + " a été retourné.");
            setEmprunte(false);
        } else {
            System.out.println("Le magazine " + getTitre() + " numéro " + numero + " n'a pas été emprunté.");
        }
    }

    @Override
    public void afficherDetails() {
        System.out.println("Magazine: " + getTitre() + " | Auteur: " + getAuteur() + " | Numéro: " + numero);
    }

    public int getNumero() {
        return numero;
    }
}
