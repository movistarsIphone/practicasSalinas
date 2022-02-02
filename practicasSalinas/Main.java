import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    static double cantidad = 0.0;

    public static void main(String[] args){
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        ResourceBundle.clearCache(cl);

        Scanner in = new Scanner(System.in);
        String respuesta = "";

        System.out.println("---------------------Bienvenido---------------------");
        System.out.println("¿Que programa desea probar?");
        System.out.println("1. Factorial de un número");
        System.out.println("2. Número primo");
        System.out.println("3. Array de enteros");
        System.out.println("4. Cajero automático");
        System.out.println("5. Serie Fibonacci");
        System.out.println("6. Hilos y sincronización");
        System.out.println("7. Salir");
        respuesta = in.nextLine();

        switch(respuesta){
            case "1":
                probarFactorial();
                break;
            case "2":
                probarPrimo();
                break;
            case "3":
                probarArray();
                break;
            case "4":
                probarCajero();
                break;
            case "5":
                probarFibonacci();
                break;
            case "6":
                try {
                    probarHilos();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case "7":
                System.exit(0);
                break;
            default:
                System.out.println("Opción inválida. Intente nuevamente");
                String[] argsParam = {};
                Main.main(argsParam);
                break;
        }
    }

    static void probarFactorial(){
        Scanner in = new Scanner(System.in);
        String respuesta = "";
        Factorial factorial = new Factorial();
        System.out.println("Ingresa un número para obtener su factorial:");
        respuesta = in.nextLine();
        factorial.calcularFactorial(Integer.valueOf(respuesta));
        System.out.println("¿Desea probar con otro número? (Si/No)");
        respuesta = in.nextLine();
        if ("Si".equalsIgnoreCase(respuesta)) {
            probarFactorial();
        }else if("No".equalsIgnoreCase(respuesta)){
            System.out.println("Fin.");
            String[] argsParam = {};
            Main.main(argsParam);
        }else{
            System.out.println("Opción inválida. Intente nuevamente");
            probarFactorial();
        }
    }

    static void probarPrimo() {
        Scanner in = new Scanner(System.in);
        String respuesta = "";
        Primo primo = new Primo();
        System.out.println("Ingresa un número para determinar si es primo:");
        respuesta = in.nextLine();
        primo.numeroPrimo(Integer.valueOf(respuesta));
        System.out.println("¿Desea probar con otro número? (Si/No)");
        respuesta = in.nextLine();
        if ("Si".equalsIgnoreCase(respuesta)) {
            probarPrimo();
        }else if("No".equalsIgnoreCase(respuesta)){
            System.out.println("Fin.");
            String[] argsParam = {};
            Main.main(argsParam);
        }else{
            System.out.println("Opción inválida. Intente nuevamente");
            probarPrimo();
        }
    }

    static void probarArray(){
        Scanner in = new Scanner(System.in);
        String respuesta = "";
        Array array = new Array();
        Primo primo = new Primo();
        int[] arreglo = array.devolverArreglo();
        for(int i:arreglo){
            primo.numeroPrimo(i);
        }
        System.out.println("¿Desea probar con otro arreglo? (Si/No)");
        respuesta = in.nextLine();
        if ("Si".equalsIgnoreCase(respuesta)) {
            probarArray();
        }else if("No".equalsIgnoreCase(respuesta)){
            System.out.println("Fin.");
            String[] argsParam = {};
            Main.main(argsParam);
        }else{
            System.out.println("Opción inválida. Intente nuevamente");
            probarArray();
        }
    }

    static void probarCajero(){
        Scanner in = new Scanner(System.in);
        String respuesta = "";
        Cajero cajero = new Cajero(cantidad);
        System.out.println("---------------------Bienvenido---------------------");
        System.out.println("Seleccione la opción deseada");
        System.out.println("1. Consulta de saldo");
        System.out.println("2. Depósito de efectivo");
        System.out.println("3. Retiro de efectivo");
        System.out.println("4. Salir");
        respuesta = in.nextLine();

        switch(respuesta){
            case "1":
                System.out.println("Su saldo actual es:    "+cajero.consultarSaldo());
                probarCajero();
                break;
            case "2":
                System.out.println("¿Cuál es la cantidad que va a depositar en su cuenta?");
                respuesta = in.nextLine();
                cantidad = cajero.deposito(Double.valueOf(respuesta));
                System.out.println("Deposito exitoso. Su nuevo saldo es:    "+cantidad);
                probarCajero();
                break;
            case "3":
                System.out.println("¿Cuál es la cantidad que va a retirar de su cuenta?");
                respuesta = in.nextLine();
                cantidad = cajero.retiro(Double.valueOf(respuesta));
                System.out.println("Retiro exitoso. Su nuevo saldo es:  "+cantidad);
                probarCajero();
                break;
            case "4":
                System.out.println("Retire su tarjeta.");
                String[] argsParam = {};
                Main.main(argsParam);
                break;
            default:
                System.out.println("Opción inválida. Intente nuevamente");
                probarCajero();
                break;
        }
    }

    static void probarFibonacci(){
        Scanner in = new Scanner(System.in);
        String respuesta = "";
        Fibonacci fibonacci = new Fibonacci();
        System.out.println("Ingresa el número de posición para la serie Fibonacci:");
        respuesta = in.nextLine();
        fibonacci.serieFibonacci(Integer.valueOf(respuesta));
        System.out.println("\n¿Desea probar con otro número de posición? (Si/No)");
        respuesta = in.nextLine();
        if ("Si".equalsIgnoreCase(respuesta)) {
            probarFibonacci();
        }else if("No".equalsIgnoreCase(respuesta)){
            System.out.println("Fin.");
            String[] argsParam = {};
            Main.main(argsParam);
        }else{
            System.out.println("Opción inválida. Intente nuevamente");
            probarFibonacci();
        }

    }

    static void probarHilos() throws InterruptedException{
        Scanner in = new Scanner(System.in);
        String respuesta = "";

        Hilos hilos = new Hilos();
        long tiempoEspera = 1000 * 60 * 60;

        hilos.mensajeHilo("Comienza el hilo con el himno nacional.");
        long horaInicio = System.currentTimeMillis();
        Thread hilo = new Thread(new Hilos.MensajesHilos());
        hilo.start();

        hilos.mensajeHilo("En espera de que se termine el himno nacional");
        while (hilo.isAlive()) {
            hilos.mensajeHilo("Aún no termina el himno nacional...");
            hilo.join(1000);
            if (((System.currentTimeMillis() - horaInicio) > tiempoEspera)
                    && hilo.isAlive()) {
                hilos.mensajeHilo("El hilo con el himno nacional ha tardado demasiado.");
                hilo.interrupt();
                hilo.join();
            }
        }
        hilos.mensajeHilo("¡Se termino el himno nacional!");

        System.out.println("¿Desea volver a ver el himno nacional mediante los mensajes del hilo? (Si/No)");
        respuesta = in.nextLine();
        if ("Si".equalsIgnoreCase(respuesta)) {
            probarHilos();
        }else if("No".equalsIgnoreCase(respuesta)){
            System.out.println("Fin.");
            String[] argsParam = {};
            Main.main(argsParam);
        }else{
            System.out.println("Opción inválida. Intente nuevamente");
            probarHilos();
        }
    }

}
