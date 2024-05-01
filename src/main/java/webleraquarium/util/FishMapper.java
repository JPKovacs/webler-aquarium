package webleraquarium.util;

import lombok.NoArgsConstructor;
import webleraquarium.entity.Fish;
import webleraquarium.model.FishCreateAndUpdateModel;
import webleraquarium.model.FishModel;

@NoArgsConstructor
public class FishMapper {

    public static FishModel mapFishEntityToFishModel(Fish fish) {
        return FishModel
                .builder()
                .species(fish.getSpecies())
                .color(fish.getColor())
                .age(fish.getAge())
                .weight(fish.getWeight())
                .build();
    }

    public static Fish mapFishCreateModelToFishEntity(FishCreateAndUpdateModel fishCreateAndUpdateModel) {
        return Fish
                .builder()
                .species(fishCreateAndUpdateModel.getSpecies())
                .color(fishCreateAndUpdateModel.getColor())
                .age(fishCreateAndUpdateModel.getAge())
                .weight(fishCreateAndUpdateModel.getWeight())
                .build();
    }
}
