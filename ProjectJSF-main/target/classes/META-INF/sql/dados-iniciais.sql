-- Inserções na tabela `usuario`
INSERT INTO usuario(id, nome, email, senha, tipo) VALUES (1, 'Administrador da Costa', 'admin@gmail.com', 'admin123', 'ADMINISTRADOR');
INSERT INTO usuario(id, nome, email, senha, tipo) VALUES (2, 'Ana Paula', 'ana@gmail.com', 'ana1234', 'COMPRADOR');
INSERT INTO usuario(id, nome, email, senha, tipo) VALUES (3, 'Pedro da Silva', 'pedro@gmail.com', 'pedro123', 'VENDEDOR');
INSERT INTO usuario(id, nome, email, senha, tipo) VALUES (4, 'André Martins', 'andre@gmail.com', 'andre1234', 'VENDEDOR');

-- Inserções na tabela `produto`
INSERT INTO produto(id, nome, preco, descricao, vendedor_id) VALUES (1, 'Computador', 500.00, 'Computador De Mesa', 3);
INSERT INTO produto(id, nome, preco, descricao, vendedor_id) VALUES (2, 'Fone', 20.00, 'Fone de ouvido super', 4);
INSERT INTO produto(id, nome, preco, descricao, vendedor_id) VALUES (3, 'Mouse', 80.00, 'Mouse preto', 3);
INSERT INTO produto(id, nome, preco, descricao, vendedor_id) VALUES (4, 'Monitor', 500.00, 'Monitor preto 24P', 4);
