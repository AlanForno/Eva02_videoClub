package ar.edu.unlam.videoClub;

import java.util.HashSet;

public class ClienteBasico extends Cliente {    

    
    public ClienteBasico(String nombre, Integer codigoCliente, Integer edad, Double dinero) {
        super(nombre, codigoCliente,edad,dinero);
        limiteDePeliculas =5; // este cliente puede tener hasta 5 peliculas.
        porcentaje = 0.0; // este tipo de cliente no va a tener descuento.
        listaDePeliculas= new HashSet <Pelicula>(); // su lista se limita a 5.
        
        
    }
    
    
    
    
    
   
}
