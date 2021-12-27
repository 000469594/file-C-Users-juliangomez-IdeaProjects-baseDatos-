package negocio;

import BaseDatos.CategoriaBd;
import BaseDatos.PreguntaBd;
import BaseDatos.RespuestaBd;
import modelos.Categoria;
import modelos.Pregunta;
import modelos.Respuesta;

import java.sql.SQLException;

import java.util.Scanner;

public class ConfiguracionJuego {

    private int id_categoria;
    private int id_pregunta;

    public int getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public void ingresarCategoria() throws SQLException {
        Scanner sn = new Scanner(System.in);
        CategoriaBd categoriaBd = new CategoriaBd();
        Categoria categoria = new Categoria();
        System.out.println("Ingrese categoria en numero de manera incremental");
        int numeroCategoria = sn.nextInt();
        categoria.setNivel(numeroCategoria);
        categoriaBd.insertarCategoria(categoria);
        setId_categoria(categoriaBd.getIdCategoria());

    }

    public void ingresarPregunta(int numeroPregunta) throws SQLException {
        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        PreguntaBd preguntaBd = new PreguntaBd();

        Pregunta pregunta = new Pregunta();
        System.out.println("Ingrese pregunta # " + numeroPregunta);
        String strPregunta = sn.next();
        pregunta.setPregunta(strPregunta);
        pregunta.setId_categoria(id_categoria);
        preguntaBd.insertarPregunta(pregunta);
        setId_pregunta(preguntaBd.getIdPregunta());
        //pregunta.setRespuestas(ingresarRespuesta());

        System.out.println("pregunta: " + pregunta.getPregunta());


    }

    public  void  ingresarRespuesta(int numeroRespuesta) throws SQLException {
        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        Scanner snRespuestaValida = new Scanner(System.in);
        snRespuestaValida.useDelimiter("\n");
        RespuestaBd respuestaBd = new RespuestaBd();
        Respuesta respuesta = new Respuesta();
        System.out.println("Ingrese respuesta # " + numeroRespuesta);
        String strRespuesta = sn.next();
        System.out.println("Ingrese siVerdadero con 0- falso y 1- verdadero");
        int respuestaValida = snRespuestaValida.nextInt();
        respuesta.setRespuesta(strRespuesta);
        respuesta.setEsVedadera(respuestaValida);
        respuesta.setId_pregunta(id_pregunta);
        respuestaBd.insertarRespuesta(respuesta);
        System.out.println("respuesta: " + respuesta);


    }

}




