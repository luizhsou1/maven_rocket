package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCPostgres {
    public static void main(String[] args) {
        try {
            String url = "jdbc:postgresql://localhost:5432/maven_rocket";
            Properties props = new Properties();
            props.setProperty("user", "maven_rocket");
            props.setProperty("password", "maven_rocket");
            // props.setProperty("ssl", "true");
            Connection conn = DriverManager.getConnection(url, props);
            System.out.println("Conexão realizada com sucesso!");

            String nome = "Luiz";
            Integer idade = 27;
            String insertSql = "INSERT INTO public.tab_cadastro (nome, idade) VALUES (?, ?);";

            PreparedStatement pst = conn.prepareStatement(insertSql);
            pst.setString(1, nome);
            pst.setInt(2, idade);

            pst.execute();
            System.out.println("Cadastro inserido com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
