create table endereco (
    id bigint not null auto_increment,
    pessoa_id bigint not null,
    cep char(8) not null,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    complemento varchar(30),
    numero varchar(10),
    idCidade bigint not null,
    dataCriacao datetime,
    ativo tinyint not null,
    primary key(id),
    INDEX FK_ENDERECOXPESSOA(pessoa_id),
    FOREIGN KEY(pessoa_id) REFERENCES pessoa(id) ON DELETE NO ACTION ON UPDATE NO ACTION
);