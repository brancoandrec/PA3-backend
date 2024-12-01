INSERT INTO local_armazen (id, sala, armario) VALUES (1, 'A1', '33');
INSERT INTO local_armazen (id, sala, armario) VALUES (2, 'B2', '44');
INSERT INTO local_armazen (id, sala, armario) VALUES (3, 'C3', '55');
INSERT INTO local_armazen (id, sala, armario) VALUES (4, 'D4', '66');
INSERT INTO local_armazen (id, sala, armario) VALUES (5, 'E5', '77');
INSERT INTO local_armazen (id, sala, armario) VALUES (6, 'F6', '88');
INSERT INTO local_armazen (id, sala, armario) VALUES (7, 'G7', '99');
INSERT INTO local_armazen (id, sala, armario) VALUES (8, 'H8', '100');
INSERT INTO local_armazen (id, sala, armario) VALUES (9, 'I9', '111');
INSERT INTO local_armazen (id, sala, armario) VALUES (10, 'J10', '122');

INSERT INTO item (id, nome, descricao, tipo) VALUES (1, 'Resistor', 'Componente eletrônico utilizado para limitar a corrente elétrica em um circuito.', 'Eletrônico');
INSERT INTO item (id, nome, descricao, tipo) VALUES (2, 'Microcontrolador', 'Dispositivo programável utilizado para controlar sistemas eletrônicos.', 'Eletrônico');
INSERT INTO item (id, nome, descricao, tipo) VALUES (3, 'Fonte de Alimentação', 'Equipamento responsável por fornecer energia elétrica a circuitos e dispositivos.', 'Eletrônico');
INSERT INTO item (id, nome, descricao, tipo) VALUES (4, 'Placa de Circuito Impresso', 'Placa utilizada para conectar componentes eletrônicos de forma estruturada.', 'Eletrônico');
INSERT INTO item (id, nome, descricao, tipo) VALUES (5, 'Sensor de Temperatura', 'Dispositivo usado para medir a temperatura de um ambiente ou objeto.', 'Sensor');
INSERT INTO item (id, nome, descricao, tipo) VALUES (6, 'Cabo USB', 'Cabo usado para a transferência de dados e fornecimento de energia entre dispositivos eletrônicos.', 'Acessório');
INSERT INTO item (id, nome, descricao, tipo) VALUES (7, 'LED', 'Diodo emissor de luz, utilizado em display e iluminação em dispositivos eletrônicos.', 'Componente');
INSERT INTO item (id, nome, descricao, tipo) VALUES (8, 'Raspberry Pi', 'Computador de placa única utilizado para prototipagem e automação.', 'Computador');
INSERT INTO item (id, nome, descricao, tipo) VALUES (9, 'Servo Motor', 'Motor de controle preciso usado em projetos de robótica e automação.', 'Componente');
INSERT INTO item (id, nome, descricao, tipo) VALUES (10, 'Arduino', 'Plataforma de prototipagem eletrônica de código aberto baseada em microcontroladores.', 'Microcontrolador');


INSERT INTO fornecedor (id, nome, contato, endereco) VALUES (1, 'ElectroTech Supplies', 'contato@electrotech.com', 'Rua das Indústrias, 123, São Paulo, SP');
INSERT INTO fornecedor (id, nome, contato, endereco) VALUES (2, 'TechnoParts', 'atendimento@technoparts.com', 'Avenida das Tecnologias, 456, Campinas, SP');
INSERT INTO fornecedor (id, nome, contato, endereco) VALUES (3, 'Robotics World', 'vendas@roboticsworld.com', 'Rua da Inovação, 789, Rio de Janeiro, RJ');
INSERT INTO fornecedor (id, nome, contato, endereco) VALUES (4, 'CircuitLab Components', 'suporte@circuitlab.com', 'Rua do Circuito, 101, Belo Horizonte, MG');
INSERT INTO fornecedor (id, nome, contato, endereco) VALUES (5, 'Smart Electronics', 'comercial@smartelectronics.com', 'Avenida da Eletrônica, 202, Curitiba, PR');
INSERT INTO fornecedor (id, nome, contato, endereco) VALUES (6, 'FutureTech Parts', 'contato@futuretechparts.com', 'Praça das Startups, 303, Porto Alegre, RS');
INSERT INTO fornecedor (id, nome, contato, endereco) VALUES (7, 'TechPart Solutions', 'vendas@techpartsolutions.com', 'Rua das Inovações, 404, Florianópolis, SC');
INSERT INTO fornecedor (id, nome, contato, endereco) VALUES (8, 'MicroDevices', 'suporte@microdevices.com', 'Avenida Microeletrônica, 505, Recife, PE');
INSERT INTO fornecedor (id, nome, contato, endereco) VALUES (9, 'Digital Parts Store', 'atendimento@digitalpartsstore.com', 'Rua Digital, 606, Fortaleza, CE');
INSERT INTO fornecedor (id, nome, contato, endereco) VALUES (10, 'Robotic Solutions', 'comercial@roboticsolutions.com', 'Rua da Robótica, 707, Salvador, BA');

