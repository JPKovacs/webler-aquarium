package webleraquarium.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webleraquarium.model.OwnerModel;
import webleraquarium.service.OwnerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OwnerController {

    private final OwnerService ownerService;

    @GetMapping("/owners")
    public List<OwnerModel> listAllOwners() {
        return ownerService.getAllOwners();
    }

    @PostMapping("/owners")
    public ResponseEntity<OwnerModel> addOwner(@RequestBody OwnerModel ownerModel) {
        return ResponseEntity.status(200).body(ownerService.addOwner(ownerModel));
    }

    @GetMapping("/owners/owner/id/{id}")
    public ResponseEntity<OwnerModel> getOwnerById(Long id) {
        return ResponseEntity.status(200).body(ownerService.getOwnerById(id));
    }

    @GetMapping("/owners/owner/name/{name}")
    public ResponseEntity<OwnerModel> getOwnerByName(String name) {
        return ResponseEntity.status(200).body(ownerService.getOwnerByName(name));
    }

    @PatchMapping("/owners/owner/id/{id}")
    public ResponseEntity<OwnerModel> updateOwner(Long id, OwnerModel ownerModel) {
        return ResponseEntity.status(200).body(ownerService.updateOwner(id, ownerModel));
    }

    @DeleteMapping("/owners/owner/id/{id}")
    public ResponseEntity<Void> deleteOwner(Long id) {
        ownerService.deleteOwner(id);
        return ResponseEntity.status(204).build();
    }
}
