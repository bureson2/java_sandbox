package cz.cvut.fel.zks.bureson2.general;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;

public class Navigate {
    /**
     * An action that opens the browser on the Wikipedia home page
     */
    public static Performable toTheEshop() {
        return Open.url("https://e-shop.webowky.cz/");
    }
}