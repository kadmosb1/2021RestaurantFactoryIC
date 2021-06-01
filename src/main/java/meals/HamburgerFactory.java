package meals;

import factories.MealFactory;

public class HamburgerFactory extends MealFactory {

    @Override
    public Meal createMeal() {
        return new Hamburger();
    }
}
