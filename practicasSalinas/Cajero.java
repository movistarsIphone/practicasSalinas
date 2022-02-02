public class Cajero {
    private double saldo;

    public Cajero(double inicial){
        this.saldo = inicial;
    }

    public double consultarSaldo(){
        return this.saldo;
    }

    private boolean billetesValidosDeposito(double cantidad){
        boolean billetesValidos = false;
        double  billetesVeinte, billetesCincuenta, billetesVeinteCincuenta, billetesDosVeinteCincuenta;
        billetesVeinte = cantidad%20;
        billetesCincuenta = cantidad%50;
        billetesVeinteCincuenta = (cantidad%50)-20;
        billetesDosVeinteCincuenta = (cantidad%50)-40;
        if(cantidad>20){
            if(billetesVeinte==0 || billetesCincuenta==0 || billetesVeinteCincuenta==0 || billetesDosVeinteCincuenta==0){
                billetesValidos = true;
            }
        }
        return billetesValidos;
    }

    private boolean billetesValidosRetiro(double cantidad){
        boolean billetesValidos = false;
        double  billetesCincuenta;
        billetesCincuenta = cantidad%50;
        if(cantidad>50){
            if(billetesCincuenta==0){
                billetesValidos = true;
            }
        }
        return billetesValidos;
    }

    public double deposito(double cantidad){
        if(cantidad>5000.0){
            System.out.println("No es posible depositar más de $5000.00. Intente nuevamente");
            Main.probarCajero();
            System.exit(0);
        }else{
            if(billetesValidosDeposito(cantidad)){
                System.out.println("Se han depositado billetes de denominaciones validas");
                this.saldo = this.saldo + cantidad;
            }else{
                System.out.println("No se han depositado billetes de denominaciones válidas, por favor vuelva a intentar");
                Main.probarCajero();
                System.exit(0);
            }
        }
        return this.saldo;
    }

    public double retiro(double cantidad){
        if(this.saldo>=cantidad && cantidad<=7500){
            if(billetesValidosRetiro(cantidad)){
                System.out.println("Se ha solicitado el retiro de billetes de denominaciones validas");
                this.saldo = this.saldo - cantidad;
            }else{
                System.out.println("No ha solicitado el retiro de billetes de denominaciones válidas, por favor vuelva a intentar");
                Main.probarCajero();;
                System.exit(0);
            }
        }else{
            System.out.println("La cantidad a retirar es mayor que el saldo o es mayor a la permitida de $7500.00. Operacion no permitida");
            Main.probarCajero();;
            System.exit(0);
        }
        return this.saldo;
    }
}
