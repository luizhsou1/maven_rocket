package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class FabricaConexao {
    private static Connection conexao;

    public static void conectar() {
        try {
            if (conexao == null) {
                String url = "jdbc:postgresql://localhost:5432/maven_rocket";
                Properties props = new Properties();
                props.setProperty("user", "maven_rocket");
                props.setProperty("password", "maven_rocket");
                // props.setProperty("ssl", "true");
                conexao = DriverManager.getConnection(url, props);
                System.out.println("Conexão realizada com sucesso!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConexao() {
        return conexao;
    }
}
