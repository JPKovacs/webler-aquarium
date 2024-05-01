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

public class OwnerViewController {

    private final AquariumService aquariumService;
    private final FishService fishService;
    private final OwnerService ownerService;

    @GetMapping("/owners")
    public String renderAllOwnersOnWeb(Model model) {
        model.addAttribute("owners", ownerService.getAllOwners());
        return "owners";
    }

    @GetMapping(value = "/create-owner")
    public String addEmptyOwnerToOwnerByOwnerIdOnWeb(@RequestParam Long ownerId, Model model) {
        model.addAttribute("owners", ownerService.getOwnerById(ownerId));
        return "create-owner";
    }

    @GetMapping(value = "/update-owner")
    public String updateOwnerOnWeb(@RequestParam Long ownerId, Model model) {
        model.addAttribute("owners", ownerService.getOwnerById(ownerId));
        return "update-owner";
    }
}
