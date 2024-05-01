package webleraquarium.util;

import lombok.NoArgsConstructor;
import webleraquarium.entity.Owner;
import webleraquarium.model.OwnerCreateAndUpdateModel;
import webleraquarium.model.OwnerModel;

@NoArgsConstructor
public class OwnerMapper {

    public static OwnerModel mapOwnerEntityToOwnerModel(Owner owner) {
        return OwnerModel
                .builder()
                .name(owner.getName())
                .age(owner.getAge())
                .emailAddress(owner.getEmailAddress())
                .build();
    }

    public static Owner mapOwnerCreateModelToOwnerEntity(OwnerCreateAndUpdateModel ownerCreateAndUpdateModel) {
        return Owner
                .builder()
                .name(ownerCreateAndUpdateModel.getName())
                .age(ownerCreateAndUpdateModel.getAge())
                .emailAddress(ownerCreateAndUpdateModel.getEmailAddress())
                .build();
    }
}
