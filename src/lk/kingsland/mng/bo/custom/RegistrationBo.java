package lk.kingsland.mng.bo.custom;

import lk.kingsland.mng.dto.RegistrationDTO;

import java.util.ArrayList;

public interface RegistrationBo {
    public boolean saveReg(RegistrationDTO dto)throws Exception;
    public boolean updateReg(RegistrationDTO dto)throws Exception;
    public boolean deleteReg(String id)throws Exception;
    public RegistrationDTO getReg(String id)throws Exception;
    public ArrayList<RegistrationDTO> getAllReg()throws Exception;
}
