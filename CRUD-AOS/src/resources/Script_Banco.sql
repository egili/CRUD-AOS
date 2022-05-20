create database cidadaoBD

create table cidadao 
(
   cid_cpf varchar(15) primary key not null, 
   cid_nome varchar (50) not null,
   cid_telefone varchar(12) not null,
   cid_numeroDaCasa int,
   cid_complemento varchar(15),
   cid_cep varchar (10) not null
)

select * from cidadao