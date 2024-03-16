create table pessoa (
    id bigint not null auto_increment,
    nome  varchar(100) not null,
    cpf varchar(11) not null unique,
    dataNascimento datetime not null,
    sexo char(1),
    idPerfil bigint not null,
    idIgreja bigint not null,
    dataInicioMembro datetime,
    ativo tinyint not null,
    primary key(id),
    INDEX FK_PESSOAXPERFIL(idPerfil),
    INDEX FK_PESSOAXIGREJA(idIgreja),
    FOREIGN KEY(idPerfil) REFERENCES perfil(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY(idIgreja) REFERENCES igreja(id) ON DELETE NO ACTION ON UPDATE NO ACTION
)