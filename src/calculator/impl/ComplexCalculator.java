package calculator.impl;

import calculator.Calculable;

public class ComplexCalculator implements Calculable {
    private float a;
    private float b;
    private float newA;
    private float newB;
    Calculable newComplex;
    private int primaryArg;



    public ComplexCalculator(float num1, float num2){
        a = num1;
        b = num2;
    }
    public float getA(){
        return a;
    }
    public float getB(){
        return b;
    }

    @Override
    public Calculable sum(ComplexCalculator otherNumber) {
        newA = a + otherNumber.getA();
        newB = b + otherNumber.getB();
        newComplex = new ComplexCalculator(newA, newB);
        return newComplex;
    }

    @Override
    public Calculable multi(ComplexCalculator otherNumber) {
        newA = (a * otherNumber.getA()) - (b * otherNumber.getB());
        newB = (b * otherNumber.getA()) + (a * otherNumber.getB());
        newComplex = new ComplexCalculator(newA, newB);
        return newComplex;
    }

    @Override
    public Calculable div(ComplexCalculator otherNumber) {
        newA = ((a * otherNumber.getA()) + (b * otherNumber.getB())) / ((otherNumber.getA() * otherNumber.getA()) + (otherNumber.getB() * otherNumber.getB()));
        newB = ((b * otherNumber.getA()) - (a * otherNumber.getB())) / ((otherNumber.getA() * otherNumber.getA()) + (otherNumber.getB() * otherNumber.getB()));
        newComplex = new ComplexCalculator(newA, newB);
        return newComplex;
    }

    public String toString(){
        return "(" + a + ") + (" + b + ")i";
    }
}
