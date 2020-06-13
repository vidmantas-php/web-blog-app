package lt.web.demo.controller;

import javax.validation.Valid;

import lt.web.demo.entities.Categories;
import lt.web.demo.entities.Item;
import lt.web.demo.entities.User;
import lt.web.demo.services.CategoriesService;
import lt.web.demo.services.ItemService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/private/items")
@SessionAttributes("created")
public class ItemPrivateController {
    private ItemService itemService;
    private CategoriesService categoriesService;

    public ItemPrivateController(
            ItemService itemService,
            CategoriesService categoriesService
    ) {
        this.itemService = itemService;
        this.categoriesService = categoriesService;
    }

    @GetMapping("/item/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String getUpdateItemForm(@PathVariable Long id, Model model, @AuthenticationPrincipal User user) {
        Item item = itemService.getItem(id);
        model.addAttribute("user", user);
        model.addAttribute("item", item);
        return "itemform";
    }

    @GetMapping("/item")
    @PreAuthorize("hasRole('ADMIN')")
    public String createItemForm(Model model) {
        //
        List<Categories> categories = categoriesService.getAllCategories();

        model.addAttribute("categories", categories);
        //
        model.addAttribute("item", new Item());
        return "itemform";
    }

    @GetMapping("/item/{id}/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteItem(@PathVariable Long id, Model model) {
        itemService.deleteItem(id);
        List<Item> items = itemService.getAllItems();
        model.addAttribute("items", items);
        return "items";
    }

    @PostMapping("/item")
    @PreAuthorize("hasRole('ADMIN')")
    public String submitItem(@Valid Item item, BindingResult errors, Model model, RedirectAttributes redirectAttributes) {

        if (errors.hasErrors()) {
            return "itemform";
        }

        Item newItem = itemService.createOrUpdateItem(item);
        model.addAttribute("item", newItem);

        redirectAttributes.addFlashAttribute("created", true);

        return "redirect:/public/items/" + newItem.getId();
    }

}