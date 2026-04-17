-- =====================================================
-- ACCADEMI DATABASE - FULL FIXED VERSION (SCHEMA + DATA)
-- =====================================================

DROP SCHEMA IF EXISTS accademi CASCADE;
CREATE SCHEMA accademi;

-- =========================
-- USER
-- =========================
CREATE TABLE accademi."user" (
                                 id SERIAL PRIMARY KEY,
                                 name VARCHAR(255),
                                 description VARCHAR(255)
);

-- =========================
-- AZIENDA
-- =========================
CREATE TABLE accademi.azienda (
                                  id SERIAL PRIMARY KEY,
                                  user_id INT REFERENCES accademi."user"(id),
                                  nome_azienda VARCHAR(255),
                                  descrizione_azienda VARCHAR(255)
);

-- =========================
-- CONTACT
-- =========================
CREATE TABLE accademi.contact (
                                  id SERIAL PRIMARY KEY,
                                  user_id INT REFERENCES accademi."user"(id),
                                  first_name VARCHAR(255),
                                  last_name VARCHAR(255),
                                  email VARCHAR(255),
                                  phone_number INT
);

-- =========================
-- DIPENDENTE
-- =========================
CREATE TABLE accademi.dipendente (
                                     id SERIAL PRIMARY KEY,
                                     user_id INT UNIQUE REFERENCES accademi."user"(id),
                                     azienda_id INT REFERENCES accademi.azienda(id),
                                     contact_id INT UNIQUE REFERENCES accademi.contact(id),
                                     nome_dipendente VARCHAR(30),
                                     cognome_dipendente VARCHAR(30),
                                     email VARCHAR(30),
                                     eta INT,
                                     numero_telefono INT
);

-- =========================
-- DRONI
-- =========================
CREATE TABLE accademi.droni (
                                id SERIAL PRIMARY KEY,
                                codice_seriale VARCHAR(255) UNIQUE,
                                modello VARCHAR(255),
                                stato VARCHAR(255),
                                livello_batteria INT,
                                carico_massimo_kg DOUBLE PRECISION,
                                sensore_ostacoli BOOLEAN,
                                dipendente_id INT UNIQUE REFERENCES accademi.dipendente(id)
);

-- =========================
-- AUTO
-- =========================
CREATE TABLE accademi.auto (
                               id SERIAL PRIMARY KEY,
                               azienda_id INT REFERENCES accademi.azienda(id),
                               dipendente_id INT REFERENCES accademi.dipendente(id),
                               user_id INT REFERENCES accademi."user"(id),
                               targa VARCHAR(255) UNIQUE NOT NULL,
                               marca VARCHAR(255),
                               modello VARCHAR(255),
                               carburante VARCHAR(50)
);

-- =========================
-- PRODUCT
-- =========================
CREATE TABLE accademi.product (
                                  id SERIAL PRIMARY KEY,
                                  name VARCHAR(255),
                                  category VARCHAR(255),
                                  price DOUBLE PRECISION,
                                  quantity INT
);

-- =========================
-- PAGAMENTO
-- =========================
CREATE TABLE accademi.pagamento (
                                    id SERIAL PRIMARY KEY,
                                    user_id INT REFERENCES accademi."user"(id),
                                    importo DOUBLE PRECISION,
                                    data_pagamento TIMESTAMP,
                                    metodo VARCHAR(50),
                                    stato VARCHAR(50)
);

-- =========================
-- ORDINE
-- =========================
CREATE TABLE accademi.ordine (
                                 id SERIAL PRIMARY KEY,
                                 utente_id INT REFERENCES accademi."user"(id),
                                 pagamento_id INT REFERENCES accademi.pagamento(id),
                                 costo_totale REAL,
                                 numero_prodotti INT,
                                 indirizzo_spedizione VARCHAR(255)
);

-- =========================
-- PARCEL
-- =========================
CREATE TABLE accademi.parcel (
                                 id SERIAL PRIMARY KEY,
                                 senderName VARCHAR(255),
                                 senderSurname VARCHAR(255),
                                 receiverName VARCHAR(255),
                                 receiverSurname VARCHAR(255),
                                 ordine_id INT REFERENCES accademi.ordine(id),
                                 pagamento_id INT REFERENCES accademi.pagamento(id),
                                 weight DOUBLE PRECISION,
                                 height INT,
                                 width INT,
                                 length INT,
                                 fragile BOOLEAN
);

-- =========================
-- CARRELLO
-- =========================
CREATE TABLE accademi.carrello (
                                   id SERIAL PRIMARY KEY,
                                   user_id INT REFERENCES accademi."user"(id),
                                   pagamento_id INT REFERENCES accademi.pagamento(id),
                                   prezzo_totale DOUBLE PRECISION,
                                   quantita INT
);

