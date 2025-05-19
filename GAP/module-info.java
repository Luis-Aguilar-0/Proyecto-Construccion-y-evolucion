module uacm {
    
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    //requires javafx.graphics;
    //requires java.sql;
    requires java.desktop;
    requires transitive java.sql;
    requires transitive javafx.graphics;

    opens uacm to javafx.fxml;
    opens uacm.utilities to javafx.fxml;
    
    exports uacm;
    exports uacm.utilities;
    exports logic;

}