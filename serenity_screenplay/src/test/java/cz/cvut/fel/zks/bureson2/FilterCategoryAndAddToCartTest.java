package cz.cvut.fel.zks.bureson2;

import cz.cvut.fel.zks.bureson2.general.Navigate;
import cz.cvut.fel.zks.bureson2.pageobjects.EshopPage;
import cz.cvut.fel.zks.bureson2.questions.ItemInCart;
import cz.cvut.fel.zks.bureson2.tasks.AddItemToCart;
import cz.cvut.fel.zks.bureson2.tasks.SelectCategory;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class FilterCategoryAndAddToCartTest {
    @CastMember(name = "James")
    Actor james;

    @Test
    void selectCategoryAndSeeItems() {
        james.attemptsTo(
                Navigate.toTheEshop(),
                SelectCategory.forWomen()
        );
        james.attemptsTo(
                Ensure.that(EshopPage.ITEMS_IN_CATEGORY).isDisplayed()
        );
    }

    @Test
    void addCategoryItemToCart() {
        james.attemptsTo(
                Navigate.toTheEshop(),
                SelectCategory.forWomen(),
                AddItemToCart.firstItem()
        );

        james.attemptsTo(
                Ensure.that(ItemInCart.isAdded()).isTrue()
        );
    }

}
