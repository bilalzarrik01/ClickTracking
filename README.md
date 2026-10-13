# ClickTracking

Projet Java Maven avec Spring MVC, Java 17 et Jakarta Servlet 6, distribué au format WAR.

## Structure du projet

- `ClickTrack/pom.xml` : dépendances et configuration Maven.
- `ClickTrack/src/main/java` : code Java de l’application.
- `ClickTrack/src/main/resources` : configuration du contexte Spring.
- `ClickTrack/src/main/webapp/WEB-INF/web.xml` : initialisation de Spring et du DispatcherServlet.
- `ClickTrack/src/main/webapp/WEB-INF/dispatcher-servlet.xml` : fichier prévu pour la configuration Spring MVC.
- `ClickTrack/src/test/java` : tests Java.

## Compilation

Depuis le dossier `ClickTrack`, exécuter `mvn clean package`.
