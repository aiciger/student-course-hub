DROP TABLE IF EXISTS studiengang_kurse;
DROP TABLE IF EXISTS person_kurse;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS kurse;
DROP TABLE IF EXISTS studiengang;

CREATE TABLE studiengang (
    id INT NOT NULL,
    name VARCHAR(64) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE kurse (
    id INT NOT NULL,
    semester INT NOT NULL,
    name VARCHAR(64) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE person (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(64) NOT NULL UNIQUE,
    password VARCHAR(41) NOT NULL,
    role ENUM('admin', 'professor', 'student'),
    studiengang_id INT,
    FOREIGN KEY (studiengang_id) REFERENCES studiengang (id),
    PRIMARY KEY (id)
);

CREATE TABLE studiengang_kurse (
    studiengang_id INT NOT NULL,
    kurse_id INT NOT NULL,
    FOREIGN KEY (studiengang_id) REFERENCES studiengang (id),
	FOREIGN KEY (kurse_id) REFERENCES kurse (id),
    PRIMARY KEY (studiengang_id, kurse_id)
);

CREATE TABLE person_kurse (
    person_id INT NOT NULL,
    kurse_id INT NOT NULL,
    FOREIGN KEY (person_id) REFERENCES person (id),
	FOREIGN KEY (kurse_id) REFERENCES kurse (id),
    PRIMARY KEY (person_id, kurse_id)
);

INSERT INTO studiengang(id, name) VALUES (1, "Informatik");
INSERT INTO studiengang(id, name) VALUES (2, "Wirtschaftsinformatik");
INSERT INTO studiengang(id, name) VALUES (3, "Digitale Medienproduktion");

INSERT INTO kurse(id, semester, name) VALUES (1, 1, "Programmieren I");
INSERT INTO kurse(id, semester, name) VALUES (2, 1, "SWE I");
INSERT INTO kurse(id, semester, name) VALUES (3, 1, "Mathematik I");
INSERT INTO kurse(id, semester, name) VALUES (4, 1, "Graphen und endliche Automaten");
INSERT INTO kurse(id, semester, name) VALUES (5, 1, "Einführung in die Informatik");
INSERT INTO kurse(id, semester, name) VALUES (6, 1, "Einführung in die Wirtschaftsinformatik");
INSERT INTO kurse(id, semester, name) VALUES (7, 2, "Programmieren II");
INSERT INTO kurse(id, semester, name) VALUES (8, 2, "SWE II");
INSERT INTO kurse(id, semester, name) VALUES (9, 2, "Mathematik II");
INSERT INTO kurse(id, semester, name) VALUES (10, 2, "Rechnerarchitektur");
INSERT INTO kurse(id, semester, name) VALUES (11, 2, "Infrastruktur");
INSERT INTO kurse(id, semester, name) VALUES (12, 2, "Technik für Wirtschaftsinformatik");
INSERT INTO kurse(id, semester, name) VALUES (13, 2, "Allgemeine BWL");
INSERT INTO kurse(id, semester, name) VALUES (14, 3, "Programmierung von Algorithmen & Datenstrukturen");
INSERT INTO kurse(id, semester, name) VALUES (15, 3, "Programmieren III (Grundlagen der Webprogrammierung)");
INSERT INTO kurse(id, semester, name) VALUES (16, 3, "SWE III");
INSERT INTO kurse(id, semester, name) VALUES (17, 3, "Datenbanken I");
INSERT INTO kurse(id, semester, name) VALUES (18, 3, "Vernetzte Systeme");
INSERT INTO kurse(id, semester, name) VALUES (19, 3, "Theoretische Informatik");
INSERT INTO kurse(id, semester, name) VALUES (20, 3, "Controlling");
INSERT INTO kurse(id, semester, name) VALUES (21, 3, "Standardsoftware");

INSERT INTO kurse(id, semester, name) VALUES (103, 1, "Grundlagen der Mediengestaltung");
INSERT INTO kurse(id, semester, name) VALUES (104, 1, "Grundlegende Methoden");
INSERT INTO kurse(id, semester, name) VALUES (105, 1, "Grundlagen der Medieninformatik");
INSERT INTO kurse(id, semester, name) VALUES (106, 1, "Ökonomische Grundlagen");
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (3, 103);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (3, 104);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (3, 105);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (3, 106);


INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (2,1);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (2,2);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (2,3);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (2,4);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (2,7);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (2,8);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (2,9);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (2,12);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (2,13);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (2,16);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (2,17);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (2,18);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (2,19);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (2,20);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (2,21);

INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (1,1);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (1,2);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (1,3);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (1,4);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (1,5);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (1,7);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (1,8);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (1,9);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (1,10);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (1,11);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (1,14);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (1,15);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (1,16);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (1,17);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (1,18);
INSERT INTO studiengang_kurse(studiengang_id, kurse_id) VALUES (1,19);

INSERT INTO person(name, password, studiengang_id) VALUES ('ahmet', PASSWORD('ente'), 2);

INSERT INTO person_kurse(person_id, kurse_id) VALUES (1, 1);
INSERT INTO person_kurse(person_id, kurse_id) VALUES (1, 2);
INSERT INTO person_kurse(person_id, kurse_id) VALUES (1, 3);

/* 
SELECT person.name AS PERSON, kurse.name AS KURS FROM person 
INNER JOIN person_kurse ON person.id = person_kurse.person_id 
INNER JOIN kurse ON kurse.id = person_kurse.kurse_id
WHERE person.id = 1; 
*/