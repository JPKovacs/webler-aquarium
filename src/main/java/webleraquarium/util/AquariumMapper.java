package webleraquarium.util;

import lombok.NoArgsConstructor;
import webleraquarium.entity.Aquarium;
import webleraquarium.model.AquariumCreateModel;
import webleraquarium.model.AquariumModel;

@NoArgsConstructor
public class AquariumMapper {

    public static AquariumModel mapAquariumEntityToAquariumModel(Aquarium aquarium) {
        return AquariumModel
                .builder()
                .size(aquarium.getSize())
                .capacity(aquarium.getCapacity())
                .temperature(aquarium.getTemperature())
                .waterType(aquarium.getWaterType())
                .build();
    }

    public static Aquarium mapAquariumCreateModelToAquariumEntity(AquariumCreateModel aquariumCreateModel) {
        return Aquarium
                .builder()
                .size(aquariumCreateModel.getSize())
                .capacity(aquariumCreateModel.getCapacity())
                .temperature(aquariumCreateModel.getTemperature())
                .waterType(aquariumCreateModel.getWaterType())
                .build();
    }
}
