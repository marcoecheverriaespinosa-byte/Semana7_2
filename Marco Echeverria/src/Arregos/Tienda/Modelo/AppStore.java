package Arregos.Tienda.Modelo;


public class AppStore {
    private static final int MAX = 4;
    private Juego juegos[];
    private int indice;

    public AppStore(){
        juegos = new Juego[MAX];
        indice = -1;
    }

    public void cargarDatos(){
        adicionarJuego(new Juego("Roblox","Sandbox",53,80,25));
        adicionarJuego(new Juego("Fifa2026","Deportes",35,60,55));
    }


    public Juego[] getJuegos() {
        return juegos;
    }
    /* no se necesita el set() pq los datos se ingresan uno a uno
        public void setJuegos(Juego juegos[]) {
            this.juegos = juegos;
        }
        */
    public boolean adicionarJuego(Juego j){
        if(j != null && indice < MAX - 1){
            juegos[++indice] = j;
            return true;
        }
        return false;
    }

    public Juego buscarJuego(String nombre){
        if(nombre != null && !nombre.trim().isEmpty()){
            for(int i = 0; i <= indice; i++){
                if(juegos[i].getNombre().equalsIgnoreCase(nombre)){
                    return juegos[i];
                }
            }
            return null;
        }
        return null;
    }
    public boolean comprar(String nombre, int cantidad){
        //opcional validar pq el buscarJuego() y el comprar de Juego y validan
        Juego j = buscarJuego(nombre);
        if(j != null){
            return j.comprar(cantidad);
        }
        return false;
    }

    public double vender(String nombre, int cantidad){
        if(nombre != null && !nombre.trim().isEmpty() && cantidad > 0){
            Juego j = buscarJuego(nombre);
            if(j != null){
                if(j.vender(cantidad)){
                    return j.getPrecio() * cantidad;
                }
            }
            return 0;
        }
        return 0;
    }

    public String masVendido(){
        String nombre= "";
        int mayor;
        if (indice >=0){
            nombre = juegos[0].getNombre();
            mayor = juegos[0].getLicenciasVendidas();
            for(Juego j : juegos) {
                if (j != null) {
                    if (j.getLicenciasVendidas() > mayor) {
                        nombre = j.getNombre();
                        mayor = j.getLicenciasVendidas();
                    }
                } else{
                    return nombre;
                }
            }
        }
        return nombre;
    }

    public int getIndice() {
        return indice;
    }
}

