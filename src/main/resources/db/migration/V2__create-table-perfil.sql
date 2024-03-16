create table perfil(
    id bigint not null auto_increment,
    nome  varchar(100) not null,
    descricao varchar(400) not null,
    dataCriacao datetime,
    ativo tinyint not null,
    primary key(id)
);

insert into perfil
(
    nome, descricao, dataCriacao, ativo
)
values
(
    'ADMINISTRADOR', 'ADMINISTRADOR DO SISTEMA','2024-03-15',1
);

insert into perfil
(
    nome, descricao, dataCriacao, ativo
)
values
(
    'SECRETARIO(A)', 'Secretário(a) da paróquia, igreja ou capela','2024-03-15',1
);

insert into perfil
(
    nome, descricao, dataCriacao, ativo
)
values
(
    'PADRE', 'Padre','2024-03-15',1
);

insert into perfil
(
    nome, descricao, dataCriacao, ativo
)
values
(
    'RESPONSÁVEL', 'Responsável','2024-03-15',1
);

insert into perfil
(
    nome, descricao, dataCriacao, ativo
)
values
(
    'MEMBRO', 'Membro da paróquia, igreja ou capela','2024-03-15',1
);