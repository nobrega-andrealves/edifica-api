create table usuario(
    id bigint not null auto_increment,
    pessoa_id bigint not null,
    login varchar(100) not null unique,
    senha varchar(255) not null,
    dataCriacao datetime,
    primary key(id),
    INDEX FK_USUARIOXPESSOA(pessoa_id),
    FOREIGN KEY(pessoa_id) REFERENCES pessoa(id) ON DELETE NO ACTION ON UPDATE NO ACTION
);