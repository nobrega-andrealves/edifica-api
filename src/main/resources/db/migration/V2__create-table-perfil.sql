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