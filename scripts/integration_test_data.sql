CREATE DATABASE Datenbank_APS;

-- Create remote user
CREATE USER 'www-data'@'localhost' IDENTIFIED BY 'SWA2018'; 
CREATE USER 'www-data'@'%' IDENTIFIED BY 'SWA2018';

-- Set user permissions
GRANT ALL ON parcelsizeDB.* TO 'www-data'@'localhost';
GRANT ALL ON parcelsizeDB.* TO 'www-data'@'%';

USE Datenbank_APS; 

-- Create the table with the parcel sizes
CREATE table Groessen (
Paketgroesse varchar(3) NOT NULL,
Min_Gurtmass int NOT NULL,
Max_Gurtmass int NOT NULL
);

-- Insert test data
LOCK TABLES 'Groessen' WRITE;
INSERT INTO Groessen(Paketgroesse, Min_Gurtmass, Max_Gurtmass) 
values 
('XS', 0, 35),
('S',35,50),
('M',50,65),
('L',65,80),
('XL',80,300);
UNLOCK TABLES;