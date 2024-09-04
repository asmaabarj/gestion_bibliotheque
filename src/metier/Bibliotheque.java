package metier;

import java.util.ArrayList;
import java.util.HashMap;

public class Bibliotheque {
    private ArrayList<Document> documents; 
    private HashMap<String, Document> documentMap; 

    public Bibliotheque() {
        documents = new ArrayList<>(); 
        documentMap = new HashMap<>(); 
    }

    public void ajouterDocument(Document document) {
        documents.add(document); 
        documentMap.put(document.getTitre(), document); 
        System.out.println("Document ajouté : " + document.getTitre());
    }

    public void emprunterDocument(String titre) {
        Document document = documentMap.get(titre);
        if (document != null) {
            document.emprunter();
        } else {
            System.out.println("Document non trouvé : " + titre);
        }
    }

    public void retournerDocument(String titre) {
        Document document = documentMap.get(titre);
        if (document != null) {
            document.retourner();
        } else {
            System.out.println("Document non trouvé : " + titre);
        }
    }

    public void afficherTousLesDocuments() {
        if (documents.isEmpty()) {
            System.out.println("Aucun document dans la bibliothèque.");
        } else {
            for (Document document : documents) {
                document.afficherDetails();
            }
        }
    }

    public void rechercherDocument(String titre) {
        Document document = documentMap.get(titre);
        if (document != null) {
            document.afficherDetails();
        } else {
            System.out.println("Document non trouvé : " + titre);
        }
    }
}
