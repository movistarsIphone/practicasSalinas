public class Factorial {
    public int calcularFactorialMismo(int numero){
        if(numero==0){
            System.exit(0);
        }else {
            return numero*calcularFactorialMismo(numero-1);
        }
        return numero;
    }

    public void calcularFactorial(int numero){
        int factorial = 1;
        if(numero>0){
            for(int i=1; i<=numero; i++){
                factorial*=i;
            }
        }else{
            System.out.println("Debe ingresar un número mayor a 0. Intente nuevamente");
            Main.probarFactorial();
        }
        System.out.println("El factorial del número "+numero+" es: "+factorial);
    }

}
