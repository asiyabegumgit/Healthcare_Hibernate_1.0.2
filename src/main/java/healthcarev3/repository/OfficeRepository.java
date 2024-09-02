package healthcarev3.repository;

import healthcarev3.model.Office;

import java.util.List;

public interface OfficeRepository {
    void createOffice(Office office);
    Office getOfficeById(int officeId);
    void updateOffice(Office office);
    void deleteOffice(int officeId);
    List<Office> getAllOffices();
}
