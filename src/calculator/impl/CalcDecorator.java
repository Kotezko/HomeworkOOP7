package calculator.impl;

import calculator.Calculable;
import logger.Log;
import view.CalculatorView;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CalcDecorator implements Calculable {
    private final Calculable calc;
    private final Logger log = Log.log(CalcDecorator.class.getName());

    public CalcDecorator(ComplexCalculator calc) {
        this.calc = calc;

    }

    @Override
    public Calculable sum(ComplexCalculator otherNumber) {
        log.log(Level.INFO, "производим сложение комплексного числа" +
                "\nгде i = (-1)^1/2,\n" +
                "по формуле: (a + bi) + (c + di)\n");
        System.out.println("asdasdasd");
        Calculable result = calc.sum(otherNumber);
        return result;
    }

    @Override
    public Calculable multi(ComplexCalculator otherNumber) {
        log.log(Level.INFO, "производим умножение комплексного числа" +
                "\nгде i = (-1)^1/2,\n" +
                "по формуле: (a + bi)(c + di)\n");
        Calculable result = calc.multi(otherNumber);
        return result;
    }

    @Override
    public Calculable div(ComplexCalculator otherNumber) {
        log.log(Level.INFO, "производим деление комплексного числа"+
                "\nгде i = (-1)^1/2,\n" +
                "по формуле: (a + bi)/(c + di)\n");
        Calculable result = calc.div(otherNumber);
        return result;
    }
}
