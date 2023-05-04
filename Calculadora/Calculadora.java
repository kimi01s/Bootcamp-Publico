public class Calculadora {
    private double firstValue;
    private double secondValue;
    private char operation;
    private double result;

    public Calculadora(){
        
    }
    public void setOperandOne(double firstvalue) {
        this.firstValue = firstvalue;
    }

    public double getOperandOne() {
        return this.firstValue;
    }

    public void setOperandOTwo(double secondvalue) {
        this.secondValue = secondvalue;
    }

    public double getOperandTwo() {
        return this.secondValue;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }

    public char getOperation() {
        return this.operation;
    }

    public void perfomOperation() {
        if(this.operation == '+'){
            this.result = firstValue + secondValue;
        }
        if(this.operation == '-'){
            this.result = firstValue - secondValue;
        }
    }

    public double getResult() {
        return this.result;
    }
}