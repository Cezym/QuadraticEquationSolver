module com.program.quadraticequationsolver {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.program.quadraticequationsolver to javafx.fxml;
    exports com.program.quadraticequationsolver;
}