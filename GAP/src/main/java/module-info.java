module uacm {
    
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires javafx.graphics;

    opens uacm to javafx.fxml;
    opens uacm.utilities to javafx.fxml;
    
    exports uacm;
    exports uacm.utilities;
}
