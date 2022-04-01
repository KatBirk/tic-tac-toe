module com.tictactoe.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens GUI_version to javafx.fxml;
    exports GUI_version;
}