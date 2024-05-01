package webleraquarium.util;

import lombok.NoArgsConstructor;
import webleraquarium.entity.Owner;
import webleraquarium.model.OwnerCreateModel;
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

    public static Owner mapOwnerCreateModelToOwnerEntity(OwnerCreateModel ownerCreateModel) {
        return Owner
                .builder()
                .name(ownerCreateModel.getName())
                .age(ownerCreateModel.getAge())
                .emailAddress(ownerCreateModel.getEmailAddress())
                .build();
    }
}
