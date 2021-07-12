/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;

/**
 *
 * @author PC
 */
public class Alerta {
    private String tipoPropiedad;
    private double precioMin;
    private double precioMax;
    private String ciudad;
    private String sector;

    public Alerta(String tipoPropiedad, double precioMin, double precioMax, String ciudad, String sector) {
        this.tipoPropiedad = tipoPropiedad;
        this.precioMin = precioMin;
        this.precioMax = precioMax;
        this.ciudad = ciudad;
        this.sector = sector;
    }

    public String getTipoPropiedad() {
        return tipoPropiedad;
    }

    public double getPrecioMin() {
        return precioMin;
    }

    public double getPrecioMax() {
        return precioMax;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getSector() {
        return sector;
    }

    public void setTipoPropiedad(String tipoPropiedad) {
        this.tipoPropiedad = tipoPropiedad;
    }

    public void setPrecioMin(double precioMin) {
        this.precioMin = precioMin;
    }

    public void setPrecioMax(double precioMax) {
        this.precioMax = precioMax;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
    
}
