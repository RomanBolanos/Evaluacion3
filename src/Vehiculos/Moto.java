
package Vehiculos;

/**
 *
 * @author Roman 20232218172
 */

public class Moto extends Vehiculo {
    private boolean tieneSidecar;

    
    public Moto(String placa, String marca, double precio, int cilindraje, boolean tieneSidecar) {
        super(placa, marca, precio, cilindraje);  
        this.tieneSidecar = tieneSidecar;
        calcularCuotaMensual();  
    }

   
    public boolean isTieneSidecar() {
        return tieneSidecar;
    }

    public void setTieneSidecar(boolean tieneSidecar) {
        this.tieneSidecar = tieneSidecar;
        calcularCuotaMensual();  
    }

   
    @Override
    public void calcularImpuestoCirculacion() {
        super.calcularImpuestoCirculacion();  
        if (tieneSidecar) {
            setImpuestoCirculacion(getImpuestoCirculacion() * 1.1);  
        }
    }

    
    public void calcularCuotaMensual() {
        double cuotaBase = 100.0;  
        if (tieneSidecar) {
            cuotaBase *= 1.5;  // Aumento del 50% si tiene sidecar
        }
        setCuotaMesGaraje(cuotaBase);
    }

    @Override
    public String toString() {
        return "Moto [placa=" + getPlaca() + ", marca=" + getMarca() + ", precio=" + getPrecio() +
               ", cilindraje=" + getCilindraje() + ", impuestoCirculacion=" + getImpuestoCirculacion() +
               ", cuotaMesGaraje=" + getCuotaMesGaraje() + ", tieneSidecar=" + tieneSidecar + "]";
    }
}

