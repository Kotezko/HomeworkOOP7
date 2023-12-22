import factory.ICalcFactory;
import factory.impl.CalcFactory;
import factory.impl.LogFact;
import view.CalculatorView;

public class Main {
    public static void main(String[] args) {
        ICalcFactory calcFactory = new LogFact();
        CalculatorView view = new CalculatorView(calcFactory);
        view.run();
    }
}