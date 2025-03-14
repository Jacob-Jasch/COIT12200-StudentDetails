module coit12200.studentdetails {
    requires javafx.controls;
    requires javafx.fxml;

    opens coit12200.studentdetails to javafx.fxml;
    exports coit12200.studentdetails;
}
