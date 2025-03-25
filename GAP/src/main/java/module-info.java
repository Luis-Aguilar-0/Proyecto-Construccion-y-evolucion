module uacm.ig_soft.gap {
    requires javafx.controls;
    requires javafx.fxml;

    opens uacm.ig_soft.gap to javafx.fxml;
    exports uacm.ig_soft.gap;
}
