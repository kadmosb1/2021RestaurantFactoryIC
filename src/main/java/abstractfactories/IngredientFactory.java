package abstractfactories;

import ingredients.*;

public abstract class IngredientFactory {

    public static final SodaFactory SODA_FACTORY = new SodaFactory ();
    public static final FriesFactory FRIES_FACTORY = new FriesFactory ();

    public abstract IIngredient creatIngredient ();
}
