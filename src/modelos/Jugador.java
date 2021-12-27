package modelos;

public class Jugador {


    private String nombre;
    private int acumuladoPuntos;
    private String estadoFinalizacion;



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAcumuladoPuntos() {
        return acumuladoPuntos;
    }

    public void setAcumuladoPuntos(int acumuladoPuntos) {
        this.acumuladoPuntos = acumuladoPuntos;
    }

    public String getEstadoFinalizacion() {
        return estadoFinalizacion;
    }

    public void setEstadoFinalizacion(String estadoFinalizacion) {
        this.estadoFinalizacion = estadoFinalizacion;
    }


}
