package webleraquarium.util;

import lombok.NoArgsConstructor;
import webleraquarium.entity.Fish;
import webleraquarium.model.FishCreateModel;
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

    public static Fish mapFishCreateModelToFishEntity(FishCreateModel fishCreateModel) {
        return Fish
                .builder()
                .species(fishCreateModel.getSpecies())
                .color(fishCreateModel.getColor())
                .age(fishCreateModel.getAge())
                .weight(fishCreateModel.getWeight())
                .build();
    }
}