-- =========================
-- ORDINE_PRODUCT
-- =========================
CREATE TABLE accademi.ordine_product (
                                         id SERIAL PRIMARY KEY,
                                         ordine_id INT REFERENCES accademi.ordine(id),
                                         product_id INT REFERENCES accademi.product(id)
);

-- =========================
-- USER_PRODUCT
-- =========================
CREATE TABLE accademi.user_product (
                                       id SERIAL PRIMARY KEY,
                                       user_id INT REFERENCES accademi."user"(id),
                                       product_id INT REFERENCES accademi.product(id)
);

-- =========================
-- ELETTRICISTA
-- =========================
CREATE TABLE accademi.elettricista (
                                       id SERIAL PRIMARY KEY,
                                       drone_id INT REFERENCES accademi.droni(id),
                                       nome VARCHAR(255),
                                       cognome VARCHAR(255),
                                       specializzazione VARCHAR(255),
                                       disponibile BOOLEAN,
                                       telefono VARCHAR(50)
);
-- =========================
-- NOTIFICA
-- =========================
CREATE TABLE accademi.notifica (
                                   id SERIAL PRIMARY KEY,
                                   user_id INT REFERENCES accademi."user"(id),
                                   drone_id INT REFERENCES accademi.droni(id),
                                   parcel_id INT REFERENCES accademi.parcel(id),
                                   titolo VARCHAR(255),
                                   messaggio VARCHAR(255),
                                   tipo VARCHAR(50),
                                   priorita VARCHAR(50),
                                   letta BOOLEAN,
                                   data_creazione TIMESTAMP
);

-- =====================================================
-- SEED DATA
-- =====================================================

-- =========================
-- USER
-- =========================
INSERT INTO accademi."user" (name, description) VALUES
                                                    ('Mario Rossi','Admin'),
                                                    ('Luca Bianchi','Cliente'),
                                                    ('Giulia Verdi','Cliente'),
                                                    ('Paolo Neri','Cliente'),
                                                    ('Anna Blu','Cliente'),
                                                    ('Rosa Ricci','Admin');

-- =========================
-- AZIENDA
-- =========================
INSERT INTO accademi.azienda (user_id, nome_azienda, descrizione_azienda) VALUES
                                                                              (1,'Tech SRL','Azienda tech'),
                                                                              (2,'Logi SRL','Logistica'),
                                                                              (3,'Servizi SPA','Servizi'),
                                                                              (4,'Retail SRL','Retail'),
                                                                              (5,'Food SRL','Food');

-- =========================
-- CONTACT
-- =========================
INSERT INTO accademi.contact (user_id, first_name, last_name, email, phone_number) VALUES
                                                                                       (2,'Luca','Bianchi','luca@email.com',123456789),
                                                                                       (3,'Giulia','Verdi','giulia@email.com',987654321),
                                                                                       (4,'Paolo','Neri','paolo@email.com',111222333),
                                                                                       (5,'Anna','Blu','anna@email.com',444555666);

-- =========================
-- DIPENDENTE
-- =========================
INSERT INTO accademi.dipendente
(user_id, azienda_id, contact_id, nome_dipendente, cognome_dipendente, email, eta, numero_telefono)
VALUES
    (2,1,1,'Luca','Bianchi','dip1@email.com',30,111111111),
    (3,1,2,'Giulia','Verdi','dip2@email.com',28,222222222),
    (4,2,3,'Paolo','Neri','dip3@email.com',35,333333333);

-- =========================
-- DRONI
-- =========================
INSERT INTO accademi.droni
(codice_seriale, modello, stato, livello_batteria, carico_massimo_kg, sensore_ostacoli, dipendente_id)
VALUES
    ('DRONE001','DJI Mini','ATTIVO',80,10.5,true,1),
    ('DRONE002','DJI Air','ATTIVO',60,20,true,2),
    ('DRONE003','DJI Pro','MANUTENZIONE',40,25,false,3);

-- =========================
-- AUTO
-- =========================
INSERT INTO accademi.auto
(azienda_id, dipendente_id, user_id, targa, marca, modello, carburante)
VALUES
    (1,1,2,'AA111AA','Fiat','Panda','BENZINA'),
    (1,2,3,'BB222BB','Ford','Focus','DIESEL'),
    (2,3,4,'CC333CC','Tesla','Model 3','ELETTRICA');

-- =========================
-- PRODUCT
-- =========================
INSERT INTO accademi.product (name, category, price, quantity) VALUES
                                                                   ('Drone Mini','ELETTRONICA',50,10),
                                                                   ('Batteria Extra','ACCESSORI',20,50),
                                                                   ('Drone Pro','ELETTRONICA',99,20),
                                                                   ('Cavo USB','ACCESSORI',10,100),
                                                                   ('Viti','ACCESSORI',5,200);

