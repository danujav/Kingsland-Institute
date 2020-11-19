package lk.kingsland.mng.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import lk.kingsland.mng.bo.BoFactory;
import lk.kingsland.mng.bo.custom.RegistrationBo;
import lk.kingsland.mng.bo.custom.StudentBo;
import lk.kingsland.mng.dto.RegistrationDTO;
import lk.kingsland.mng.dto.StudentDTO;
import lk.kingsland.mng.entity.Registration;

public class RegFormController {
    public TextField txtSearchId;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtReg;
    public JFXComboBox cmbCourse;
    public JFXTextField txtFee;

    private RegistrationBo bo = BoFactory.getInstance().getBo(BoFactory.BoType.REGISTRATION);
    private StudentBo bo2 = BoFactory.getInstance().getBo(BoFactory.BoType.STUDENT);


    public void searchOnAction(ActionEvent actionEvent) throws Exception {
        StudentDTO dto = bo2.getStudent(txtSearchId.getId());
        if(dto != null){
            /*String id = dto.getId();
            StudentDTO student = bo2.getStudent(id);*/
            txtName.setText(dto.getStudentName());
            txtAddress.setText(dto.getAddress());





        }
    }

    public void regOnAction(ActionEvent actionEvent) {

    }
}
