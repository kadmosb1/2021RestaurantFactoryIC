import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class MealTest {

    private static Seeder seeder;
    private static ByteArrayOutputStream output;

    @BeforeAll
    public static void init () {

        // In een seeder worden alle mogelijke maaltijden in een ArrayList toegevoegd. In de tests maken we
        // gebruik van de maaltijden die in deze seeder zijn aangemaakt.
        seeder = new Seeder ();

        // We leiden de output van System.out.println om naar een String, omdat we niet de output naar het scherm
        // testen.
        output = new ByteArrayOutputStream ();
        System.setOut (new PrintStream (output));
    }

    @Test
    /*
     * In deze methode wordt getest of getName van een maaltijd het juiste resultaat teruggeeft met haakjes, 'en' en ','
     * op de juiste plekken in de naam.
     */
    public void testGetName () {
        Meal meal = new Hamburger ();
        assertEquals ("Broodje Hamburger", meal.getName ());
        meal.addSoda ();
        assertEquals ("Broodje Hamburger (met drinken)", meal.getName ());
        meal.addFries ();
        assertEquals ("Broodje Hamburger (met drinken en frites)", meal.getName ());
        meal.addFries ();
        assertEquals ("Broodje Hamburger (met drinken, frites en frites)", meal.getName ());
    }

    @Test
    public void testGetSimpleOrder () {
        Meal meal = seeder.getMeal (0);
        String expectedOrder = System.lineSeparator () +
                               "===============================================" + System.lineSeparator() +
                               "= Bestelling: Broodje Hamburger" + System.lineSeparator() +
                               "===============================================";
        String actualOrder = meal.getOrder();
        assertEquals (expectedOrder, actualOrder);
    }

    @Test
    public void testGetComposedOrder () {

        Meal meal = seeder.getMeal (1);

        /*
         * Scanner wordt niet ingelezen vanaf het toetsenbord, maar uit de String invoer. Voor een Hamburger met
         * drinken en frites wordt gevraagd naar het drinken (de eerste string voor %n; Cola) en of er fritesaus bij de
         * frites moet worden toegevoegd (j).
         */
        String invoer = String.format ("Cola%nj%n");
        ByteArrayInputStream in = new ByteArrayInputStream (invoer.getBytes ());
        System.setIn (in);

        String expectedOrder = System.lineSeparator () +
                               "===============================================" + System.lineSeparator () +
                               "= Bestelling: Broodje Hamburger (met drinken en frites)" + System.lineSeparator () +
                               "= Drank: Cola" + System.lineSeparator () +
                               "= Extra fritessaus: ja" + System.lineSeparator () +
                               "===============================================";
        String actualOrder = meal.getOrder();
        assertEquals (expectedOrder, actualOrder);
    }
}