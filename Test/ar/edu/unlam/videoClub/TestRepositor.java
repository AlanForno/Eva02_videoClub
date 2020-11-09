package ar.edu.unlam.videoClub;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class TestRepositor {

    private HashSet<Pelicula> listaDePeliculasDePrueba= new HashSet<Pelicula>();
    private HashSet<Pelicula> lista2= new HashSet<>();

    @Test
    public void testQuePruebaAgregarUnaPeliculaNueva(){
        Pelicula pB= new Pelicula("p4",04,5.0,5);
        Repositor r=new Repositor("Juan",20);

        Boolean aux=r.agregarNuevaPelicula(listaDePeliculasDePrueba,lista2,pB);

        Assert.assertTrue(aux);
    }
    @Test
    public void testQuePruebaQueSePuedaEliminarUnaPelicula(){
        Repositor r=new Repositor("Juan",20);
        Pelicula p3= new Pelicula("p3",03,40.0,18);

        listaDePeliculasDePrueba.add(p3);

        Boolean aux= r.quitarPelicula(listaDePeliculasDePrueba,p3);

        Assert.assertTrue(aux);

    }

}
