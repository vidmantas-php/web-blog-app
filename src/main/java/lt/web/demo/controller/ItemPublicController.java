package lt.web.demo.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpSession;

import lt.web.demo.entities.Item;
import lt.web.demo.entities.User;
import lt.web.demo.services.ItemService;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/public/items")
public class ItemPublicController {

    private ItemService itemService;

    public ItemPublicController(
            ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/{id}")
    public String getItem(@PathVariable Long id, Model model, @AuthenticationPrincipal User user,
                             HttpSession session) {
        Item item = itemService.getItem(id);
        model.addAttribute("item", item);
        model.addAttribute("user", user);

        return "item";
    }

    @GetMapping
    public String getItemsByPage(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(required = false) BigDecimal price,
            Model model,
            @AuthenticationPrincipal User user
    ) {
        Page<Item> items = itemService.getAllItemsPaginated(pageNumber, price);
        model.addAttribute("items", items.getContent());
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("hasNextPage", items.hasNext());
        model.addAttribute("user", user);

        return "items";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

}