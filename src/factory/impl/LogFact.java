package factory.impl;

import calculator.Calculable;
import calculator.impl.CalcDecorator;
import calculator.impl.ComplexCalculator;
import factory.ICalcFactory;
import logger.Log;

import java.util.logging.Logger;

public class LogFact implements ICalcFactory {

    @Override
    public Calculable create(float a, float b) {
        return new CalcDecorator(new ComplexCalculator(a, b));
    }
}
