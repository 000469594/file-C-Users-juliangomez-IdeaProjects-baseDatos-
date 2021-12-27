package modelos;

import java.util.List;

public class Categoria {

    private int id_nivel;
    private List<Pregunta> preguntas;

    public Categoria(){

    }

    public int getNivel() {
        return id_nivel;
    }

    public void setNivel(int nivel) {
        this.id_nivel = nivel;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "nivel=" + id_nivel +
                ", preguntas=" + preguntas +
                '}';
    }


}
