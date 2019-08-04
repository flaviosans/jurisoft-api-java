CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

drop table if exists telefone;
drop table if exists email;
drop table if exists cidade;
drop table if exists estado;
drop table if exists endereco;
drop table if exists pessoa;

drop table if exists processo;
drop table if exists pergunta;
drop table if exists alternativa;
drop table if exists questionario;

create table pessoa(
                       id uuid not null unique default uuid_generate_v4(),
                       nome varchar(220) not null,
                       cpf varchar(11),
                       rg varchar(15),
                       carteira_de_trabalho varchar(55),
                       pis varchar(55),
                       profissao varchar(55),
                       data_de_nascimento timestamp not null,
                       sexo varchar(25)
);

create table endereco(
                         id uuid not null unique default uuid_generate_v4(),
                         descricao varchar(220),
                         logradouro varchar(220) not null,
                         complemento varchar(220),
                         bairro varchar(220),
                         pessoa_id uuid not null,
                         --cidade_id integer not null,
                         foreign key (pessoa_id) references pessoa(id));

create table estado(
                       id serial unique not null,
                       nome varchar(25) not null,
                       sigla varchar(2)
);
create table cidade(
                       id serial not null,
                       nome varchar(220) not null,
                       estado_id integer not null,
                       foreign key (estado_id) references estado(id)
);

create table email(
                      id uuid not null unique default uuid_generate_v4(),
                      descricao varchar(55),
                      endereco varchar(220) not null,
                      pessoa_id uuid not null,
                      foreign key (pessoa_id) references pessoa(id)
);

create table telefone(
                         id uuid not null default uuid_generate_v4(),
                         descricao varchar(55),
                         numero varchar(55),
                         pessoa_id uuid not null,
                         foreign key (pessoa_id) references pessoa(id)
);

create table questionario(
    id uuid not null unique default uuid_generate_v4(),
    nome varchar(55) not null,
    descricao varchar(220)
);

create table pergunta(
    id uuid not null default uuid_generate_v4(),
    nome varchar(110) not null,
    questionario_id uuid not null,
    foreign key (questionario_id) references questionario(id)
);

create table alternativa(
    id uuid not null default uuid_generate_v4(),
    nome varchar(110) not null,
    ordem int not null
)
