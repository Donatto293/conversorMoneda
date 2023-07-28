package Conversor;

public class Moneda {
    private String nombre;
    private double valorConversion;

    private String abreviaturaMoneda;

    public Moneda(String nombre, double valorConversion, String abreviaturaMoneda) {
        this.nombre = nombre;
        this.valorConversion = valorConversion;
        this.abreviaturaMoneda = abreviaturaMoneda;
    }
    public String getNombre(){
        return nombre;
    }

    public  double getValorConversion(){
        return valorConversion;
    }
    public String getAbreviaturaMoneda(){
        return abreviaturaMoneda;
    }
}


