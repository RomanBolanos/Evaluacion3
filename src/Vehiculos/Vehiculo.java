
package Vehiculos;

/**
 *
 * @author Roman
 */

public abstract class Vehiculo {
    private String placa;
    private String marca;
    private double precio;
    private int cilindraje;
    private double cuotaMesGaraje;
    private double impuestoCirculacion;

    
    public Vehiculo(String placa, String marca, double precio, int cilindraje) {
        this.placa = placa;
        this.marca = marca;
        this.precio = precio;
        this.cilindraje = cilindraje;
        calcularImpuestoCirculacion();  // Llamamos al método para calcular el impuesto
    }

    // Métodos getters y setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
        calcularImpuestoCirculacion();
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public double getCuotaMesGaraje() {
        return cuotaMesGaraje;
    }

    public void setCuotaMesGaraje(double cuotaMesGaraje) {
        this.cuotaMesGaraje = cuotaMesGaraje;
    }

    public double getImpuestoCirculacion() {
        return impuestoCirculacion;
    }

    public void setImpuestoCirculacion(double impuestoCirculacion) {
        this.impuestoCirculacion = impuestoCirculacion;
    }

    
    public void calcularImpuestoCirculacion() {
        this.impuestoCirculacion = this.precio * 0.02;  // Impuesto básico del 2%
    }

    // Método toString para imprimir la información del vehículo
    @Override
    public String toString() {
        return "Vehiculo [placa=" + placa + ", marca=" + marca + ", precio=" + precio + 
               ", cilindraje=" + cilindraje + ", impuestoCirculacion=" + impuestoCirculacion + 
               ", cuotaMesGaraje=" + cuotaMesGaraje + "]";
    }
}

