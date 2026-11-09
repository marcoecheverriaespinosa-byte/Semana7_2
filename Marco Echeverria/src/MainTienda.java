import Arregos.Tienda.Modelo.AppStore;
import Arregos.Tienda.Modelo.Juego;
import Arregos.Tienda.Modelo.utilitario.Validacion;

import javax.swing.*;
import java.util.Scanner;

public class MainTienda {
    private static AppStore tienda  = new AppStore();
    private static Scanner sc= new Scanner(System.in);
    static void main() {
        int opc;
        tienda.cargarDatos();
        do {

            menu();
            opc = Integer.parseInt(sc.nextLine());
            switch (opc) {
                case 1: {
                    ingresarJuego();
                }
                break;
                case 2: {
                    imprimirInformacion();
                }
                break;
                case 3: {

                }
                break;
                case 4: {

                }
                break;
                case 5: {
                    venderJuego();
                }
                break;
                case 6: {

                }
                break;
                default: {
                    System.out.println("Opcion Invalida");
                }


            }

        }while (opc != 7) ;
    }


    public static void menu(){
        System.out.println("**********AppStore Udla**********");
        System.out.println("1. Ingresar Juego");
        System.out.println("2. Mostrar juegos");
        System.out.println("3. Buscar juego");
        System.out.println("4. Comprar");
        System.out.println("5. Vender");
        System.out.println("6. Juego más vendido");
        System.out.println("7. Salir");
        System.out.print("Ingrese una opcion: ");
    }
    public static void ingresarJuego(){
        System.out.println("*******Ingreso de datos********");
        String nombre = Validacion.leerString("Ingrese su nombre: /no se aceptan nulos ni espacios en blanco");
        String categoria = Validacion.leerString("Ingrese su categoria: ");
        System.out.print("Ingrese el tamanio: ");
        int tamanio = Integer.parseInt(sc.nextLine());
        System.out.print("Ingrese el precio: ");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.print("Ingrese el stock inicial: ");
        int licenciasDisponibles = Integer.parseInt(sc.nextLine());
        if (tienda.adicionarJuego(new Juego(nombre,categoria,tamanio,precio,licenciasDisponibles))){
            JOptionPane.showMessageDialog(null,"El juego se ha agregado com exito");
        }
        else{
            JOptionPane.showMessageDialog(null,"No fue posible agregar el juego");
        }
    }
    public static void imprimirInformacion(){
        Juego juegos[]= tienda.getJuegos();
       if (tienda.getIndice()==-1)
        System.out.println("No existe juegos aun");
       else {
           for (int i=0;i<= tienda.getIndice();i++){
               System.out.println(juegos[i]
               );
           }
       }
    }
    public static void venderJuego(){
        String nombre;
        int cantidad;
        String vender = Validacion.leerString("Ingrese su nombre: ");
        System.out.println("Ingrese el tamanio: ");
        cantidad= Integer.parseInt(sc.nextLine());
        double valorPago = tienda.vender(nombre,cantidad);
        if (valorPago != 0){
            JOptionPane.showMessageDialog(null,"Juego: "+nombre+"\nCantidad:"+cantidad+
                    "Valor a cancelar: "+valorPago);
        }else{
            JOptionPane.showMessageDialog(null,"No fue posible vender el juego "+nombre);
        }
    }
}
