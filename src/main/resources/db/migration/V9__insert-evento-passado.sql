insert into
    igreja
    (paroquia_id, tipoIgreja, nome, responsavel, telefone, dataCriacao, status)
values
    (1, 'MATRIZ', 'PARÓQUIA SÃO SEBASTIÃO DE PIABETÁ', 'TESTE', '(21) 92233-4455', '2024-03-24', 'ATIVA');

insert into
    evento
    (
        ativo, dataCriacao, dataEvento, descricao, horaEvento, igreja_id, nome
    )
values
    (
        1, '2024-03-19', '2024-01-20',
        'Festa tradicional que ocorre no mês de janeiro, com seu auge no dia de São Sebastião. Conta, geralmente, com a procissão, e missa e logo após um show ao vivo, encerrando com a queima de fogos.',
        '17:00', 1, 'Festa do Padroeiro São Sebastião'
    );