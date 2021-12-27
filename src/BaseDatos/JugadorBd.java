package BaseDatos;

import modelos.Jugador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JugadorBd extends  Conexion{

    public JugadorBd() throws SQLException {
        super();
    }

    public void insertarJugador(Jugador jugador) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement("insert into jugador(nombre,puntos,estado_finalizado) value(?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, jugador.getNombre());
        ps.setInt(2, jugador.getAcumuladoPuntos());
        ps.setString(3, jugador.getEstadoFinalizacion());
        ps.execute();
        conexion.close();

    }

    public List<Jugador>  consultarRegistrosJUgadores() throws SQLException {
        Statement sentencia = conexion.createStatement();
        String consulta = "SELECT * FROM jugador";
        ResultSet rs = sentencia.executeQuery(consulta);
        List<Jugador> lstJugador = new ArrayList<>();
        while (rs.next()) {
            Jugador jugador = new Jugador();
            jugador.setNombre(rs.getString(2));
            jugador.setAcumuladoPuntos(rs.getInt(3));
            jugador.setEstadoFinalizacion(rs.getString(4));

            lstJugador.add(jugador);

        }
        return lstJugador;

    }


}
