
package Vehiculos;

/**
 *
 * @author Roman 20232218172
 */

public class Camioneta extends Vehiculo {
    private String tipoServicio;
    private int numeroPasajeros;
    private boolean tieneRemolque;

    
    public Camioneta(String placa, String marca, double precio, int cilindraje, String tipoServicio, int numeroPasajeros, boolean tieneRemolque) {
        super(placa, marca, precio, cilindraje);  
        this.tipoServicio = tipoServicio;
        this.numeroPasajeros = numeroPasajeros;
        this.tieneRemolque = tieneRemolque;
        calcularCuotaMensual();  
    }

    // Métodos getters y setters
    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
        calcularCuotaMensual();  
    }

    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public void setNumeroPasajeros(int numeroPasajeros) {
        this.numeroPasajeros = numeroPasajeros;
        calcularCuotaMensual(); 
    }

    public boolean isTieneRemolque() {
        return tieneRemolque;
    }

    public void setTieneRemolque(boolean tieneRemolque) {
        this.tieneRemolque = tieneRemolque;
        calcularCuotaMensual();  
    }

    
    @Override
    public void calcularImpuestoCirculacion() {
        super.calcularImpuestoCirculacion(); 
        setImpuestoCirculacion(getImpuestoCirculacion() * 1.05);  // Aumento del 5% para camionetas
    }

    
    public void calcularCuotaMensual() {
        double cuotaBase = 100.0;  
        if (tipoServicio.equals("SUV")) {
            cuotaBase *= 1.1;  // Aumento del 10% para SUV
        } else if (tipoServicio.equals("Pickup") || tipoServicio.equals("Carga")) {
            cuotaBase *= 1.45;  // Aumento del 45% para Pickup o Carga
        }
        if (numeroPasajeros == 2) {
            cuotaBase *= 1.5;  // Aumento del 50% si tiene 2 pasajeros
        } else if (numeroPasajeros > 2) {
            cuotaBase *= 1.6;  // Aumento del 60% si tiene más de 2 pasajeros
        }
        if (tieneRemolque) {
            cuotaBase *= 1.1;  // Aumento del 10% si tiene remolque
        }
        setCuotaMesGaraje(cuotaBase);
    }

    @Override
    public String toString() {
        return "Camioneta [placa=" + getPlaca() + ", marca=" + getMarca() + ", precio=" + getPrecio() +
               ", cilindraje=" + getCilindraje() + ", impuestoCirculacion=" + getImpuestoCirculacion() +
               ", cuotaMesGaraje=" + getCuotaMesGaraje() + ", tipoServicio=" + tipoServicio +
               ", numeroPasajeros=" + numeroPasajeros + ", tieneRemolque=" + tieneRemolque + "]";
    }
}

