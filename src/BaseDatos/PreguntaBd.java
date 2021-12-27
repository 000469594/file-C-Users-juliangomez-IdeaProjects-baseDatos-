package BaseDatos;

import modelos.Pregunta;

import java.sql.*;

public class PreguntaBd extends  Conexion{

    private int idPregunta;

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public PreguntaBd() throws SQLException {
       super();
    }

    public void insertarPregunta(Pregunta pregunta) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement("insert into pregunta(fk_categoria,pregunta) value(?,?)", Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, pregunta.getId_categoria());
        ps.setString(2, pregunta.getPregunta());
        ps.execute();
        ResultSet rs;
        rs = ps.getGeneratedKeys();
        if (rs != null && rs.next()) {
            idPregunta = rs.getInt(1);

        }

        conexion.close();

    }

    public  Pregunta obtenerPreguntaAleatoria(int idCategoria) throws SQLException {
        Statement sentencia = conexion.createStatement();
        Pregunta pregunta = new Pregunta();
        String consulta = "SELECT * FROM pregunta  WHERE fk_categoria ="+ idCategoria + " ORDER BY rand() LIMIT 1";
        ResultSet rs=sentencia.executeQuery(consulta);
        while (rs.next())
        {
            pregunta.setId_pregunta(rs.getInt(1));
            pregunta.setId_categoria(rs.getInt(2));
            pregunta.setPregunta(rs.getString(3));

        }

        return pregunta;



    }


}
