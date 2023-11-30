/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

     public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/hospital_uc12";
        String user = "root";
        String password = "250580";
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

}
