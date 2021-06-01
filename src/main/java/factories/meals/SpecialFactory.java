package factories.meals;

import factories.MealFactory;

public class SpecialFactory extends MealFactory {

    @Override
    public Meal createMeal() {
        return new Special();
    }
}
