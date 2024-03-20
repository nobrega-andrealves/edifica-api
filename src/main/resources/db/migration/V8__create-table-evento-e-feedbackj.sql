create table evento(
    id bigint not null auto_increment,
    igreja_id bigint not null,
    nome varchar(100),
    descricao varchar(400),
    dataCriacao datetime not null,
    dataEvento datetime not null,
    horaEvento char(5) not null,
    ativo tinyint not null,
    primary key(id),
    INDEX FK_EVENTOXIGREJA(igreja_id),
    FOREIGN KEY(igreja_id) REFERENCES igreja(id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

create table feedback(
    id bigint not null auto_increment,
    evento_id bigint not null,
    pessoa_id bigint not null,
    notaEvento tinyint,
    oQueMaisGostou varchar(400),
    oQueMenosGostou varchar(400),
    outrosComentarios varchar(400),
    primeiraVez tinyint,
    indicariaEvento tinyint,
    dataCriacao datetime,
    primary key(id),
    INDEX FK_FEEDBACKXEVENTO(evento_id),
    FOREIGN KEY(evento_id) REFERENCES evento(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    INDEX FK_FEEDBACKXPESSOA(pessoa_id),
    FOREIGN KEY(pessoa_id) REFERENCES pessoa(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    UNIQUE INDEX uidx_evento_e_pessoa (evento_id, pessoa_id)
);