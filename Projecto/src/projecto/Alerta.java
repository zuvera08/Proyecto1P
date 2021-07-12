/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;

/**
 *Esta clase permita avisar al cliente cuando se ha creado una nueva propiedad que este de acorde a sus criterios de busqueda
 * @author Zuleyka Vera
 */
public class Alerta {
    private String tipoPropiedad;
    private double precioMin;
    private double precioMax;
    private String ciudad;
    private String sector;
    /**
     *Constructor para las alertas que recibira el cliente
     * @param tipoPropiedad el tipo de propiedad que recibira el cliente casa o terreno
     * @param precioMin el valor minimo que se busca
     * @param precioMax el valor maximo deseado
     * @param ciudad la ciudad en que se busca la propiedad
     * @param sector el sector de busqueda
     **/
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
