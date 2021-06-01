import java.util.ArrayList;

public class Seeder {

    private ArrayList<Meal> meals = new ArrayList<> ();

    private Meal getMealWithFriesAndSoda (Meal meal) {
        meal.addSoda ();
        meal.addFries ();
        return meal;
    }

    public Seeder () {
        meals.add (new Hamburger ());
        meals.add (getMealWithFriesAndSoda (new Hamburger ()));
        meals.add (new Special ());
        meals.add (getMealWithFriesAndSoda (new Special ()));
    }

    public ArrayList<Meal> getMeals () {
        return meals;
    }

    public Meal getMeal (int index) {
        return meals.get (index);
    }
}
