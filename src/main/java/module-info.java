module org.sed.javafxfxmltestingground {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.sed.javafxfxmltestingground to javafx.fxml;
    exports org.sed.javafxfxmltestingground;
}
