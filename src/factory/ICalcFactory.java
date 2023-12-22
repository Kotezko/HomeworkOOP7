package factory;

import calculator.Calculable;

public interface ICalcFactory {
    Calculable create(float a, float b);
}
