
package iniciar;

public class DatosJugador {
    
    String punteo;
    String dimension;
    String nombreJugador;

    //contructor de la clase DatosJugador
    public DatosJugador(String nombreJugador, String punteo, String dimension ) {
        
        this.dimension = dimension;
        this.nombreJugador = nombreJugador;
        this.punteo = punteo;
    }
    //getters and setters
    public String getPunteo() {
        return punteo;
    }

    public void setPunteo(String punteo) {
        this.punteo = punteo;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }
   
   
    
}
