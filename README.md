Esse é um projeto simples feito em Java pra controlar alunos e treinos numa academia. Ele conecta no banco MySQL pra guardar tudo certinho.
Possui:
Cadastro, edição, exclusão e listagem dos alunos.
Cadastro, exclusão e listagem dos treinos que são ligados aos alunos.
Conexão com banco MySQL usando JDBC.

Alunos
-Cadastrar aluno: você pode adicionar um novo aluno informando nome, email, CPF, data de nascimento e telefone.
-Listar alunos: mostra todos os alunos que já estão cadastrados no banco.
-Editar aluno: permite alterar as informações de um aluno já existente, usando o ID dele.
-Excluir aluno: remove um aluno do sistema pelo ID.

Treinos
-Cadastrar treino: é possível adicionar um treino para um aluno específico (usando o ID do aluno). Você informa o tipo de treino, a descrição, a duração (em minutos) e a data de início.
-Listar treinos por aluno: mostra todos os treinos de um aluno específico, informando o ID dele.
-Excluir treino: remove um treino específico do banco de dados, informando o ID do treino.

Sobre o banco de dados
-Tudo é salvo no MySQL, então os dados continuam salvos mesmo depois de fechar o sistema.
-A conexão já está configurada (usuário padrão root, sem senha).
-É importante que o banco chamado academia já esteja criado, com as tabelas aluno e treino.

Como funciona
-O sistema roda direto no console (linha de comando).
-As opções aparecem como um menu, e o usuário digita o número da opção que quer executar.
-O código já está pronto para funcionar localmente, basta garantir que o Java e o MySQL estejam instalados e rodando.



Tecnologia utilizada no seu desenvolvimento:
-Java ("24.0.1")
-MySQL (WampServer64)
-JDBC (pra conexão com o banco)

Para baixar:
Copiar no CMD: git clone https://github.com/QueirosOTP/Academia-Java.git

Crie o banco de dados
Abra o programa que você usa para gerenciar o MySQL (pode ser o phpMyAdmin ou pelo terminal).
Crie um banco chamado academia.

Para criar as tabelas no MySQL, utilize os seguintes dados:
CREATE TABLE aluno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(100),
    cpf VARCHAR(14),
    data_nascimento DATE,
    telefone VARCHAR(15)
);

CREATE TABLE treino (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_aluno INT,
    tipo VARCHAR(50),
    descricao TEXT,
    duracao INT,
    data_inicio DATE,
    FOREIGN KEY (id_aluno) REFERENCES aluno(id)
);

Baseado na estrutura:
| Campo            | Tipo         | O que é             |
| ---------------- | ------------ | ------------------- |
| Identificador    | INT (PK)     | Identificador único |
| nome             | VARCHAR(100) | Nome do aluno       |
| email            | VARCHAR(100) | Email               |
| cpf              | VARCHAR(14)  | CPF                 |
| data\_nascimento | DATE         | Data de nascimento  |
| telefone         | VARCHAR(15)  | Telefone            |

| Campo                     | Tipo        | O que é             |
| ------------------------- | ----------- | ------------------- |
| Identificador             | INT (PK)    | Identificador único |
| Identificador Aluno       | INT (FK)    | Qual aluno          |
| tipo                      | VARCHAR(50) | Tipo de treino      |
| descricao                 | TEXT        | Descrição do treino |
| duracao                   | INT         | Duração em minutos  |
| data\_inicio              | DATE        | Quando começa       |


Confere se o arquivo ConexaoBD.java tem o usuário, senha e endereço do banco certinho.

Configure a conexão com o banco. \/ Atualize as informações abaixo com seus dados:
private static final String URL = "jdbc:mysql://localhost:3306/academia";
private static final String USUARIO = "root";      // seu usuário do MySQL
private static final String SENHA = "";

Abra a IDE (NetBeans ou outros) e importe o projeto que foi clonado lá no início.

E por fim e não menos importante, execute o programa:
Execute a classe principal (main.java) para começar a rodar o sistema e teste suas funcionalidades:


Trabalho realizado pelos estudantes:
Felipe Queirós
Lorran Henrique Gutierre Bernal
Henrique Schmoller de Queiroz
Nikolas de Medeiros Vieira
