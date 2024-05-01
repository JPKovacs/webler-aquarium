package webleraquarium.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import webleraquarium.entity.Aquarium;
import webleraquarium.exception.EntityAlreadyExistsException;
import webleraquarium.exception.InvalidInputException;
import webleraquarium.model.AquariumCreateAndUpdateModel;
import webleraquarium.model.AquariumModel;
import webleraquarium.repository.AquariumRepository;
import webleraquarium.util.AquariumMapper;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import static webleraquarium.util.AquariumMapper.mapAquariumCreateModelToAquariumEntity;
import static webleraquarium.util.AquariumMapper.mapAquariumEntityToAquariumModel;

@Service
@RequiredArgsConstructor
@Slf4j
public class AquariumService {

    private final AquariumRepository aquariumRepository;

    public List<AquariumModel> getAllAquariums() {
        return aquariumRepository.findAll()
                .stream()
                .map(AquariumMapper::mapAquariumEntityToAquariumModel)
                .collect(Collectors.toList());
    }

    public AquariumModel addAquarium(AquariumCreateAndUpdateModel aquariumCreateAndUpdateModel) {
        Optional<Aquarium> existingAquariumWithThisName = Optional.ofNullable(findAquariumBySize(aquariumCreateAndUpdateModel.getSize()));
        if (isRequiredFieldsExistsAndContainData(aquariumCreateAndUpdateModel) ) {
            return  mapAquariumEntityToAquariumModel(aquariumRepository.save(mapAquariumCreateModelToAquariumEntity(aquariumCreateAndUpdateModel)));
        } else {
            throw new EntityAlreadyExistsException("Please provide all the fields for Aquarium!");
        }
    }

    private boolean isRequiredFieldsExistsAndContainData(AquariumCreateAndUpdateModel aquariumModelUpdateCreate) {
        if (aquariumModelUpdateCreate.getSize() != null && aquariumModelUpdateCreate.getCapacity() != null &&
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

    public Aquarium findAquariumBySize(Double size) {
        return aquariumRepository.findBySize(size)
                .orElseThrow(() -> {
                            String message = String.format("Aquarium with size %s not found", size);
                            log.info(message);
                            return new NoSuchElementException(message);
                        }
                );
    }

    public AquariumModel updateAquarium(Long id, AquariumCreateAndUpdateModel aquariumCreateAndUpdateModel) {
        Aquarium existingAquarium = getAquariumById(id);
        if (isRequiredFieldsExistsAndContainData(aquariumCreateAndUpdateModel)) {
            addNewDataToExistingAquarium(existingAquarium, aquariumCreateAndUpdateModel);
        }
        return mapAquariumEntityToAquariumModel(aquariumRepository.save(existingAquarium));
    }

    private void addNewDataToExistingAquarium(Aquarium existingAquarium, AquariumCreateAndUpdateModel aquariumUpdateModel) {
        existingAquarium.setSize(aquariumUpdateModel.getSize());
        existingAquarium.setCapacity(aquariumUpdateModel.getCapacity());
        existingAquarium.setTemperature(aquariumUpdateModel.getTemperature());
        existingAquarium.setWaterType(aquariumUpdateModel.getWaterType());
    }

    public void deleteAquarium(Long id) {
        aquariumRepository.delete(getAquariumById(id));
    }
}
