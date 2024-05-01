package webleraquarium.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webleraquarium.model.AquariumCreateAndUpdateModel;
import webleraquarium.model.AquariumModel;
import webleraquarium.service.AquariumService;

import java.util.List;

import static webleraquarium.util.AquariumMapper.mapAquariumEntityToAquariumModel;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AquariumController {

    private final AquariumService aquariumService;

    @GetMapping("/aquariums")
    public ResponseEntity<List<AquariumModel>> listAllAquariums() {
        return ResponseEntity.status(200).body(aquariumService.getAllAquariums());
    }

    @PostMapping("/aquariums")
    public ResponseEntity<AquariumModel> addAquarium(@RequestBody AquariumCreateAndUpdateModel aquariumCreateAndUpdateModel) {
        return ResponseEntity.status(200).body(aquariumService.addAquarium(aquariumCreateAndUpdateModel));
    }

    @GetMapping("/aquariums/aquarium/id/{id}")
    public ResponseEntity<AquariumModel> getAquariumById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(mapAquariumEntityToAquariumModel(aquariumService.getAquariumById(id)));
    }

    @DeleteMapping("/aquariums/aquarium/id/{id}")
    public ResponseEntity<Void> deleteAquarium(@PathVariable Long id) {
        aquariumService.deleteAquarium(id);
        return ResponseEntity.status(204).build();
    }

    @PatchMapping("/aquariums/aquarium/id/{id}")
    public ResponseEntity<AquariumModel> updateAquarium(@PathVariable Long id, @RequestBody AquariumCreateAndUpdateModel aquariumCreateAndUpdateModel) {
        return ResponseEntity.status(200).body(aquariumService.updateAquarium(id, aquariumCreateAndUpdateModel));
    }

}
