package io.github.mouadyou.giflib.controller;

import io.github.mouadyou.giflib.data.CategoryRepository;
import io.github.mouadyou.giflib.data.GifRepository;
import io.github.mouadyou.giflib.model.Category;
import io.github.mouadyou.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/categories")
    public String getAllCategories(ModelMap modelMap) {
        List<Category> categoryList = categoryRepository.getAllCategories();
        modelMap.put("categories", categoryList);
        return "categories";
    }

    @RequestMapping("/category/{id}")
    public String getAllCategories(@PathVariable int id, ModelMap modelMap) {
        Category category = categoryRepository.getById(id);
        modelMap.put("category", category);

        List<Gif> gifs = gifRepository.findByCategoryId(id);
        modelMap.put("gifs", gifs);
        return "category";
    }
}
