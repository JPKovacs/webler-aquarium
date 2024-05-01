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

public class FishViewController {

    private final AquariumService aquariumService;
    private final FishService fishService;
    private final OwnerService ownerService;

    @GetMapping("/fishes")
    public String renderAllFishesOnWeb(Model model) {
        model.addAttribute("fishes", fishService.getAllFishes());
        return "fishes";
    }

    @GetMapping(value = "/create-fish")
    public String addEmptyFishToFishByFishIdOnWeb(@RequestParam Long fishId, Model model) {
        model.addAttribute("fishes", fishService.getFishById(fishId));
        return "create-fish";
    }

    @GetMapping(value = "/update-fish")
    public String updateFishOnWeb(@RequestParam Long fishId, Model model) {
        model.addAttribute("fishes", fishService.getFishById(fishId));
        return "update-fish";
    }
}
