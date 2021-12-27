package negocio;

import BaseDatos.CategoriaBd;
import BaseDatos.PreguntaBd;
import BaseDatos.RespuestaBd;
import modelos.Jugador;
import modelos.Pregunta;
import modelos.Respuesta;

import java.sql.SQLException;
import java.util.*;

public class IniciarJuego {


      public int  obtenerIdentificadorCategoria(int nivel) throws SQLException {
          CategoriaBd categoriaBd = new CategoriaBd();
          return categoriaBd.obtenerCategoria(nivel);
      }

    public Pregunta obtenerPreguntaAleatoria(int nivelCategoria) throws SQLException {
        PreguntaBd preguntaBd = new PreguntaBd();
        return  preguntaBd.obtenerPreguntaAleatoria(nivelCategoria);
    }

    public List<Respuesta> obtenerRespuestasPregunta(int id_pregunta) throws SQLException {
        RespuestaBd respuestaBd = new RespuestaBd();
        return  respuestaBd.obtenerRespuestasPregunta(id_pregunta);
    }


    public  boolean rondaJuego(int numeroRonda, Pregunta pregunta,List<Respuesta> lstRespuestas){
        Map<String,Integer> mapRespuestas = new HashMap<String, Integer>();

        System.out.println("Ronda del # " + numeroRonda);
        System.out.println("Pregunta: " + pregunta.getPregunta());
        mapRespuestas.put("A",lstRespuestas.get(0).getEsVedadera());
        mapRespuestas.put("B",lstRespuestas.get(1).getEsVedadera());
        mapRespuestas.put("C",lstRespuestas.get(2).getEsVedadera());
        mapRespuestas.put("D",lstRespuestas.get(3).getEsVedadera());

        System.out.println("respuesta: " + "A) " + lstRespuestas.get(0).getRespuesta() );
        System.out.println("respuesta: " + "B) " + lstRespuestas.get(1).getRespuesta() );
        System.out.println("respuesta: " + "C) " + lstRespuestas.get(2).getRespuesta() );
        System.out.println("respuesta: " + "D) " + lstRespuestas.get(3).getRespuesta() );
        Scanner sn = new Scanner(System.in);
        String respuestaUsuario  = sn.next();

        int buscarRespuesta = mapRespuestas.get(respuestaUsuario.toUpperCase());
        return buscarRespuesta == 1;

    }

    public  void registrarJugador(Jugador jugador){

    }



}
