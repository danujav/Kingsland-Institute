package lk.kingsland.mng.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.kingsland.mng.bo.BoFactory;
import lk.kingsland.mng.bo.custom.CourseBo;
import lk.kingsland.mng.dto.CourseDTO;
import lk.kingsland.mng.view.tm.CourseTM;
import lk.kingsland.mng.view.tm.StudentTM;

import java.util.ArrayList;
import java.util.Optional;

public class CourseFormController {
    public JFXTextField txtCode;
    public JFXTextField txtName;
    public JFXTextField txtCourseType;
    public JFXTextField txtDuration;
    public TableView<CourseTM> tblCourse;
    public TableColumn colCourseCode;
    public TableColumn colCourseName;
    public TableColumn colCourseType;
    public TableColumn colDuration;
    public TableColumn colOperation;

    private CourseBo bo;

    public void initialize() throws Exception {
        bo = BoFactory.getInstance().getBo(BoFactory.BoType.COURSE);
        colCourseCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colCourseName.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        colCourseType.setCellValueFactory(new PropertyValueFactory<>("courseType"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colOperation.setCellValueFactory(new PropertyValueFactory<>("btn"));

        loadAllCourses();
    }

    public void loadAllCourses() throws Exception {
        ObservableList<CourseTM> tmList = FXCollections.observableArrayList();
        ArrayList<CourseDTO> allCourse = bo.getAllCourse();
        for(CourseDTO dto : allCourse){
            Button btn = new Button("Delete");
            tmList.add(new CourseTM(
                    dto.getCode(),
                    dto.getCourseName(),
                    dto.getCourseType(),
                    dto.getDuration(),
                    btn));


            btn.setOnAction((e) -> {
                try {

                    ButtonType ok = new ButtonType("OK",
                            ButtonBar.ButtonData.OK_DONE);
                    ButtonType no = new ButtonType("NO",
                            ButtonBar.ButtonData.CANCEL_CLOSE);

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                            "Are You Sure ?", ok, no);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.orElse(no) == ok) {
                        if (bo.deleteCourse(dto.getCode())) {
                            new Alert(Alert.AlertType.CONFIRMATION,
                                    "Deleted", ButtonType.OK).show();
                            loadAllCourses();
                            return;
                        }
                        new Alert(Alert.AlertType.WARNING,
                                "Try Again", ButtonType.OK).show();
                    } else {
                        //no
                    }


                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });
        }
        tblCourse.setItems(tmList);
    }

    public void addOnAction(ActionEvent actionEvent) {
        try {
           if( bo.saveCourse(new CourseDTO(
                    txtCode.getText(),
                    txtName.getText(),
                    txtCourseType.getText(),
                    txtDuration.getText()
            ))){
               new Alert(Alert.AlertType.CONFIRMATION,"Added!").show();
               loadAllCourses();

               txtCode.setText(null);
               txtName .setText(null);
               txtCourseType.setText(null);
               txtDuration.setText(null);
           }
        } catch (Exception e) {
            new Alert(Alert.AlertType.WARNING,"Error!").show();
        }
    }
}
