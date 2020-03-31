CREATE TABLE estado (
    codigo BIGINT(30) PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    sigla VARCHAR(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE cidade (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    codigo_estado BIGINT(20) NOT NULL,
    FOREIGN KEY (codigo_estado) REFERENCES estado(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO estado (codigo, nome, sigla) VALUES (1,'Acores', 'ACR');
INSERT INTO estado (codigo, nome, sigla) VALUES (2,'Aveiro', 'AV');
INSERT INTO estado (codigo, nome, sigla) VALUES (3,'Beja', 'BEJ');
INSERT INTO estado (codigo, nome, sigla) VALUES (4,'Braga', 'BRG');
INSERT INTO estado (codigo, nome, sigla) VALUES (5,'Braganca', 'BRGC');
INSERT INTO estado (codigo, nome, sigla) VALUES (6,'Coimbra', 'CMBR');	
INSERT INTO estado (codigo, nome, sigla) VALUES (7,'Castelo Branco', 'CSTBRNC');
INSERT INTO estado (codigo, nome, sigla) VALUES (8,'Evora', 'EVR');
INSERT INTO estado (codigo, nome, sigla) VALUES (9,'Faro', 'FRO');
INSERT INTO estado (codigo, nome, sigla) VALUES (10,'Guarda', 'GRD');
INSERT INTO estado (codigo, nome, sigla) VALUES (11,'Leiria', 'LRA');
INSERT INTO estado (codigo, nome, sigla) VALUES (12,'Lisboa', 'LSB');
INSERT INTO estado (codigo, nome, sigla) VALUES (13,'Madeira', 'MDR');
INSERT INTO estado (codigo, nome, sigla) VALUES (14,'Porto', 'PRT');
INSERT INTO estado (codigo, nome, sigla) VALUES (15,'Porto Alegre', 'PRTALGR');
INSERT INTO estado (codigo, nome, sigla) VALUES (16,'Santarem', 'SNTR');
INSERT INTO estado (codigo, nome, sigla) VALUES (17,'Setubal', 'STB');
INSERT INTO estado (codigo, nome, sigla) VALUES (18,'Vila Real', 'VLRL');
INSERT INTO estado (codigo, nome, sigla) VALUES (19,'Viana do Castelo', 'VNCST');
INSERT INTO estado (codigo, nome, sigla) VALUES (20,'Viseu', 'VSU');


