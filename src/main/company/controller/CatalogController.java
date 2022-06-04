package company.controller;

import company.entity.User.AuthUser;
import company.entity.Category.Category;
import company.repository.CategoryRepository;
import company.repository.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatalogController {

    private final CategoryRepository categoryRepository;
    private final SubcategoryRepository subcategoryRepository;

    @Autowired
    public CatalogController(CategoryRepository categoryRepository, SubcategoryRepository subcategoryRepository) {
        this.categoryRepository = categoryRepository;
        this.subcategoryRepository =subcategoryRepository;
    }

    @GetMapping("/")
    public String main(Model model, @AuthenticationPrincipal AuthUser user) {
        model.addAttribute("user", user);
        return "main";
    }

    @GetMapping("/menu")
    public String menu (Model model, @AuthenticationPrincipal AuthUser user) {

        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("subcategories", subcategoryRepository.findAll());
        model.addAttribute("user", user);
        return "menu";
    }

}
