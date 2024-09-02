package healthcarev3.service;

import healthcarev3.model.Office;
import healthcarev3.repository.OfficeRepository;

import java.util.List;

public class OfficeService {
    private OfficeRepository officeRepository;
    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }
    public void createOffice(Office office){
        officeRepository.createOffice(office);
    }
    public Office getOfficeById(int officeId){
        return officeRepository.getOfficeById(officeId);
    }
    public void updateOffice(Office office){
        officeRepository.updateOffice(office);
    }
    public void deleteOffice(int officeId){
        officeRepository.deleteOffice(officeId);
    }
    public List<Office> getAllOffices(){
        return officeRepository.getAllOffices();
    }

}
