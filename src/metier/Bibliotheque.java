package metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

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
        Optional<Document> document = Optional.ofNullable(documentMap.get(titre));
        document.ifPresent(doc -> doc.emprunter());
        if (!document.isPresent()) {
            System.out.println("Document non trouvé : " + titre);
        }
    }

    public void retournerDocument(String titre) {
        Optional<Document> document = Optional.ofNullable(documentMap.get(titre));
        document.ifPresent(doc -> doc.retourner());
        if (!document.isPresent()) {
            System.out.println("Document non trouvé : " + titre);
        }
    }

    public void afficherTousLesDocuments() {
        if (documents.isEmpty()) {
            System.out.println("Aucun document dans la bibliothèque.");
        } else {
            documents.forEach(Document::afficherDetails);  
        }
    }

    public void rechercherDocument(String titre) {
        Optional<Document> document = Optional.ofNullable(documentMap.get(titre));
        document.ifPresent(Document::afficherDetails);
        if (!document.isPresent()) {
            System.out.println("Document non trouvé : " + titre);
        }
    }
}
