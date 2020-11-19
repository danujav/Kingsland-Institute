package lk.kingsland.mng.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.kingsland.mng.bo.BoFactory;
import lk.kingsland.mng.bo.custom.StudentBo;
import lk.kingsland.mng.dto.StudentDTO;
import lk.kingsland.mng.view.tm.StudentTM;

import java.util.List;
import java.util.Observable;

public class StudentFormController {
    public JFXTextField txtId;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;
    public JFXTextField txtDob;
    public TableView<StudentTM> tblStudent;
    public JFXComboBox cmbGender;
    public TableColumn colStudentId;
    public TableColumn colStudentName;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colDob   ;
    public TableColumn colGender;
    StudentBo bo;

    public void initialize() throws Exception {
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.add("Male");
        observableList.add("Female");
        cmbGender.setItems(observableList);

        bo = BoFactory.getInstance().getBo(BoFactory.BoType.STUDENT);

        colStudentId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));

        loadAllStudent();

        /*tblStudent.getSelectionModel().
                selectedItemProperty().addListener((observable, oldValue, newValue)->{
                    setData(newValue);
                });*/

        tblStudent.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    setData(newValue);
                });
    }
    private void setData(StudentTM tm) {
        txtId.setText(tm.getId());
        txtName.setText(tm.getName());
        txtAddress.setText(tm.getAddress());
        txtContact.setText(tm.getContact());
        txtDob.setText(tm.getDob());
        cmbGender.setValue(tm.getGender());
    }

    public void loadAllStudent() throws Exception {
        ObservableList<StudentTM> tmList = FXCollections.observableArrayList();

        List<StudentDTO> allStudent = bo.getAllStudent();
        for(StudentDTO dto : allStudent){
            tmList.add(new StudentTM(
                    dto.getId(),
                    dto.getStudentName(),
                    dto.getAddress(),
                    dto.getContact(),
                    dto.getDob(),
                    dto.getGender()));
        }
        tblStudent.setItems(tmList);
    }

    public void addOnAction(ActionEvent actionEvent)  {
        try {
            if(bo.saveStudent(new StudentDTO(txtId.getText(), txtName.getText(), txtAddress.getText(),
                    txtContact.getText(), txtDob.getText(), cmbGender.getValue().toString()))){
                new Alert(Alert.AlertType.CONFIRMATION,"Added!").show();
                loadAllStudent();

                txtId.setText(null);
                txtName.setText(null);
                txtAddress.setText(null);
                txtContact.setText(null);
                txtDob.setText(null);
                cmbGender.setValue(null);
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.WARNING,"Error").show();
        }

    }

    public void searchOnAction(ActionEvent actionEvent) throws Exception {
        StudentDTO dto = bo.getStudent(txtId.getText());
        if(null != dto){
            txtName.setText(dto.getStudentName());
            txtAddress.setText(dto.getAddress());
            txtContact.setText(dto.getContact());
            txtContact.setText(dto.getContact());
            cmbGender.setValue(dto.getGender());
        }
    }
}
