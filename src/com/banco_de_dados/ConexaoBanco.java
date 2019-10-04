package com.banco_de_dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

    public Connection conexaoBanco() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/fj21", "root", "746PARDAL12canario");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
