module com.example.ruanmeibot {
    requires javafx.controls;
    requires javafx.fxml;
    requires lavaplayer;
    requires net.dv8tion.jda;
    requires annotations;


    opens com.example.ruanmeibot to javafx.fxml;
    exports com.example.ruanmeibot;
}