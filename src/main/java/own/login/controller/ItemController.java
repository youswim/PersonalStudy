package own.login.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import own.login.domain.Item;
import own.login.service.ItemService;

@Controller
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/item-detail/{id}")
    public String itemDetail(@PathVariable Long id) {
        return "/items/item-detail";
    }

    @GetMapping("/new")
    public String newItemForm() {
        return "/items/new-item-form";
    }

    @PostMapping("/new")
    public String newItemRequest(@ModelAttribute Item item, RedirectAttributes ra) {
        System.out.println(item);
        itemService.save(item);
        ra.addFlashAttribute("item", item);
        return "redirect:/items/item-detail/" + item.getId();
    }

    @GetMapping("/update/{id}")
    public String updateItemForm(@PathVariable Long id, Model model) {
        model.addAttribute(itemService.findById(id));
        return "/items/update-item-form";
    }

    @PostMapping("/update/")
    public String updateItemForm(@ModelAttribute Item item, RedirectAttributes ra) {
        itemService.update(item);
        ra.addFlashAttribute("item", item);
        return "redirect:/items/item-detail/" + item.getId();
    }
}
