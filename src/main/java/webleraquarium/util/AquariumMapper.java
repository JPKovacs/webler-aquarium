package webleraquarium.util;

import lombok.NoArgsConstructor;
import webleraquarium.entity.Aquarium;
import webleraquarium.model.AquariumCreateAndUpdateModel;
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

    public static Aquarium mapAquariumCreateModelToAquariumEntity(AquariumCreateAndUpdateModel aquariumCreateAndUpdateModel) {
        return Aquarium
                .builder()
                .size(aquariumCreateAndUpdateModel.getSize())
                .capacity(aquariumCreateAndUpdateModel.getCapacity())
                .temperature(aquariumCreateAndUpdateModel.getTemperature())
                .waterType(aquariumCreateAndUpdateModel.getWaterType())
                .build();
    }
}
