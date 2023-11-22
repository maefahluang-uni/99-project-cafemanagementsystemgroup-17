package th.mfu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.mfu.domain.Material;
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
            Integer matAmount,
            Integer matPrice) {
        materialRepository.customUpdate(matId, matName, matAmount, matPrice);
    }

    // for search
    public List<Material> findBykeyword(String keywordString) {
        return materialRepository.findByKeyword(keywordString);
    }
}
