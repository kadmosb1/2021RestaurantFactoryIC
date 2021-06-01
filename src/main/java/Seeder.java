import abstractfactories.*;
import meals.Meal;

import java.util.ArrayList;

public class Seeder {

    private final ArrayList<Meal> meals = new ArrayList<> ();

    private void addFriesAndSoda (Meal meal) {
        meal.addIngredient (IngredientFactory.SODA_FACTORY);
        meal.addIngredient (IngredientFactory.FRIES_FACTORY);
    }

    private Meal getMeal (MealFactory factory, boolean withFriesAndSoda) {

        Meal meal = factory.createMeal ();

        if (withFriesAndSoda) {
            addFriesAndSoda (meal);
        }

        return meal;
    }

    public Seeder () {
        meals.add (getMeal (MealFactory.HAMBURGER_FACTORY, false));
        meals.add (getMeal (MealFactory.HAMBURGER_FACTORY, true));
        meals.add (getMeal (MealFactory.SPECIAL_FACTORY, false));
        meals.add (getMeal (MealFactory.SPECIAL_FACTORY, true));
    }

    public ArrayList<Meal> getMeals () {
        return meals;
    }

    public Meal getMeal (int index) {
        return meals.get (index);
    }
}
