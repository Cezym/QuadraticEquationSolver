package com.program.quadraticequationsolver;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;

public class QuadraticEquationSolverView {
    private final GridPane root;
    private final Label controls;
    private final TextField a, b, c;
    private final Button solve, clear;

    public QuadraticEquationSolverView() {
        root = new GridPane();

        controls = new Label();
        controls.setMinWidth(300);
        controls.setMaxWidth(300);
        controls.setAlignment(Pos.CENTER);
        root.add(controls, 0, 0);

        GridPane abc = new GridPane();
        a = new TextField();
        abc.add(a, 0, 0);
        a.setTooltip(new Tooltip("Enter a"));
        b = new TextField();
        abc.add(b, 1, 0);
        b.setTooltip(new Tooltip("Enter b"));
        c = new TextField();
        abc.add(c, 2, 0);
        c.setTooltip(new Tooltip("Enter c"));
        root.add(abc, 0, 1);

        solve = new Button();
        solve.setMinWidth(300);
        solve.setMaxWidth(300);
        root.add(solve, 0, 2);

        clear = new Button();
        clear.setMinWidth(300);
        clear.setMaxWidth(300);
        root.add(clear, 0, 3);

        root.setMaxWidth(300);
        root.setMinWidth(300);
        root.setPrefWidth(300);
    }

    public GridPane getRoot() {
        return root;
    }

    public Label getControls() {
        return controls;
    }

    public TextField getA() {
        return a;
    }

    public TextField getB() {
        return b;
    }

    public TextField getC() {
        return c;
    }

    public Button getSolve() {
        return solve;
    }

    public Button getClear() {
        return clear;
    }
}
