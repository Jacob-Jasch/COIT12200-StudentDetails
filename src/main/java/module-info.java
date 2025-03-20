module coit12200.studentdetails {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens coit12200.studentdetails to javafx.fxml;
    exports coit12200.studentdetails;
}
