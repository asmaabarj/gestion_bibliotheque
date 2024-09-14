package metier;

import java.time.LocalDate;

public abstract class Document {
    private String titre;
    private String auteur;
    private LocalDate datePublication;
    private int nombreDePages;
    private boolean emprunte;

    public Document(String titre, String auteur, LocalDate datePublication, int nombreDePages) {
        this.titre = titre;
        this.auteur = auteur;
        this.datePublication = datePublication;
        this.nombreDePages = nombreDePages;
        this.emprunte = false;
    }

    public abstract void emprunter();
    public abstract void retourner();
    public abstract void afficherDetails();

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public int getNombreDePages() {
        return nombreDePages;
    }

    public boolean isEmprunte() {
        return emprunte;
    }

    public void setEmprunte(boolean emprunte) {
        this.emprunte = emprunte;
    }
}
