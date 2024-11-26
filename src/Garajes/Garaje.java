
package Garajes;

/**
 *
 * @author Roman 20232218172
 */


import Vehiculos.*;
import Excepciones.*;

public class Garaje implements iGarage {
    private String departamento;
    private String ciudad;
    private String direccion;
    private String telefono;
    private String email;
    private String nombreAdministrador;
    private int numeroEspacios;  
    private Vehiculo[] espacios;
    private int vehiculosOcupados;

    
    public Garaje(String departamento, String ciudad, String direccion, String telefono, String email, String nombreAdministrador, int numeroEspacios) {
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.nombreAdministrador = nombreAdministrador;
        this.numeroEspacios = numeroEspacios;
        this.espacios = new Vehiculo[numeroEspacios];
        this.vehiculosOcupados = 0;
    }

    
    public boolean agregarVehiculo(Vehiculo vehiculo) throws ExcepcionPlazasSuperadas {
        int maxMotos = (int) (numeroEspacios * 0.2);  // El 20% del espacio para motos
        int maxCamiones = (numeroEspacios < 100) ? 10 : 20;  // Maximo de camiones según la política

        int countMotos = 0;
        int countCamiones = 0;

        // Contar cuántas motos y camiones ya están en el garaje
        for (int i = 0; i < vehiculosOcupados; i++) {
            if (espacios[i] instanceof Moto) countMotos++;
            if (espacios[i] instanceof Camioneta) countCamiones++;
        }

        // Verificar si se exceden los límites de motos o camiones
        if (vehiculo instanceof Moto && countMotos >= maxMotos) {
            throw new ExcepcionPlazasSuperadas("Se ha excedido el límite de motos permitidas en este garaje.");
        }

        if (vehiculo instanceof Camioneta && countCamiones >= maxCamiones) {
            throw new ExcepcionPlazasSuperadas("Se ha excedido el límite de camiones permitidos en este garaje.");
        }

        // Si hay espacio disponible, agregar el vehículo
        if (vehiculosOcupados < numeroEspacios) {
            espacios[vehiculosOcupados++] = vehiculo;
            return true;
        }
        return false;
    }

    // Método para retirar un vehículo del garaje
    public boolean retirarVehiculo(String matricula) {
        for (int i = 0; i < vehiculosOcupados; i++) {
            if (espacios[i].getPlaca().equals(matricula)) {
                // Mover los vehículos en el arreglo para eliminar el vehículo retirado
                for (int j = i; j < vehiculosOcupados - 1; j++) {
                    espacios[j] = espacios[j + 1];
                }
                espacios[vehiculosOcupados - 1] = null;
                vehiculosOcupados--;
                return true;
            }
        }
        return false; // Si no se encuentra el vehículo
    }

   
    @Override
    public double calcularIngresos() {
        double totalIngresos = 0;
        for (int i = 0; i < vehiculosOcupados; i++) {
            totalIngresos += espacios[i].getCuotaMesGaraje();
        }
        return totalIngresos;
    }

    @Override
    public int calcularOcupacionPorTipoVehiculo(Vehiculo v) {
        int contador = 0;
        for (int i = 0; i < vehiculosOcupados; i++) {
            if (espacios[i].getClass() == v.getClass()) {
                contador++;
            }
        }
        return contador;
    }

   
    public void mostrarDetallesGaraje() {
        System.out.println("Departamento: " + departamento);
        System.out.println("Ciudad: " + ciudad);
        System.out.println("Dirección: " + direccion);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Email: " + email);
        System.out.println("Administrador: " + nombreAdministrador);
        System.out.println("Espacios: " + numeroEspacios);
        System.out.println("Vehículos ocupados: " + vehiculosOcupados);
    }

    
    public void mostrarCamionetasPorTipo() {
        int countSUV = calcularOcupacionPorTipoVehiculo(new Camioneta("", "", 0, 0, "SUV", 5, false));
        int countPickup = calcularOcupacionPorTipoVehiculo(new Camioneta("", "", 0, 0, "Pickup", 2, false));
        int countCarga = calcularOcupacionPorTipoVehiculo(new Camioneta("", "", 0, 0, "Carga", 2, false));
        int countOtro = calcularOcupacionPorTipoVehiculo(new Camioneta("", "", 0, 0, "Otro", 5, false));

        System.out.println("Camionetas SUV: " + countSUV);
        System.out.println("Camionetas Pickup: " + countPickup);
        System.out.println("Camionetas Carga: " + countCarga);
        System.out.println("Camionetas Otro: " + countOtro);
    }

    public Vehiculo[] getVehiculos() {
        return espacios;
    }
}

