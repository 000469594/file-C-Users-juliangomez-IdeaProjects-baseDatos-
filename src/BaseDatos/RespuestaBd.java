package BaseDatos;

import modelos.Respuesta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RespuestaBd extends  Conexion {

    public RespuestaBd() throws SQLException {
        super();
    }

    public void insertarRespuesta(Respuesta respuesta) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement("insert into respuestas(fk_pregunta,respuesta,es_verdadera) value(?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, respuesta.getId_pregunta());
        ps.setString(2, respuesta.getRespuesta());
        ps.setInt(3, respuesta.getEsVedadera());
        ps.execute();
        conexion.close();

    }

    public List<Respuesta> obtenerRespuestasPregunta(int id_pregunta) throws SQLException {
        List<Respuesta> lstRespuesta = new ArrayList<>();

        Statement sentencia = conexion.createStatement();
        String consulta = "SELECT * FROM respuestas  WHERE fk_pregunta ="+ id_pregunta;
        ResultSet rs=sentencia.executeQuery(consulta);
        while (rs.next())
        {
            Respuesta respuesta = new Respuesta();
            respuesta.setId_respuesta(rs.getInt(1));
            respuesta.setId_pregunta(rs.getInt(2));
            respuesta.setRespuesta(rs.getString(3));
            respuesta.setEsVedadera(rs.getInt(4));
            lstRespuesta.add(respuesta);

        }
        return  lstRespuesta;


    }
}
