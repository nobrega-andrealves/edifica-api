create table igreja (
    id bigint not null auto_increment,
    tipoIgreja  varchar(100) not null,
    nome varchar(100) not null,
    responsavel varchar(100) not null,
    telefone varchar(30),
    dataCriacao datetime not null,
    status varchar(100) not null,

    primary key(id)
)