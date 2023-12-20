package com.example.ruanmeibot;
import com.example.ruanmeibot.ruanmei.RuanMeiDiscord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    public void run(ActionEvent a) throws Exception {
        RuanMeiDiscord.main(null);
        System.out.println("Run");
    }
}
