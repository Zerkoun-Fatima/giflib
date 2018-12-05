package io.github.mouadyou.giflib.data;

import io.github.mouadyou.giflib.model.Category;
import io.github.mouadyou.giflib.model.Gif;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class CategoryRepository {
    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1, "Technology"),
            new Category(2, "People"),
            new Category(3, "Destruction")
    );

    public List<Category> getAllCategories() {
        return ALL_CATEGORIES;
    }

    public Category getById(int id) {
        for (Category category : ALL_CATEGORIES) {
            if (category.getId() == id)
                return category;
        }
        return null;
    }
}
