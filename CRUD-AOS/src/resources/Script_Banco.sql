create database cidadaoBD

create table cidadao 
(
   cid_cpf varchar(15) primary key not null, 
   cid_nome varchar (25) not null,
   cid_telefone varchar(12) not null,
   cid_cep int not null
)

select * from cidadao