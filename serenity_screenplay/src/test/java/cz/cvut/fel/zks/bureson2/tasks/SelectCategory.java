package cz.cvut.fel.zks.bureson2.tasks;

import cz.cvut.fel.zks.bureson2.pageobjects.EshopPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;

import static cz.cvut.fel.zks.bureson2.pageobjects.EshopPage.CATEGORY_WOMEN;

public class SelectCategory implements Performable {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CATEGORY_WOMEN)
        );
    }

    public static SelectCategory forWomen() {
        return new SelectCategory();
    }
}