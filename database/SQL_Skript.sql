CREATE DATABASE Datenbank_APS;
USE Datenbank_APS;


DROP TABLE IF EXISTS `Groessen`;
CREATE table Groessen (
Paketgroesse varchar(3) NOT NULL,
Min_Gurtmass int NOT NULL,
Max_Gurtmass int NOT NULL
);

LOCK TABLES 'Groessen' WRITE;
INSERT INTO Groessen(Paketgroesse, Min_Gurtmass, Max_Gurtmass) 
values ('XS', 0, 35),
('S',35,50),
('M',50,65),
('L',65,80),
('XL',80,300);
UNLOCK TABLES;

/* SELECT Paketgroesse from Groessen where Min_Gurtmass >= 20 AND Max_Gurtmass < 20;
*/

CREATE USER www-data@localhost IDENTIFIED BY 'SWA2018mysql';
GRANT SELECT ON 'www-data'.* TO 'parcel'@'%';
FLUSH PRIVILEGES;


