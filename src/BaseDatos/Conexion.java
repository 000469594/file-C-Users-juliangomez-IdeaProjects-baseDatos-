package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    protected Connection conexion;
    String  puerto = "3306";
    String nombreBd = "juegopreguntas";
    String user = "root";
    String password = "";

    public Conexion() throws SQLException {
        conexionBd();
    }


    private void conexionBd() throws SQLException {

        conexion = DriverManager.getConnection("jdbc:mysql://localhost:"+ puerto + "/" + nombreBd,user,password);
    }

}
