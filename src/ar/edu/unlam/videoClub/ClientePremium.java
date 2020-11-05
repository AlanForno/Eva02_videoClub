package ar.edu.unlam.videoClub;

import java.util.Objects;

public class ClientePremium extends ClienteMedio {

    private Boolean alquilarPeliculasLibremente;

    public ClientePremium(String nombre, Integer codigoCliente, Integer limiteDePeliculas, Boolean isMenosDeEdad, Double porcentajeDeDescuento, Boolean alquilarPeliculasLibremente) {
        super(nombre, codigoCliente, limiteDePeliculas, isMenosDeEdad, porcentajeDeDescuento);
        this.alquilarPeliculasLibremente = alquilarPeliculasLibremente;
    }

    public Boolean getAlquilarPeliculasLibremente() {
        return alquilarPeliculasLibremente;
    }

    public void setAlquilarPeliculasLibremente(Boolean alquilarPeliculasLibremente) {
        this.alquilarPeliculasLibremente = alquilarPeliculasLibremente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ClientePremium that = (ClientePremium) o;
        return alquilarPeliculasLibremente.equals(that.alquilarPeliculasLibremente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), alquilarPeliculasLibremente);
    }
}
