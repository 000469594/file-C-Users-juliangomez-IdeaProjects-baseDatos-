package modelos;

import java.util.List;

public class Pregunta {

    private  int id_pregunta;
    private int id_categoria;
    private String pregunta;
    private List<Respuesta> respuestas;

    public Pregunta(){

    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public int getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "pregunta='" + pregunta + '\'' +
                "id_categoria='" + id_categoria + '\'' +
                ", respuestas=" + respuestas +
                '}';
    }


}
