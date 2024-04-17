CREATE TABLE personnel (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Prenom VARCHAR(255) NOT NULL,
    Nom VARCHAR(255) NOT NULL,
    Metier VARCHAR(255) NOT NULL,
    Affectation VARCHAR(255) NOT NULL,
    Actions VARCHAR(255),
);

INSERT INTO personnel (Prenom, Nom, Metier, Affectation, Actions) VALUES ('Arthur', 'Rubio', 'Militaire', 'Colonel (Col)', 'Organise la gestion des stocks');
INSERT INTO personnel (Prenom, Nom, Metier, Affectation, Actions) VALUES ('Sami', 'Cakiral', 'Personnel Medical', 'Chirurgie', 'Operations critiques');
INSERT INTO personnel (Prenom, Nom, Metier, Affectation, Actions) VALUES ('Sonimith', 'Hang', 'Personnel Medical', 'Infirmier', 'Accueille les patients');

CREATE TABLE patient(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Nom VARCHAR(255) NOT NULL,
    Prenom VARCHAR(255) NOT NULL,
    DateNaissance DATE NOT NULL,
    Actions VARCHAR(255),
    Maladie VARCHAR(255),
    Medicaments VARCHAR(255),
);