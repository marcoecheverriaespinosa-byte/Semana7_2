package Arregos.Tienda.Modelo;

public class Juego {
    private String nombre;
    private String categoria;
    private int tamanio;
    private double precio;
    private int LicenciasDisponibles;
    private int LicenciasVendidas;

    public Juego(String nombre, String categoria, int tamanio, double precio, int licenciasDisponibles) {
        LicenciasDisponibles = licenciasDisponibles;
        this.tamanio = tamanio;
        this.precio = precio;
        this.categoria = categoria;
        this.nombre = nombre;
        LicenciasVendidas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTamanio() {
        return tamanio;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public int getLicenciasDisponibles() {
        return LicenciasDisponibles;
    }

    public int getLicenciasVendidas() {
        return LicenciasVendidas;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty())
            this.nombre = nombre;
    }


    public void setCategoria(String categoria) {
        if (categoria != null && !categoria.trim().isEmpty())
            this.categoria = categoria;
    }

    public void setPrecio(double precio) {
        if (precio > 0)
            this.precio = precio;
    }

    public void setTamanio(int tamanio) {
        if (tamanio > 0)
            this.tamanio = tamanio;
    }

    public boolean comprar(int cantidad) {
        if (cantidad > 0) {
            LicenciasDisponibles += cantidad;
            return true;
        }
        return false;
    }


    public boolean vender(int cantidad) {
        if (cantidad > 0 && cantidad <= LicenciasDisponibles) {
            LicenciasDisponibles -= cantidad;
            LicenciasVendidas += cantidad;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Juego:" +
                "nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", tamanio=" + tamanio +
                ", precio=" + precio +
                ", LicenciasDisponibles=" + LicenciasDisponibles +
                ", LicenciasVendidas=" + LicenciasVendidas +
                '}';
    }
}