INSERT INTO projeto (id, data_inicio, descricao, nome) VALUES (1, '2024-01-10', 'Desenvolvimento de uma plataforma de e-commerce para pequenos negócios.', 'Plataforma EcomPlus');
INSERT INTO projeto (id, data_inicio, descricao, nome) VALUES (2, '2024-02-15', 'Criação de um sistema de gestão de tarefas colaborativas para equipes remotas.', 'TaskMaster');
INSERT INTO projeto (id, data_inicio, descricao, nome) VALUES (3, '2024-03-01', 'Desenvolvimento de uma aplicação de monitoramento de saúde baseada em inteligência artificial.', 'HealthTrack AI');
INSERT INTO projeto (id, data_inicio, descricao, nome) VALUES (4, '2024-04-05', 'Implementação de uma rede de sensores IoT para controle inteligente de energia.', 'IoT SmartEnergy');
INSERT INTO projeto (id, data_inicio, descricao, nome) VALUES (5, '2024-05-12', 'Criação de um sistema de blockchain para rastreamento de supply chain.', 'SupplyChain Block');
INSERT INTO projeto (id, data_inicio, descricao, nome) VALUES (6, '2024-06-01', 'Desenvolvimento de uma solução de pagamento digital via smartphone com segurança biométrica.', 'PaySecure Mobile');
INSERT INTO projeto (id, data_inicio, descricao, nome) VALUES (7, '2024-07-20', 'Projeto de automação de atendimento ao cliente utilizando chatbots e inteligência artificial.', 'AutoChatbot');
INSERT INTO projeto (id, data_inicio, descricao, nome) VALUES (8, '2024-08-10', 'Desenvolvimento de uma plataforma de ensino online com cursos interativos e gamificação.', 'EducaGame');
INSERT INTO projeto (id, data_inicio, descricao, nome) VALUES (9, '2024-09-05', 'Criação de um sistema de recomendação de produtos com base em inteligência de dados.', 'SmartRecTech');
INSERT INTO projeto (id, data_inicio, descricao, nome) VALUES (10, '2024-10-18', 'Implementação de um software de automação para processos de RH, incluindo recrutamento e gestão de pessoal.', 'HRAutoTech');


INSERT INTO compra (id, preco, data_compra, data_recebimento, data_invoice, fornecedor_id, projeto_id)
VALUES (1, 15000, '2024-01-01', '2024-01-05', '2024-01-03', 1, 1);

INSERT INTO compra (id, preco, data_compra, data_recebimento, data_invoice, fornecedor_id, projeto_id)
VALUES (2, 20000, '2024-01-10', '2024-01-12', '2024-01-11', 2, 2);

INSERT INTO compra (id, preco, data_compra, data_recebimento, data_invoice, fornecedor_id, projeto_id)
VALUES (3, 12000, '2024-01-15', '2024-01-17', '2024-01-16', 3, 3);

INSERT INTO compra (id, preco, data_compra, data_recebimento, data_invoice, fornecedor_id, projeto_id)
VALUES (4, 18000, '2024-01-20', '2024-01-23', '2024-01-22', 1, 4);

INSERT INTO compra (id, preco, data_compra, data_recebimento, data_invoice, fornecedor_id, projeto_id)
VALUES (5, 17000, '2024-01-25', '2024-01-28', '2024-01-27', 2, 5);

