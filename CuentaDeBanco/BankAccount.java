import java.util.Random;

public class BankAccount{
    //Atributos de clase
    private String numCuentaBancaria;
    private double saldoCuentaCorriente;
    private double saldoAhorros;
    private double totalEntreSaldos;
    static int cantidadCuentasCreadas;


    //constructor
    public BankAccount(){
        // atributos de objeto
        this.saldoCuentaCorriente = 0;
        this.saldoAhorros = 0;
        this.totalEntreSaldos = this.saldoAhorros + this.saldoCuentaCorriente;
        this.numCuentaBancaria = generarNumeroCuenta(10);
        cantidadCuentasCreadas++;
    }

    public BankAccount(double saldoAhorros, double saldoCuentaCorriente){
        // atributos de objeto
        this.saldoCuentaCorriente = saldoCuentaCorriente;
        this.saldoAhorros = saldoAhorros;
        this.totalEntreSaldos = this.saldoAhorros + this.saldoCuentaCorriente;
        this.numCuentaBancaria = generarNumeroCuenta(10);
        cantidadCuentasCreadas++;
    }
    public double getsaldoCuentaCorriente(){
        return this.saldoCuentaCorriente;
    }
    public double getsaldoAhorros(){
        return this.saldoAhorros;
    }
    public double getTotalSaldos(){
        return this.totalEntreSaldos;
    }
    public String depositarDinero(String cuenta, double deposito){
        
        if(cuenta.equals("corriente")){
            this.saldoCuentaCorriente += deposito;
            this.totalEntreSaldos += deposito;
            return "se realiza un deposito de $" +deposito+" a una cuenta corriente";
        }else if(cuenta.equals("ahorros")){
            this.saldoAhorros += deposito;
            this.totalEntreSaldos += deposito;
            return "se realiza un deposito de $"+deposito+" a una cuenta de ahorros";
        }
        return "esa cuenta no existe";
    }
    public String RetirarDinero(String tipoCuenta, double retiroDinero){
        if (tipoCuenta.equals("corriente")) {
            if(this.saldoCuentaCorriente < retiroDinero){
                return "no se puede realizar el retiro";
            }else{
                this.totalEntreSaldos = this.totalEntreSaldos - retiroDinero;
                return "se realiza el retiro de: $" + retiroDinero + 
                " a la cuenta corriente";
            }
        }else if(tipoCuenta.equals("ahorros")){
            if(this.saldoAhorros < retiroDinero){
                return "no se puede realizar el retiro";
            }else{
                this.totalEntreSaldos = this.totalEntreSaldos - retiroDinero;
                return "se realiza el retiro de: $" + retiroDinero+ 
                " a la cuenta de ahorros";
            }
        }else{
            return "no se pudo realizar esa operacion";
        }
    }
    
    private String generarNumeroCuenta(int digitos){
        Random ran = new Random();
        String cuentaBancaria = "";
        for (int i = 0; i < digitos; i++) {
            int numeroInt = ran.nextInt(digitos);
            cuentaBancaria += Integer.toString(numeroInt);
        }
        return cuentaBancaria;
    }
    public String getNumeroCuenta (){
        return this.numCuentaBancaria;
    }
}