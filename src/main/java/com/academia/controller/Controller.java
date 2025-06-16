/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.academia.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Controller  {
    private static final String URL = "jdbc:mysql://localhost:3306/academia"; // substitua "academia" pelo nome do seu banco
    private static final String USUARIO = "root"; // ou seu usuário MySQL
    private static final String SENHA = ""; // senha do seu MySQL (vazio se não tiver)

    public static Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // importante: carrega o driver
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
        return null;
    }
}
