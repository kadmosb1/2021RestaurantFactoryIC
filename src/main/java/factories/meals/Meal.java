package factories.meals;

import factories.ingredients.IIngredient;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Meal {

    private final String name;
    private final ArrayList<IIngredient> ingredients;

    public Meal (String name) {
        this.name = name;
        this.ingredients = new ArrayList<> ();
    }

    public String getName () {

        StringBuilder name = new StringBuilder ();
        name.append (this.name);

        for (int i = 0; i < ingredients.size (); i++) {

            if (i == 0) {
                name.append (" (met ");
            }
            else if (i == (ingredients.size () - 1)) {
                name.append (" en ");
            }
            else {
                name.append (", ");
            }

            name.append (ingredients.get (i).getName ());
        }

        return name + (ingredients.size () > 0 ? ")" : "");
    }

    public void addIngredient (IIngredient ingredient) {
        ingredients.add (ingredient);
    }

    public abstract String getOrderLine ();

    public String getOrder () {

        Scanner scanner = new Scanner (System.in);

        StringBuilder bestelling = new StringBuilder ();
        bestelling.append (String.format ("%n===============================================%n"));
        bestelling.append (String.format ("= Bestelling: %s%n", getName ()));
        bestelling.append (getOrderLine ());

        for (IIngredient ingredient : ingredients) {
            bestelling.append (ingredient.getOrderLine (scanner));
        }

        return bestelling + "===============================================";
    }
}