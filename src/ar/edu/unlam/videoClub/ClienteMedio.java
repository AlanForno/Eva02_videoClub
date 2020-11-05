package ar.edu.unlam.videoClub;

import java.util.Objects;

public class ClienteMedio extends ClienteBasico{

    private Double porcentajeDeDescuento;

    public ClienteMedio(String nombre, Integer codigoCliente, Integer limiteDePeliculas, Boolean isMenosDeEdad, Double porcentajeDeDescuento) {
        super(nombre, codigoCliente, limiteDePeliculas, isMenosDeEdad);
        this.porcentajeDeDescuento = porcentajeDeDescuento;
    }

    public Double getPorcentajeDeDescuento() {
        return porcentajeDeDescuento;
    }

    public void setPorcentajeDeDescuento(Double porcentajeDeDescuento) {
        this.porcentajeDeDescuento = porcentajeDeDescuento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteMedio that = (ClienteMedio) o;
        return porcentajeDeDescuento.equals(that.porcentajeDeDescuento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(porcentajeDeDescuento);
    }
}
