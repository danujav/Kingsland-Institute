package lk.kingsland.mng.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class DashBoardFormController {
    public AnchorPane root;
    public Label timeLbl;
    public Label dateLbl;
    public AnchorPane middleRoot;
    public AnchorPane headRoot;
    public AnchorPane mainRoot;


    public void initialize() throws IOException {
        updateDate();
    }

    private void updateDate(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String orderDate = sdf.format(date);
        dateLbl.setText(orderDate);

    }
    public void homeOnAction(ActionEvent actionEvent) throws IOException {
        this.mainRoot.getChildren().clear();
        this.mainRoot.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/DashBoardForm.fxml")));
    }

    public void studentOnAction(ActionEvent actionEvent) throws IOException {
        initUi("StudentForm.fxml");
    }

    public void registerOnAction(ActionEvent actionEvent) throws IOException {
        initUi("RegForm.fxml");
    }

    public void courseOnAction(ActionEvent actionEvent) throws IOException {
        initUi("CourseForm.fxml");
    }

    public void homeActionButton(ActionEvent actionEvent) throws IOException {
        this.mainRoot.getChildren().clear();
        this.mainRoot.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/DashBoardForm.fxml")));
    }

    private void initUi(String location) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/" + location)));


    }
}
