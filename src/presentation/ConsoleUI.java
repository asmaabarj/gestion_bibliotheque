package presentation;

import metier.Bibliotheque;
import metier.Livre;
import metier.Magazine;
import utilitaire.DateUtils;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI {
    private Bibliotheque bibliotheque;
    private Scanner scanner;

    public ConsoleUI() {
        bibliotheque = new Bibliotheque();
        scanner = new Scanner(System.in);
    }

    public void afficherMenu() {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Ajouter un document");
            System.out.println("2. Emprunter un document");
            System.out.println("3. Retourner un document");
            System.out.println("4. Afficher tous les documents");
            System.out.println("5. Rechercher un document");
            System.out.println("6. Quitter");

            int choix = getValidInt("Votre choix : ");

            switch (choix) {
                case 1:
                    ajouterDocument();
                    break;
                case 2:
                    emprunterDocument();
                    break;
                case 3:
                    retournerDocument();
                    break;
                case 4:
                    afficherTousLesDocuments();
                    break;
                case 5:
                    rechercherDocument();
                    break;
                case 6:
                    System.out.println("Au revoir!");
                    return;
                default:
                    System.out.println("Choix invalide, essayez encore.");
            }
        }
    }

    private void ajouterDocument() {
        System.out.print("Type de document (livre/magazine): ");
        String type = scanner.nextLine().trim();

        if (!type.equalsIgnoreCase("livre") && !type.equalsIgnoreCase("magazine")) {
            System.out.println("Type de document invalide. Veuillez entrer 'livre' ou 'magazine'.");
            return;
        }

        String titre;
        while (true) {
            System.out.print("Titre: ");
            titre = scanner.nextLine().trim();
            if (!titre.isEmpty()) {
                break;
            } else {
                System.out.println("Le titre ne peut pas être vide.");
            }
        }

        String auteur;
        while (true) {
            System.out.print("Auteur: ");
            auteur = scanner.nextLine().trim();
            if (!auteur.isEmpty()) {
                break;
            } else {
                System.out.println("Le nom de l'auteur ne peut pas être vide.");
            }
        }

        LocalDate datePublication;
        while (true) {
            System.out.print("Date de publication (yyyy-MM-dd): ");
            String dateStr = scanner.nextLine().trim();
            datePublication = DateUtils.stringToDate(dateStr);
            if (datePublication != null) {
                break;
            } else {
                System.out.println("Format de date invalide. Veuillez entrer une date au format 'yyyy-MM-dd'.");
            }
        }

        int nombreDePages = getValidInt("Nombre de pages : ");
        if (nombreDePages <= 0) {
            System.out.println("Le nombre de pages doit être supérieur à zéro.");
            return;
        }

        if (type.equalsIgnoreCase("livre")) {
            String isbn;
            while (true) {
                System.out.print("ISBN: ");
                isbn = scanner.nextLine().trim();
                if (!isbn.isEmpty()) {
                    break;
                } else {
                    System.out.println("L'ISBN ne peut pas être vide.");
                }
            }
            Livre livre = new Livre(titre, auteur, datePublication, nombreDePages, isbn);
            bibliotheque.ajouterDocument(livre);
            System.out.println("Livre ajouté avec succès.");
        } else if (type.equalsIgnoreCase("magazine")) {
            int numero = getValidInt("Numéro : ");
            if (numero <= 0) {
                System.out.println("Le numéro du magazine doit être supérieur à zéro.");
                return;
            }
            Magazine magazine = new Magazine(titre, auteur, datePublication, nombreDePages, numero);
            bibliotheque.ajouterDocument(magazine);
            System.out.println("Magazine ajouté avec succès.");
        }
    }

    private void emprunterDocument() {
        System.out.print("Titre du document à emprunter: ");
        String titre = scanner.nextLine().trim();
        bibliotheque.emprunterDocument(titre);
    }

    private void retournerDocument() {
        System.out.print("Titre du document à retourner: ");
        String titre = scanner.nextLine().trim();
        bibliotheque.retournerDocument(titre);
    }

    private void afficherTousLesDocuments() {
        bibliotheque.afficherTousLesDocuments();
    }

    private void rechercherDocument() {
        System.out.print("Titre du document à rechercher: ");
        String titre = scanner.nextLine().trim();
        bibliotheque.rechercherDocument(titre);
    }

    private int getValidInt(String message) {
        int number;
        while (true) {
            System.out.print(message);
            try {
                number = Integer.parseInt(scanner.nextLine().trim());
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        }
    }

    public static void main(String[] args) {
        ConsoleUI ui = new ConsoleUI();
        ui.afficherMenu();
    }
}
