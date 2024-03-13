package cz.cvut.fel.zks.bureson2.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static cz.cvut.fel.zks.bureson2.pageobjects.EshopPage.CART_QUANTITY;

public class ItemInCart implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        System.out.println(CART_QUANTITY.resolveFor(actor).getText());
        String s = CART_QUANTITY.resolveFor(actor).getText();
        return CART_QUANTITY.resolveFor(actor).getText().equals("1");
    }

    public static ItemInCart isAdded() {
        return new ItemInCart();
    }
}
