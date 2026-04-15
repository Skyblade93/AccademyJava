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
                                  phone_number VARCHAR(255)
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
                                     numero_telefono VARCHAR(20)
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
                                       disponibile BOOLEAN
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

INSERT INTO accademi."user" (id, name, description) VALUES
                                                        (1,'Mario Rossi','Admin'),
                                                        (2,'Luca Bianchi','Cliente'),
                                                        (3,'Giulia Verdi','Cliente'),
                                                        (4,'Paolo Neri','Cliente'),
                                                        (5,'Anna Blu','Cliente');

INSERT INTO accademi.azienda VALUES
                                 (1,1,'Tech SRL','Azienda tech'),
                                 (2,2,'Logi SRL','Logistica'),
                                 (3,3,'Servizi SPA','Servizi'),
                                 (4,4,'Retail SRL','Retail'),
                                 (5,5,'Food SRL','Food');

INSERT INTO accademi.contact VALUES
                                 (1,2,'Luca','Bianchi','luca@email.com','123456789'),
                                 (2,3,'Giulia','Verdi','giulia@email.com','987654321'),
                                 (3,4,'Paolo','Neri','paolo@email.com','111222333'),
                                 (4,5,'Anna','Blu','anna@email.com','444555666');

INSERT INTO accademi.dipendente VALUES
                                    (1,2,1,1,'Luca','Bianchi','dip1@email.com',30,'111111111'),
                                    (2,3,1,2,'Giulia','Verdi','dip2@email.com',28,'222222222'),
                                    (3,4,2,3,'Paolo','Neri','dip3@email.com',35,'333333333');

INSERT INTO accademi.droni VALUES
                               (1,'DRONE001','DJI Mini','ATTIVO',80,10.5,true,1),
                               (2,'DRONE002','DJI Air','ATTIVO',60,20,true,2),
                               (3,'DRONE003','DJI Pro','MANUTENZIONE',40,25,false,3);

INSERT INTO accademi.auto VALUES
                              (1,1,1,2,'AA111AA','Fiat','Panda','BENZINA'),
                              (2,1,2,3,'BB222BB','Ford','Focus','DIESEL'),
                              (3,2,3,4,'CC333CC','Tesla','Model 3','ELETTRICA');

INSERT INTO accademi.product VALUES
                                 (1,'Drone Mini','ELETTRONICA',50,10),
                                 (2,'Batteria Extra','ACCESSORI',20,50),
                                 (3,'Drone Pro','ELETTRONICA',99,20),
                                 (4,'Cavo USB','ACCESSORI',10,100),
                                 (5,'Viti','ACCESSORI',5,200);

INSERT INTO accademi.pagamento VALUES
                                   (1,2,100.5,now(),'CARTA','COMPLETATO'),
                                   (2,3,250,now(),'PAYPAL','COMPLETATO'),
                                   (3,4,150,now(),'BONIFICO','IN_PAGAMENTO'),
                                   (4,5,75,now(),'CARTA','COMPLETATO');

INSERT INTO accademi.ordine VALUES
                                (1,2,1,100.5,2,'Via Roma 1'),
                                (2,3,2,250,5,'Via Milano 10'),
                                (3,4,3,150,3,'Via Napoli'),
                                (4,5,4,75,1,'Via Torino');

INSERT INTO accademi.parcel VALUES
                                (1,1,1,2.5,10,15,20,true),
                                (2,2,2,5,20,25,30,false),
                                (3,3,3,1.5,8,8,8,true),
                                (4,4,4,2,10,10,10,false);

INSERT INTO accademi.carrello VALUES
                                  (1,2,1,100.5,2),
                                  (2,3,2,250,5),
                                  (3,4,3,150,3),
                                  (4,5,4,75,1);

INSERT INTO accademi.ordine_product VALUES
                                        (1,1,1),(2,2,2),(3,3,3),(4,4,4);

INSERT INTO accademi.user_product VALUES
                                      (1,2,1),(2,3,2),(3,4,3),(4,5,4);

INSERT INTO accademi.elettricista VALUES
                                      (1,1,'Mario','Rossi','Riparazione',true),
                                      (2,2,'Paolo','Neri','Manutenzione',false),
                                      (3,3,'Gianni','Verdi','Diagnostica',true);

INSERT INTO accademi.notifica VALUES
                                  (1,2,1,1,'Batteria bassa','Drone sotto 20%','AVVERTIMENTO','ALTA',false,now()),
                                  (2,3,2,2,'OK','Consegna completata','INFORMAZIONE','BASSA',true,now()),
                                  (3,4,3,3,'Errore','Guasto motore','ERRORE','CRITICA',false,now());
