package view;


import calculator.Calculable;
import calculator.impl.ComplexCalculator;
import factory.ICalcFactory;
import logger.Log;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CalculatorView {
    private final ICalcFactory calcFactory;

    public CalculatorView(ICalcFactory calcFactory){
        this.calcFactory = calcFactory;
    }

    private static final Logger log = Log.log(CalculatorView.class.getName());


    public void run() {
        while (true) {
            float a;
            float b;
            Calculable complex1;
            ComplexCalculator complex2;
            Calculable complex3 = null;
            while (true) {

                String cmd = prompt("Введите команду (*, +, :, =) : ");
                if (cmd.equals("*")) {
                    log.log(Level.INFO, "производим умножение комплексного числа" +
                            "\nгде i = (-1)^1/2,\n" +
                            "по формуле: (a + bi)(c + di)\n");
                    System.out.println("\nгде i = (-1)^1/2,\n");
                    System.out.println("(a + bi)(c + di)\n");
                    a = promptFloat("\nвведите a ");
                    b = promptFloat("введите b ");
                    complex1 = new ComplexCalculator(a, b);
//                    complex1 = calcFactory.create(a,b);
                    a = promptFloat("введите c ");
                    b = promptFloat("введите d ");
//                    complex2 = calcFactory.create(a,b);   ломается
                    complex2 = new ComplexCalculator(a, b);
                    complex3 = complex1.multi(complex2);
                    continue;
                }
                if (cmd.equals("+")) {
                    log.log(Level.INFO, "производим сложение комплексного числа" +
                            "\nгде i = (-1)^1/2,\n" +
                            "по формуле: (a + bi) + (c + di)\n");
                    System.out.println("\nгде i = (-1)^1/2,\n");
                    System.out.println("(a + bi) + (c + di)\n");
                    a = promptFloat("\nвведите a ");
                    b = promptFloat("введите b ");
                    complex1 = new ComplexCalculator(a, b);
//                    complex1 = calcFactory.create(a,b);
                    a = promptFloat("введите с ");
                    b = promptFloat("введите d ");
//                    complex2 = calcFactory.create(a,b);
                    complex2 = new ComplexCalculator(a, b);
                    complex3 = complex1.sum(complex2);
                    continue;
                }
                if (cmd.equals(":")){
                    log.log(Level.INFO, "производим деление комплексного числа"+
                            "\nгде i = (-1)^1/2,\n" +
                            "по формуле: (a + bi)/(c + di)\n");
                    System.out.println("\nгде i = (-1)^1/2,\n");
                    System.out.println("(a + bi)/(c + di)\n");
                    a = promptFloat("\nвведите a ");
                    b = promptFloat("введите b ");
                    complex1 = new ComplexCalculator(a, b);
//                    complex1 = calcFactory.create(a,b);
                    a = promptFloat("введите с ");
                    b = promptFloat("введите d ");
                    complex2 = new ComplexCalculator(a, b);
//                    complex2 = calcFactory.create(a,b);
                    complex3 = complex1.div(complex2);
                    continue;
                }
                if (cmd.equals("=")) {
                    log.log(Level.INFO, "результат операции\n");
                    System.out.println("\n" + (complex3 != null ? complex3.toString() : null));
                    break;
                }
            }
            String cmd = prompt("Еще посчитать (Y/N)?");
            if (cmd.equalsIgnoreCase("Y")) {
                continue;
            }
            break;
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private Float promptFloat(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return Float.parseFloat(in.nextLine());
    }
}
