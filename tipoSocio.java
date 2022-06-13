package ejercicio12punto7;
import java.io.*;
import java.util.Scanner;
public class tipoSocio {

    class Date{

        int day;
        int month;
        int year;
        Date(){
            asigna();
        }

        public void asigna(){
            
            Scanner input = new Scanner(System.in);

            System.out.println("\n Ingrese el dia \n");
            int day = input.nextInt();
            input.nextInt();
            System.out.println("\n Ingrese el mes \n");
            int month = input.nextInt();
            input.nextInt();
            System.out.println("\n Ingrese el año \n");
            int year = input.nextInt();
            input.nextInt();

            input.close();

            this.day = day;
            this.month = month;
            this.year = year;
        }
        public String toString(){
            return ""+ day +"-"+ month +"-"+ year;
        }
    }

    public int code;
    public String name;
    public int age;
    public Date date;

    public tipoSocio(){
        asigna();
    }

    public void asigna(){

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        try{
            System.out.println("\n Numero de socio: ");
            this.code = Integer.parseInt(input.readLine());
            System.out.println("\n Nombre: ");
            this.name = input.readLine();
            System.out.println("\n Edad: ");
            this.age = Integer.parseInt(input.readLine());
            this.date = new Date();

        }catch(IOException e){
            System.out.println("\n ingreso un valor no valido ");
        }
    }

    public int getCodigo(){
        return code;
    }
    public void sample(){
        System.out.println("\n Numero de socio: "+ code);
        System.out.println("\n Nombre: "+ name);
        System.out.println("\n Edad "+ age);
        System.out.println("\n Fecha: "+date);
    }

}
