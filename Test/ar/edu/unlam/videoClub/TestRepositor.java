package ar.edu.unlam.videoClub;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class TestRepositor {

    private HashSet<Pelicula> listaDePeliculasDePrueba= new HashSet<Pelicula>();

    @Test
    public void testQuePruebaAgregarUnaPeliculaNueva(){
        Repositor r=new Repositor("Juan",20);
        Pelicula p1= new Pelicula("p1",01,20.0,18);

        Boolean aux= r.agregarNuevaPelicula(listaDePeliculasDePrueba,p1);

        /*Assert.assertEquals(true,aux);*/

    }

}
