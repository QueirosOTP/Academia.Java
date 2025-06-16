package com.academia.controller;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args) {
        try {
            Connection conexao = ConexaoBD.conectar();
            if (conexao != null) {
                System.out.println("Conexão realizada com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
        }
    }
}