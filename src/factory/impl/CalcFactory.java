package factory.impl;

import calculator.Calculable;
import calculator.impl.ComplexCalculator;
import factory.ICalcFactory;

public class CalcFactory implements ICalcFactory {
    @Override
    public Calculable create(float a, float b) {
        return new ComplexCalculator(a, b);
    }
}
