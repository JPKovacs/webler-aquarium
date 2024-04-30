package webleraquarium.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webleraquarium.model.FishModel;
import webleraquarium.service.FishService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FishController {

    private final FishService fishService;

    @GetMapping("/fishes")
    public List<FishModel> listAllFishes() {
        return fishService.getAllFishes();
    }

    @PostMapping("/fishes")
    public ResponseEntity<FishModel> addFish(@RequestBody FishModel fishModel) {
        return ResponseEntity.status(200).body(fishService.addFish(fishModel));
    }

    @GetMapping("/fishes/fish/id/{id}")
    public ResponseEntity<FishModel> getFishById(Long id) {
        return ResponseEntity.status(200).body(fishService.getFishById(id));
    }

    @GetMapping("/fishes/fish/name/{name}")
    public ResponseEntity<FishModel> getFishByName(String name) {
        return ResponseEntity.status(200).body(fishService.getFishByName(name));
    }

    @PatchMapping("/fishes/fish/id/{id}")
    public ResponseEntity<FishModel> updateFish(Long id, FishModel fishModel) {
        return ResponseEntity.status(200).body(fishService.updateFish(id, fishModel));
    }

    @DeleteMapping("/fishes/fish/id/{id}")
    public ResponseEntity<Void> deleteFish(Long id) {
        fishService.deleteFish(id);
        return ResponseEntity.status(204).build();
    }
}
