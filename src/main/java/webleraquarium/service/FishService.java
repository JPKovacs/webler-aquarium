package webleraquarium.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import webleraquarium.entity.Fish;
import webleraquarium.exception.EntityAlreadyExistsException;
import webleraquarium.exception.InvalidInputException;
import webleraquarium.model.FishCreateAndUpdateModel;
import webleraquarium.model.FishModel;
import webleraquarium.repository.FishRepository;
import webleraquarium.util.FishMapper;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import static webleraquarium.util.FishMapper.mapFishCreateModelToFishEntity;
import static webleraquarium.util.FishMapper.mapFishEntityToFishModel;

@Service
@RequiredArgsConstructor
@Slf4j
public class FishService {

    private final FishRepository fishRepository;

    public List<FishModel> getAllFishes() {
        return fishRepository.findAll()
                .stream()
                .map(FishMapper::mapFishEntityToFishModel)
                .collect(Collectors.toList());
    }

    public Fish getFishById(Long id) {
        return fishRepository.findById(id)
                .orElseThrow(() -> {
                    String message = String.format("Fish not found with ID: %s", id);
                    log.info(message);
                    return new NoSuchElementException(message);
                });
    }

    public FishModel getFishByName(String name) {
        return mapFishEntityToFishModel(
                fishRepository.findByName(name)
                        .orElseThrow(() -> {
                            String message = String.format("Fish not found with name: %s", name);
                            log.info(message);
                            return new NoSuchElementException(message);
                        })
        );
    }

    private Optional<Fish> findFishByName(String name) {
        return fishRepository.findByName(name);
    }

    public FishModel addFish(FishCreateAndUpdateModel fishCreateAndUpdateModel) {
        Optional<Fish> existingFishWithThisName = findFishByName(fishCreateAndUpdateModel.getSpecies());
        if (isAllFieldsContainData(fishCreateAndUpdateModel) && existingFishWithThisName.isEmpty()) {
            return mapFishEntityToFishModel(fishRepository
                    .save(mapFishCreateModelToFishEntity(fishCreateAndUpdateModel)));
        } else {
            String name = fishCreateAndUpdateModel.getSpecies();
            String message = String.format("Please use another fish name, fish with this name %s already exists", name);
            throw new EntityAlreadyExistsException(message);
        }
    }

    public FishModel updateFish(Long id, FishCreateAndUpdateModel fishCreateAndUpdateModel) {
        Fish existingFish = getFishById(id);
        if (isAllFieldsContainData(fishCreateAndUpdateModel)) {
            addNewDataToExistingFish(existingFish, fishCreateAndUpdateModel);
        }
        return mapFishEntityToFishModel(fishRepository.save(existingFish));
    }

    private void addNewDataToExistingFish(Fish existingFish, FishCreateAndUpdateModel fishUpdateModel) {
        if (existingFish.getSpecies().equals(fishUpdateModel.getSpecies()) ||
                !isFishAlreadyExistsWithThisName(fishUpdateModel.getSpecies())) {
            existingFish.setSpecies(fishUpdateModel.getSpecies());
        } else {
            String name = fishUpdateModel.getSpecies();
            String message = String.format("Please use another fish name, fish with this name %s already exists", name);
            throw new EntityAlreadyExistsException(message);
        }
        existingFish.setColor(fishUpdateModel.getColor());
        existingFish.setAge(fishUpdateModel.getAge());
        existingFish.setWeight(fishUpdateModel.getWeight());
    }

    private boolean isAllFieldsContainData(FishCreateAndUpdateModel fishCreateModel) {
        if (
                fishCreateModel.getSpecies() != null &&
                        fishCreateModel.getColor() != null &&
                        fishCreateModel.getAge() != null &&
                        fishCreateModel.getWeight() != null
        ) {
            return true;
        } else throw new InvalidInputException("Please fill all fields");
    }

    private boolean isFishAlreadyExistsWithThisName(String fishName) {
        List<FishModel> fishes = getAllFishes();
        for (FishModel fish : fishes) {
            if (fish.getSpecies().equals(fishName)) {
                return true;
            }
        }
        return false;
    }

    public void deleteFish(Long id) {
        fishRepository.delete(getFishById(id));
    }
}
