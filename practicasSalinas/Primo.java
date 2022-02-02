public class Primo {

    public void numeroPrimo(int numero){
        if (numero <= 0) {
            System.out.println("El número debe ser mayor que 0. Intente nuevamente.");
            String[] args = {};
            Main.main(args);
            System.exit(0);
        } else {
            int divisores = 0;
            int i = 2;
            while (i < numero) {
                if (numero % i == 0) {
                    divisores++;
                }
                i++;
            }
            if (divisores == 0 && numero>1) {
                System.out.println("El número "+numero+" si es primo");
            } else {
                System.out.println("El número "+numero+" no es primo");
            }
        }
    }
}
