CREATE TABLE personnel (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Nom VARCHAR(255) NOT NULL,
    Prenom VARCHAR(255) NOT NULL,
    Metier VARCHAR(255) NOT NULL,
    Affectation VARCHAR(255) NOT NULL,
    Actions VARCHAR(255),
);

INSERT INTO personnel (Nom, Prenom, Metier, Affectation, Actions) VALUES ('Rubio', 'Arthur', 'Militaire', 'Colonel (Col)', 'Organise le camp');
INSERT INTO personnel (Nom, Prenom, Metier, Affectation, Actions) VALUES ('Cakiral', 'Sami', 'Personnel Medical', 'Chirurgie', 'Operations critiques');
INSERT INTO personnel (Nom, Prenom, Metier, Affectation, Actions) VALUES ('Hang', 'Sonimith', 'Personnel Medical', 'Infirmier', 'Accueille les patients');

CREATE TABLE patient(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Nom VARCHAR(255) NOT NULL,
    Prenom VARCHAR(255) NOT NULL,
    DateNaissance DATE NOT NULL,
    Actions VARCHAR(255),
    Maladie VARCHAR(255),
    Medicaments VARCHAR(255),
);