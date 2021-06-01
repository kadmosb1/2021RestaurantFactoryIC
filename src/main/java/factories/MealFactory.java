package factories;

import factories.meals.HamburgerFactory;
import factories.meals.Meal;
import factories.meals.SpecialFactory;

public abstract class MealFactory {

    public static final HamburgerFactory HAMBURGER_FACTORY = new HamburgerFactory ();
    public static final SpecialFactory SPECIAL_FACTORY = new SpecialFactory ();

    public abstract Meal createMeal ();
}