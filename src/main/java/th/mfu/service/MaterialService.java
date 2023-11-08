package th.mfu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.mfu.repository.MaterialRepository;

@Service
public class MaterialService {
    @Autowired
    private final MaterialRepository materialRepository;

    @Autowired
    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    public void updateMat(
            Long matId,
            String matName,
            Integer matAmount) {
        materialRepository.customUpdate(matId, matName, matAmount);
    }

}