-- =========================
-- PAGAMENTO
-- =========================
INSERT INTO accademi.pagamento
(user_id, importo, data_pagamento, metodo, stato)
VALUES
    (2,100.5,now(),'CARTA','COMPLETATO'),
    (3,250,now(),'PAYPAL','COMPLETATO'),
    (4,150,now(),'BONIFICO','IN_PAGAMENTO'),
    (5,75,now(),'CARTA','COMPLETATO');

-- =========================
-- ORDINE
-- =========================
INSERT INTO accademi.ordine
(utente_id, pagamento_id, costo_totale, numero_prodotti, indirizzo_spedizione)
VALUES
    (2,1,100.5,2,'Via Roma 1'),
    (3,2,250,5,'Via Milano 10'),
    (4,3,150,3,'Via Napoli'),
    (5,4,75,1,'Via Torino');

-- =========================
-- PARCEL
-- =========================
INSERT INTO accademi.parcel
(sendername, sendersurname, receivername, receiversurname, ordine_id, pagamento_id, weight, height, width, length, fragile)
VALUES
    ('Luca','Rossi','Marco','Bianchi',1,1,2.5,10,15,20,true),
    ('Giulia','Esposito','Francesco','Romano',2,2,5,20,25,30,false),
    ('Andrea','Ferrari','Chiara','Colombo',3,3,1.5,8,8,8,true),
    ('Sara','Conti','Matteo','Ricci',4,4,2,10,10,10,false);

-- =========================
-- CARRELLO
-- =========================
INSERT INTO accademi.carrello
(user_id, pagamento_id, prezzo_totale, quantita)
VALUES
    (2,1,100.5,2),
    (3,2,250,5),
    (4,3,150,3),
    (5,4,75,1);

-- =========================
-- ORDINE_PRODUCT
-- =========================
INSERT INTO accademi.ordine_product (ordine_id, product_id) VALUES
                                                                (1,1),(2,2),(3,3),(4,4);

-- =========================
-- USER_PRODUCT
-- =========================
INSERT INTO accademi.user_product (user_id, product_id) VALUES
                                                            (2,1),(3,2),(4,3),(5,4);

-- =========================
-- ELETTRICISTA
-- =========================
INSERT INTO accademi.elettricista
(drone_id, nome, cognome, specializzazione, disponibile, telefono)
VALUES
    (1,'Mario','Rossi','industriale',true,'2567873384'),
    (2,'Paolo','Neri','residenziale',false,'25678409434'),
    (3,'Gianni','Verdi','industriale',true,'1796959393'),
    (1,'Ciro','Esposito','industriale',true,'3331111111'),
    (2,'Guido','Lavespa','residenziale',true,'3332222222'),
    (3,'Ada','Wong','industriale',false,'3333333333'),
    (1,'Leon','Kennedy','residenziale',true,'3334444444'),
    (2,'Casemiro','Grumaioli','industriale',false,'3335555555'),
    (3,'Mariarca','Russo','residenziale',true,'3336666666'),
    (1,'Cin','Ciampai','industriale',false,'3337777777'),
    (2,'Otto','Panzer','residenziale',false,'3338888888'),
    (3,'Mira','Colo','industriale',true,'3339999999'),
    (1,'Chris','Redfield','residenziale',true,'3330000000'),
    (2,'Marco','Marchi','industriale',true,'8991000001'),
    (3,'Gennaro','Savastano','residenziale',true,'8991000002'),
    (1,'Ciro','Di Marzio','industriale',false,'8991000003'),
    (2,'Vincenzo','De Luca','residenziale',true,'8991000004'),
    (3,'Lara','Croft','industriale',true,'7771000005'),
    (1,'Ezio','Auditore','residenziale',true,'3657000006'),
    (2,'Altaïr','Ibn La Ahad','industriale',true,'8001000007'),
    (3,'Jill','Valentine','residenziale',false,'4891000008'),
    (1,'Albert','Wesker','industriale',true,'3451000009'),
    (2,'Ethan','Winters','residenziale',true,'5761000010');

-- =========================
-- NOTIFICA
-- =========================
INSERT INTO accademi.notifica
(user_id, drone_id, parcel_id, titolo, messaggio, tipo, priorita, letta, data_creazione)
VALUES
    (2,1,1,'Batteria bassa','Drone sotto 20%','AVVERTIMENTO','ALTA',false,now()),
    (3,2,2,'OK','Consegna completata','INFORMAZIONE','BASSA',true,now()),
    (4,3,3,'Errore','Guasto motore','ERRORE','CRITICA',false,now());