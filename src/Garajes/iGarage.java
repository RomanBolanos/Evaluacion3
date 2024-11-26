
package Garajes;

/**
 *
 * @author Roman
 */

import Vehiculos.Vehiculo;

public interface iGarage {
    double calcularIngresos();
    int calcularOcupacionPorTipoVehiculo(Vehiculo v);
}

