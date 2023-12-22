package calculator;

import calculator.impl.ComplexCalculator;

public interface Calculable {


    Calculable sum(ComplexCalculator otherNumber);
    Calculable multi(ComplexCalculator otherNumber);
    Calculable div(ComplexCalculator otherNumber);


}