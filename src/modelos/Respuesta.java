package modelos;

public class Respuesta {

    int id_pregunta;
    int id_respuesta;

    public int getId_respuesta() {
        return id_respuesta;
    }

    public void setId_respuesta(int id_respuesta) {
        this.id_respuesta = id_respuesta;
    }

    private String respuesta;
    private int esVedadera;

    public Respuesta(){

    }

    public int getEsVedadera() {
        return esVedadera;
    }

    public void setEsVedadera(int esVedadera) {
        this.esVedadera = esVedadera;
    }

    public int getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        return "Respuesta{" +
                "respuesta='" + respuesta + '\'' +
                ", esVedadera=" + esVedadera +
                '}';
    }






}
