create table telefone(
    id bigint not null auto_increment,
    pessoa_id bigint not null,
    numeroTelefone varchar(100) not null unique,
    dataCriacao datetime,
    ativo tinyint not null,
    primary key(id),
    INDEX FK_TELEFONEXPESSOA(pessoa_id),
    FOREIGN KEY(pessoa_id) REFERENCES pessoa(id) ON DELETE NO ACTION ON UPDATE NO ACTION
);