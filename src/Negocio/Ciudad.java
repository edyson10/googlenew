/*
*@autor edyson
*/
package Negocio;

public class Ciudad {
    
    private final String nombre, longitud, latitud;

    public Ciudad(String nombre, String longitud, String latitud) {
        this.nombre = nombre;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLongitud() {
        return longitud;
    }

    public String getLatitud() {
        return latitud;
    }  
}
