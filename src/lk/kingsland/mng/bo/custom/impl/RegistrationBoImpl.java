package lk.kingsland.mng.bo.custom.impl;

import lk.kingsland.mng.bo.custom.RegistrationBo;
import lk.kingsland.mng.dto.RegistrationDTO;

import java.util.ArrayList;

public class RegistrationBoImpl implements RegistrationBo {
    @Override
    public boolean saveReg(RegistrationDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean updateReg(RegistrationDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean deleteReg(String id) throws Exception {
        return false;
    }

    @Override
    public RegistrationDTO getReg(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<RegistrationDTO> getAllReg() throws Exception {
        return null;
    }
}
