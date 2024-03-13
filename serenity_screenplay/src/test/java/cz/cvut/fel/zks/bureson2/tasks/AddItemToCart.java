package cz.cvut.fel.zks.bureson2.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;

import static cz.cvut.fel.zks.bureson2.pageobjects.EshopPage.*;


public class AddItemToCart implements Performable {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(FIRST_ITEM),
                MoveMouse.to(FIRST_ITEM),
                Click.on(ADD_TO_CART_BUTTON),
                Click.on(CLOSE_BUTTON)
                );
    }

    public static AddItemToCart firstItem() {
        return new AddItemToCart();
    }
}