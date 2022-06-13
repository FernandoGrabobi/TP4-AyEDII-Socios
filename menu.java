package ejercicio12punto7;
import java.util.Scanner;

public class menu {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int menuOptions = 0;
        int keyCode;
        tablaDDispersionEnlazada tablaHash = new tablaDDispersionEnlazada();
            
        
       
        do {
            try {
                System.out.println("Presione 1 para Insertar un nuevo socio\n");
                System.out.println("Presione 2 para Eliminar un socio \n");
                System.out.println("Presione 3 para Buscar un elemento \n");
                System.out.println("Presione 0 para salir del programa \n");
                menuOptions = input.nextInt();
                input.nextLine();

            } catch (Exception e) {
                clearScreen();
                System.out.println("Ingreso un valor no valido\n");
            }

            switch (menuOptions) {
                case 1:

                    clearScreen();
                    try {

                        tipoSocio socio = new tipoSocio();
                        tablaHash.insertar(socio);

                    } catch (Exception e) {
                        System.out.println("Ingreso un valor no valido\n");
                    }

                break;
                case 2:

                    clearScreen();
                    try {

                        System.out.println("Ingrese el numero de socio a eliminar ");
                        keyCode = input.nextInt();
                        input.nextLine();
                        tablaHash.eliminar(keyCode);

                    } catch (Exception e) {
                        System.out.println("Ingreso un valor no valido\n");
                    }

                break;
                case 3:

                    clearScreen();
                    try {

                        tipoSocio socioMostrar = new tipoSocio();
                        System.out.println("\n Ingrese el numero de socio a buscar ");
                        keyCode=input.nextInt();
                        input.nextLine();
                        socioMostrar = tablaHash.buscar(keyCode).getSocio();
                        socioMostrar.sample();

                    } catch (Exception e) {
                        System.out.println("Ingreso un valor no valido\n");
                    }

                break;
                case 0:
                    clearScreen();
                    System.out.println(" El programa a finalizado correctamente ");
                break;
                default:
                    clearScreen();
                    System.out.println(" \n Ingrese una opcion valida ");
                break;

            }

        } while (menuOptions != 0);

        input.close();
    }

}
