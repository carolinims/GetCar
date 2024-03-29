Insert into perfil (tipo_usuario) values ('ADMINISTRADOR');
Insert into perfil (tipo_usuario) values ('CLIENTE');
Insert into perfil (tipo_usuario) values ('ATENDENTE');
Insert into perfil (tipo_usuario) values ('GERENTE');


Insert into usuario (login, senha) 
values ('carolini.silva', '$2a$10$gP18//wDwKbWL7Ro4QjqFug568TsxR16Zt9m6HgYmqq/dMjAc6leS');

Insert into usuario_perfis (usuario_id_usuario, perfis_id)
values (1, 1);

INSERT INTO ENDERECO (cep, cidade, complemento, estado, logradouro, numero)
VALUES ('02390622', 'Itaquaquecetuba', 'casa', 'São Paulo', 'Rua Gov. Adhemar de Barros', 115);

INSERT INTO CLIENTE (cnh, data_nasc, documento, genero, nacionalidade, nome, telefone, id_usuario, endereco_id) 
VALUES ('654321', '1991-11-27 18:47:52.69', 12345678998, 'Feminino', 'Brasileira', 'Carolini Moraes da Silva', 1183384403, 1, 1);



Insert into usuario (login, senha) 
values ('cacauzinha', '$2a$10$gP18//wDwKbWL7Ro4QjqFug568TsxR16Zt9m6HgYmqq/dMjAc6leS');

Insert into usuario_perfis (usuario_id_usuario, perfis_id)
values (2, 2);

INSERT INTO ENDERECO (cep, cidade, complemento, estado, logradouro, numero)
VALUES ('02390622', 'São Sebastião', 'casa', 'São Paulo', 'Rua da praia', 220);

INSERT INTO CLIENTE (cnh, data_nasc, documento, genero, nacionalidade, nome, telefone, id_usuario, endereco_id) 
VALUES ('654321', '1993-11-29 18:47:52.69', 12345678998, 'Feminino', 'Brasileira', 'Cacauzinha da silva', 1183384403, 2, 2);



Insert into usuario (login, senha) 
values ('maluzinha', '$2a$10$gP18//wDwKbWL7Ro4QjqFug568TsxR16Zt9m6HgYmqq/dMjAc6leS');

Insert into usuario_perfis (usuario_id_usuario, perfis_id)
values (3, 1);

INSERT INTO ENDERECO (cep, cidade, complemento, estado, logradouro, numero)
VALUES ('02390622', 'Itaquaquecetuba', 'casa', 'São Paulo', 'Rua da praia', 220);

INSERT INTO CLIENTE (cnh, data_nasc, documento, genero, nacionalidade, nome, telefone, id_usuario, endereco_id) 
VALUES ('654321', '2021-11-29 18:47:52.69', 12345678998, 'Feminino', 'Brasileira', 'Maluzinha da silva', 1183384403, 3, 3);

-- Insert agencia automotiva
Insert into agencia_automotiva(nome_agencia, endereco_id) values ('Agencia Get Car Itaquá Centro', 1);

-- Insert modelo do veiculo
Insert into modelo (categoria, descr_modelo, marca, tipo_combustivel, tipo_motorizacao) values
('HATCH',  'Veiculos do tipo HatchBack', 'TOYOTA',  'FLEX',  'MOTOR_1_4');

insert into modelo (categoria, descr_modelo, marca, tipo_combustivel, tipo_motorizacao) values 
('SEDAN', 'Honda Civic 2021', 'HONDA', 'FLEX', 'MOTOR_1_4');
