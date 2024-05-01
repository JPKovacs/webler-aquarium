package webleraquarium.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import webleraquarium.entity.Aquarium;
import webleraquarium.model.AquariumModel;
import webleraquarium.repository.AquariumRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class AquariumService {

    private final AquariumRepository aquariumRepository;

    public List<AquariumModel> getAllAquariums() {
        return aquariumRepository.findAll();
    }

    public AquariumModel addAquarium(AquariumModelUpdateCreate aquariumModelUpdateCreate) {

        if (isRequiredFieldsExistsAndContainData(aquariumModelUpdateCreate) ) {
            return  mapAquariumEntityToAquariumModel(aquariumRepository.save(mapAquariumCreateModelToAquariumEntity(aquariumModelUpdateCreate)));
        } else {
            throw new EntityAlreadyExistsException("Please provide all the fields for Aquarium!");
        }
    }

    private boolean isRequiredFieldsExistsAndContainData(AquariumModelUpdateCreate aquariumModelUpdateCreate) {
        if (
                aquariumModelUpdateCreate.getSize() != null && aquariumModelUpdateCreate.getCapacity() != null &&
                        aquariumModelUpdateCreate.getTemperature() != null && !aquariumModelUpdateCreate.getWaterType().equals("")
        ) {
            return true;
        } else throw new InvalidInputException("Please provide all the fields for Aquarium!");
    }

    public Aquarium getAquariumById(Long id) {
        return aquariumRepository.findById(id)
                .orElseThrow(() -> {
                            String message = String.format("Aquarium with id %s not found", id);
                            log.info(message);
                            return new NoSuchElementException(message);
                        }
                );
    }

    public AquariumModel updateAquarium(Long id, AquariumUpdateModel aquariumUpdateModel) {
        Aquarium existingAquarium = getAquariumById(id);
        if (isRequiredFieldsExistsAndContainData(aquariumUpdateModel)) {
            addNewDataToExistingAquarium(existingAquarium, aquariumUpdateModel);
        }
        return AquariumMapper.mapAquariumEntityToAquariumModel(aquariumRepository.save(existingAquarium));
    }

    private void addNewDataToExistingAquarium(Aquarium existingAquarium, AquariumUpdateModel aquariumUpdateModel) {
        existingAquarium.setSize(aquariumUpdateModel.getSize());
        existingAquarium.setCapacity(aquariumUpdateModel.getCapacity());
        existingAquarium.setTemperature(aquariumUpdateModel.getTemperature());
        existingAquarium.setWaterType(aquariumUpdateModel.getWaterType());
    }




    public void deleteAquarium(Long id) {
        aquariumRepository.delete(getAquariumById(id));
    }
}
