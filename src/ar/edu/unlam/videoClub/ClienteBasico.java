package ar.edu.unlam.videoClub;

public class ClienteBasico extends Cliente{

    private Integer limiteDePeliculas;
    private Boolean isMenosDeEdad;

    public ClienteBasico(String nombre, Integer codigoCliente, Integer limiteDePeliculas, Boolean isMenosDeEdad) {
        super(nombre, codigoCliente);
        this.limiteDePeliculas = limiteDePeliculas;
        this.isMenosDeEdad = isMenosDeEdad;
    }

    public Integer getLimiteDePeliculas() {
        return limiteDePeliculas;
    }

    public void setLimiteDePeliculas(Integer limiteDePeliculas) {
        this.limiteDePeliculas = limiteDePeliculas;
    }

    public Boolean getMenosDeEdad() {
        return isMenosDeEdad;
    }

    public void setMenosDeEdad(Boolean menosDeEdad) {
        isMenosDeEdad = menosDeEdad;
    }
}