INSERT INTO compra (id, preco, data_compra, data_recebimento, data_invoice, fornecedor_id, projeto_id)
VALUES (6, 25000, '2024-02-01', '2024-02-03', '2024-02-02', 3, 1);

INSERT INTO compra (id, preco, data_compra, data_recebimento, data_invoice, fornecedor_id, projeto_id)
VALUES (7, 30000, '2024-02-05', '2024-02-08', '2024-02-07', 1, 2);

INSERT INTO compra (id, preco, data_compra, data_recebimento, data_invoice, fornecedor_id, projeto_id)
VALUES (8, 22000, '2024-02-10', '2024-02-13', '2024-02-12', 2, 3);

INSERT INTO compra (id, preco, data_compra, data_recebimento, data_invoice, fornecedor_id, projeto_id)
VALUES (9, 19000, '2024-02-15', '2024-02-18', '2024-02-17', 3, 4);

INSERT INTO compra (id, preco, data_compra, data_recebimento, data_invoice, fornecedor_id, projeto_id)
VALUES (10, 21000, '2024-02-20', '2024-02-23', '2024-02-22', 1, 5);


INSERT INTO compra_item (compra_id, item_id) VALUES (1, 1);
INSERT INTO compra_item (compra_id, item_id) VALUES (1, 2);

INSERT INTO compra_item (compra_id, item_id) VALUES (2, 3);
INSERT INTO compra_item (compra_id, item_id) VALUES (2, 4);

INSERT INTO compra_item (compra_id, item_id) VALUES (3, 5);
INSERT INTO compra_item (compra_id, item_id) VALUES (3, 6);

INSERT INTO compra_item (compra_id, item_id) VALUES (4, 7);
INSERT INTO compra_item (compra_id, item_id) VALUES (4, 8);

INSERT INTO compra_item (compra_id, item_id) VALUES (5, 9);
INSERT INTO compra_item (compra_id, item_id) VALUES (5, 10);

INSERT INTO compra_item (compra_id, item_id) VALUES (6, 2);
INSERT INTO compra_item (compra_id, item_id) VALUES (6, 4);

INSERT INTO compra_item (compra_id, item_id) VALUES (7, 3);
INSERT INTO compra_item (compra_id, item_id) VALUES (7, 7);

INSERT INTO compra_item (compra_id, item_id) VALUES (8, 1);
INSERT INTO compra_item (compra_id, item_id) VALUES (8, 5);

INSERT INTO compra_item (compra_id, item_id) VALUES (9, 6);
INSERT INTO compra_item (compra_id, item_id) VALUES (9, 8);

INSERT INTO compra_item (compra_id, item_id) VALUES (10, 9);
INSERT INTO compra_item (compra_id, item_id) VALUES (10, 10);



INSERT INTO conjunto_itens (id, quantidade, item_id, local_armazen_id, projeto_id)
VALUES (1, 50, 1, 1, 1);

INSERT INTO conjunto_itens (id, quantidade, item_id, local_armazen_id, projeto_id)
VALUES (2, 30, 2, 2, 1);

INSERT INTO conjunto_itens (id, quantidade, item_id, local_armazen_id, projeto_id)
VALUES (3, 20, 3, 3, 2);

INSERT INTO conjunto_itens (id, quantidade, item_id, local_armazen_id, projeto_id)
VALUES (4, 15, 4, 1, 2);

INSERT INTO conjunto_itens (id, quantidade, item_id, local_armazen_id, projeto_id)
VALUES (5, 60, 5, 2, 3);

INSERT INTO conjunto_itens (id, quantidade, item_id, local_armazen_id, projeto_id)
VALUES (6, 25, 6, 3, 3);

INSERT INTO conjunto_itens (id, quantidade, item_id, local_armazen_id, projeto_id)
VALUES (7, 40, 7, 1, 4);

INSERT INTO conjunto_itens (id, quantidade, item_id, local_armazen_id, projeto_id)
VALUES (8, 35, 8, 2, 4);

INSERT INTO conjunto_itens (id, quantidade, item_id, local_armazen_id, projeto_id)
VALUES (9, 45, 9, 3, 5);

INSERT INTO conjunto_itens (id, quantidade, item_id, local_armazen_id, projeto_id)
VALUES (10, 10, 10, 1, 5);
