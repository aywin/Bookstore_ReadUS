Bookstore Backend

Description :
Ce projet est le backend de l'application Bookstore, développé avec Spring Boot. Il permet de gérer les utilisateurs, les livres et les catégories via une API REST sécurisée. Les tests ont été validés avec Postman.

Fonctionnalités :

Gestion des utilisateurs :
- Création, modification, suppression et récupération des utilisateurs.
- Authentification (inscription, connexion).

Gestion des livres :
- CRUD complet pour les livres :
  - Ajout de livres avec fichier PDF.
  - Modification des informations des livres.
  - Suppression des livres.
  - Lecture des informations comme le titre, l'auteur, la catégorie, etc.

Gestion des catégories :
- CRUD complet pour les catégories :
  - Ajout, modification, suppression et récupération des catégories.

Tests validés :
- Tous les endpoints de l'API ont été testés avec Postman.

Technologies utilisées :
- Java 17 : Langage principal.
- Spring Boot : Framework backend.
- Spring Data JPA : Gestion des entités et accès à la base de données.
- PostgreSQL : Base de données relationnelle.
- Spring Security : Sécurisation des endpoints.
- Maven : Gestionnaire de dépendances.

Installation :

Prérequis :
- Java 17 ou supérieur installé.
- PostgreSQL installé et configuré.
- Un outil comme Postman pour tester les endpoints.

Étapes :
1. Clonez le dépôt :
   git clone https://github.com/aywin/Bookstore_ReadUS.git
   cd Bookstore_ReadUS

2. Configurez la base de données dans `src/main/resources/application.properties` :
   spring.datasource.url=jdbc:postgresql://localhost:5432/bookstore
   spring.datasource.username=your_username
   spring.datasource.password=your_password

3. Lancez l'application :
   ./mvnw spring-boot:run

4. Accédez à l'API REST sur :
   http://localhost:8080

Documentation des endpoints :

Utilisateurs :
- GET `/api/users` : Récupérer tous les utilisateurs.
- POST `/api/users` : Créer un utilisateur.
- PUT `/api/users/{id}` : Modifier un utilisateur.
- DELETE `/api/users/{id}` : Supprimer un utilisateur.

Livres :
- GET `/api/books` : Récupérer tous les livres.
- POST `/api/books` : Ajouter un livre (avec fichier PDF).
- PUT `/api/books/{id}` : Modifier un livre.
- DELETE `/api/books/{id}` : Supprimer un livre.

Catégories :
- GET `/api/categories` : Récupérer toutes les catégories.
- POST `/api/categories` : Ajouter une catégorie.
- PUT `/api/categories/{id}` : Modifier une catégorie.
- DELETE `/api/categories/{id}` : Supprimer une catégorie.

Tests :
Tous les endpoints ont été testés avec Postman. Vous pouvez importer le fichier de collection Postman dans le dossier `docs/postman`.

Auteurs :
Aymar OUEDRAOGO
