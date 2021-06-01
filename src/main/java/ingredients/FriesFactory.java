package ingredients;

import abstractfactories.IngredientFactory;

public class FriesFactory extends IngredientFactory {

    @Override
    public IIngredient creatIngredient() {
        return new Fries ();
    }
}