package metier;

import java.time.LocalDate;

public class Livre extends Document {
    private String isbn;

    public Livre(String titre, String auteur, LocalDate datePublication, int nombreDePages, String isbn) {
        super(titre, auteur, datePublication, nombreDePages);
        this.isbn = isbn;
    }

    @Override
    public void emprunter() {
        if (!isEmprunte()) {
            System.out.println("Le livre " + getTitre() + " a été emprunté.");
            setEmprunte(true);
        } else {
            System.out.println("Le livre " + getTitre() + " est déjà emprunté.");
        }
    }

    @Override
    public void retourner() {
        if (isEmprunte()) {
            System.out.println("Le livre " + getTitre() + " a été retourné.");
            setEmprunte(false);
        } else {
            System.out.println("Le livre " + getTitre() + " n'a pas été emprunté.");
        }
    }

    @Override
    public void afficherDetails() {
        System.out.println("Livre: " + getTitre() + " | Auteur: " + getAuteur() + " | ISBN: " + isbn);
    }

    public String getIsbn() {
        return isbn;
    }
}
