package abstractfactories;

import meals.HamburgerFactory;
import meals.Meal;
import meals.SpecialFactory;

public abstract class MealFactory {

    public static final HamburgerFactory HAMBURGER_FACTORY = new HamburgerFactory ();
    public static final SpecialFactory SPECIAL_FACTORY = new SpecialFactory ();

    public abstract Meal createMeal ();
}