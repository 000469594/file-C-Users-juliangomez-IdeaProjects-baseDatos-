package BaseDatos;

import modelos.Categoria;

import java.sql.*;

public class CategoriaBd  extends  Conexion{

    private int idCategoria;


    public CategoriaBd() throws SQLException {
        super();
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void insertarCategoria(Categoria categoria) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement("insert into categoria(nivel) value(?)", Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, categoria.getNivel());
        ps.execute();
        ResultSet rs;
        rs = ps.getGeneratedKeys();
        if (rs != null && rs.next()) {
            idCategoria = rs.getInt(1);

        }

        conexion.close();

    }

    public int  obtenerCategoria(int nivel) throws SQLException {
        Statement sentencia = conexion.createStatement();
        String consulta = "SELECT id_categoria FROM categoria  WHERE nivel =" + nivel;
        ResultSet rs = sentencia.executeQuery(consulta);
        int identificadorCategoria = 0;
        while (rs.next()) {
            identificadorCategoria = rs.getInt(1);

        }
        return identificadorCategoria;

    }
}