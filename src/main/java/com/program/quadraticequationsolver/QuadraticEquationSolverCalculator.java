package com.program.quadraticequationsolver;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.util.converter.NumberStringConverter;

class DoubleBindingRoots extends DoubleBinding {
    private final byte isFirst;
    private final SimpleDoubleProperty a, b;
    private final DoubleBinding delta;

    public DoubleBindingRoots(boolean isFirst, SimpleDoubleProperty a, SimpleDoubleProperty b, DoubleBinding delta) {
        this.isFirst = (byte) (isFirst ? -1 : 1);
        this.a = a;
        this.b = b;
        this.delta = delta;
    }

    @Override
    protected double computeValue() {
        {
            super.bind(a, b, delta);
        }

        return (-b.get() + isFirst * Math.pow(delta.get(), 0.5)) / (2 * a.get());
    }
}

public class QuadraticEquationSolverCalculator {
    private final SimpleDoubleProperty a, b, c;
    private final DoubleBinding delta;
    private final SimpleDoubleProperty x1, x2;

    public QuadraticEquationSolverCalculator() {
        a = new SimpleDoubleProperty(null, "a");
        b = new SimpleDoubleProperty(null, "b");
        c = new SimpleDoubleProperty(null, "c");
        delta = new DoubleBinding() {
            {
                super.bind(a, b, c);
            }

            @Override
            protected double computeValue() {
                return b.get() * b.get() - 4 * a.get() * c.get();
            }
        };
        x1 = new SimpleDoubleProperty(null, "x1");
        x2 = new SimpleDoubleProperty(null, "x2");
    }

    public void initEqCalculator(StringProperty aSB, StringProperty bSB, StringProperty cSB) {
        NumberStringConverter numberStringConverter = new NumberStringConverter();
        Bindings.bindBidirectional(aSB, a, numberStringConverter);
        Bindings.bindBidirectional(bSB, b, numberStringConverter);
        Bindings.bindBidirectional(cSB, c, numberStringConverter);
        x1.bind(new DoubleBindingRoots(true, a, b, delta));
        x2.bind(new DoubleBindingRoots(false, a, b, delta));
    }

    public String getAnswers() {
        if (delta.get() < 0)
            return "x1 and x2 dosen't exist.";

        if (!(x1.get() == (x2.get())))
            return "x1 = " + x1.get() + ", x2 = " + x2.get();

        return "x = " + x1.get();

    }

}
