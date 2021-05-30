DROP TABLE vehicles;
CREATE TABLE vehicles(id int auto_increment, mark varchar(255), model varchar(255), color varchar(255), year int, PRIMARY KEY (id));
INSERT INTO vehicles(mark, model, color, year) VALUES ('Citroen', 'C4', 'Brązowy', 2012);
INSERT INTO vehicles(mark, model, color, year) VALUES ('Volvo', 'XC70', 'Zielony', 2008);
