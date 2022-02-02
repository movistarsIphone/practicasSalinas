public class Fibonacci {
    public void serieFibonacci(int numero){
        if(numero>0){
            int primerTermino = 0, segundoTermino = 1;
            System.out.println("La serie Fibonacci hasta la posición número " + numero + ", es la siguiente:");

            for (int i = 1; i <= numero; ++i) {
                System.out.print(primerTermino + ", ");

                // compute the next term
                int siguienteTermino = primerTermino + segundoTermino;
                primerTermino = segundoTermino;
                segundoTermino = siguienteTermino;
            }
        }else{
            System.out.println("Debe ingresar un número mayor a 0. Intente nuevamente");
            Main.probarFibonacci();
        }
    }
}
