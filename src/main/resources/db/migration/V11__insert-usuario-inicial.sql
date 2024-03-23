insert into
    pessoa
    (
        nome, cpf, dataNascimento, sexo, idPerfil, idIgreja, dataInicioMembro, ativo
    )
values
    (
        'ADMINISTRADOR', 98765432100, '2023-03-22', 'M', 1, 1,  '2024-03-22', 1
    );

insert into
    usuario
    (
        pessoa_id, login, senha, dataCriacao
    )
values
    (
        1, 'andre@teste.com.br', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.','2024-03-20'
    );