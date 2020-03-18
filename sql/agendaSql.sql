CREATE SCHEMA agendaContacts;
USE agendaContacts;

CREATE TABLE contato(
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    email VARCHAR(120) NOT NULL,
    phone LONG NOT NULL
);