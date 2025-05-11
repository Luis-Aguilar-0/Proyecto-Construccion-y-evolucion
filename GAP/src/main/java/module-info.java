module uacm {
    
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.desktop;
    requires java.sql;
    requires javafx.graphics;
    
    opens uacm to javafx.fxml;
    opens uacm.utilities to javafx.fxml;
    
    exports uacm;
    exports uacm.utilities;
    exports logic;
}
