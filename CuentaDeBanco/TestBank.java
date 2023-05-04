public class TestBank {
    public static void main(String[] args) {
        BankAccount cuenta1 = new BankAccount();
        System.out.println("<<------------------>>");
        String deposito = cuenta1.depositarDinero("corriente", 325);
        String deposito1 = cuenta1.depositarDinero("ahorros", 241);
        System.out.println(deposito);
        System.out.println(deposito1);
        String retiro = cuenta1.RetirarDinero("corriente", 100);
        String retiro2 = cuenta1.RetirarDinero("ahorros", 41);
        System.out.println(retiro);
        System.out.println(retiro2);
        System.out.println("el total en la cuenta bancaria con numero #"+
        cuenta1.getNumeroCuenta()+" es de: $"+cuenta1.getTotalSaldos());
        System.out.println("<<------------------>>");

        BankAccount cuenta2 = new BankAccount();
        String dep = cuenta2.depositarDinero("corriente", 100);
        String dep1 = cuenta2.depositarDinero("ahorros", 250);
        System.out.println(dep);
        System.out.println(dep1);
        String retiro3 = cuenta2.RetirarDinero("corriente", 100);
        String retiro4 = cuenta2.RetirarDinero("ahorros", 41);
        System.out.println(retiro3);
        System.out.println(retiro4);
        System.out.println("el total en la cuenta bancaria con numero #"+
        cuenta2.getNumeroCuenta()+" es de: $"+cuenta2.getTotalSaldos());
        System.out.println("<<------------------>>");
    }
}
