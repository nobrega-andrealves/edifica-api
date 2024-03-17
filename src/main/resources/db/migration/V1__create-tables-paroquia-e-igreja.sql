create table paroquia(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    dataCriacao datetime not null,
    ativo tinyint not null,

    primary key(id)
);

insert into paroquia
(
    nome, dataCriacao, ativo
)
values
(
    'PARÓQUIA SÃO SEBASTIÃO DE PIABETÁ','2024-03-15', 1
);

insert into paroquia
(
    nome, dataCriacao, ativo
)
values
(
    'PARÓQUIA NOSSA SENHORA APARECIDADE DE PIABETÁ','2024-03-15', 1
);

create table igreja (
    id bigint not null auto_increment,
    paroquia_id bigint not null,
    tipoIgreja  varchar(100) not null,
    nome varchar(100) not null,
    responsavel varchar(100) not null,
    telefone varchar(30),
    dataCriacao datetime not null,
    status varchar(100) not null,

    primary key(id)
)