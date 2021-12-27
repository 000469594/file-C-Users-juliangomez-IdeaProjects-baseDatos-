package negocio;

import BaseDatos.JugadorBd;
import modelos.Jugador;

import java.sql.SQLException;
import java.util.List;

public class RegistroHistorico {


    public void registrarJugador(Jugador jugador) throws SQLException {
        JugadorBd jugadorBd = new JugadorBd();
        jugadorBd.insertarJugador(jugador);
    }

    public List<Jugador> obtenerRegistroHistorico() throws SQLException {
        JugadorBd jugadorBd = new JugadorBd();
        return jugadorBd.consultarRegistrosJUgadores();
    }
}
