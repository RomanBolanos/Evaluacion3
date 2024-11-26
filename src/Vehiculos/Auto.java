
package Vehiculos;

/**
 *
 * @author Roman 20232218172
 */

public class Auto extends Vehiculo {
    private boolean tieneRadio;
    private boolean tieneNavegador;

    
    public Auto(String placa, String marca, double precio, int cilindraje, boolean tieneRadio, boolean tieneNavegador) {
        super(placa, marca, precio, cilindraje);  
        this.tieneRadio = tieneRadio;
        this.tieneNavegador = tieneNavegador;
        calcularCuotaMensual();  
    }

    // Métodos getters y setters
    public boolean isTieneRadio() {
        return tieneRadio;
    }

    public void setTieneRadio(boolean tieneRadio) {
        this.tieneRadio = tieneRadio;
        calcularCuotaMensual();  
    }

    public boolean isTieneNavegador() {
        return tieneNavegador;
    }

    public void setTieneNavegador(boolean tieneNavegador) {
        this.tieneNavegador = tieneNavegador;
        calcularCuotaMensual(); 
    }

   
    @Override
    public void calcularImpuestoCirculacion() {
        super.calcularImpuestoCirculacion();  // Llamamos al cálculo de la clase (2%)
        if (tieneRadio) {
            setImpuestoCirculacion(getImpuestoCirculacion() + getPrecio() * 0.01);  
        }
        if (tieneNavegador) {
            setImpuestoCirculacion(getImpuestoCirculacion() + getPrecio() * 0.02);  
        }
    }

    // Método para calcular la cuota mensual del garaje
    public void calcularCuotaMensual() {
        double cuotaBase = 100.0;  
        if (getCilindraje() > 2499) {
            cuotaBase *= 1.2;  // Aumento del 20% si el cilindraje es mayor a 2499
        }
        setCuotaMesGaraje(cuotaBase);
    }

    @Override
    public String toString() {
        return "Auto [placa=" + getPlaca() + ", marca=" + getMarca() + ", precio=" + getPrecio() +
               ", cilindraje=" + getCilindraje() + ", impuestoCirculacion=" + getImpuestoCirculacion() +
               ", cuotaMesGaraje=" + getCuotaMesGaraje() + ", tieneRadio=" + tieneRadio +
               ", tieneNavegador=" + tieneNavegador + "]";
    }
}


