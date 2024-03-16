create table email(
    id bigint not null auto_increment,
    pessoa_id bigint not null,
    enderecoEmail varchar(100) not null unique,
    dataCriacao datetime,
    ativo tinyint not null,
    primary key(id),
    INDEX FK_EMAILXPESSOA(pessoa_id),
    FOREIGN KEY(pessoa_id) REFERENCES pessoa(id) ON DELETE NO ACTION ON UPDATE NO ACTION
)