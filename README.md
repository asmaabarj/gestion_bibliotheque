# Application de Gestion de Bibliothèque

## Description du projet

Cette application console a été développée pour automatiser les tâches de gestion d'une bibliothèque municipale. Elle permet de gérer l'inventaire des livres et des magazines, ainsi que les emprunts et retours de documents. Le projet est conçu en Java 8 et utilise une architecture en couches pour une meilleure organisation du code.

## Fonctionnalités

- **Ajouter un document (Livre ou Magazine)**
- **Emprunter un document**
- **Retourner un document**
- **Afficher tous les documents**
- **Rechercher un document par titre**
- **Menu interactif pour naviguer entre les options**

## Structure de l'application

L'application est divisée en trois couches principales :

1. **Couche de présentation :**
   - **ConsoleUI.java** : Gère l'interface utilisateur et les interactions via la console.

2. **Couche métier :**
   - **Document.java** : Classe abstraite représentant un document avec des attributs communs (id, titre, auteur, date de publication, nombre de pages).
   - **Livre.java** : Classe héritant de `Document` avec un attribut supplémentaire `isbn`.
   - **Magazine.java** : Classe héritant de `Document` avec un attribut supplémentaire `numero`.
   - **Bibliotheque.java** : Gère la collection de documents (ajout, emprunt, retour, recherche).

3. **Couche utilitaire :**
   - **DateUtils.java** : Contient des méthodes utilitaires pour la manipulation des dates.

## Prérequis

- **Java 8** ou version ultérieure
- **Git** pour le contrôle de version

## Installation

1. **Cloner le dépôt Git :**
   ```bash
   git clone https://github.com/asmaabarj/bibliotheque.git

