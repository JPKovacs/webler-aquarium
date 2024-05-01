package webleraquarium.view;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import webleraquarium.service.AquariumService;
import webleraquarium.service.FishService;
import webleraquarium.service.OwnerService;

@Controller
@RequiredArgsConstructor
@RequestMapping("")

public class AquariumViewController {

    private final AquariumService aquariumService;
    private final FishService fishService;
    private final OwnerService ownerService;

    @GetMapping(value = "/aquariums")
    public String renderAllAquariumsOnWeb(Model model) {
        model.addAttribute("aquariums", aquariumService.getAllAquariums());
        return "aquariums";
    }

    @GetMapping(value = "/create-aquarium")
    public String addEmptyAquariumToAquariumByAquariumIdOnWeb(@RequestParam Long aquariumId, Model model) {
        model.addAttribute("aquariums", aquariumService.getAquariumById(aquariumId));
        return "create-aquarium";
    }

    @GetMapping(value = "/update-aquarium")
    public String updateAquariumOnWeb(@RequestParam Long aquariumId, Model model) {
        model.addAttribute("aquariums", aquariumService.getAquariumById(aquariumId));
        return "update-aquarium";
    }

}
