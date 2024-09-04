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
        System.out.println("Le livre " + getTitre() + " a été emprunté.");
    }

    @Override
    public void retourner() {
        System.out.println("Le livre " + getTitre() + " a été retourné.");
    }

    @Override
    public void afficherDetails() {
        System.out.println("Livre: " + getTitre() + " | Auteur: " + getAuteur() + " | ISBN: " + isbn);
    }

    public String getIsbn() {
        return isbn;
    }
}
