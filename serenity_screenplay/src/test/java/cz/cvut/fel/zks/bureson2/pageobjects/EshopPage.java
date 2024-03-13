package cz.cvut.fel.zks.bureson2.pageobjects;


import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://e-shop.webowky.cz/")
public class EshopPage extends PageObject {

    public static final Target CATEGORY_WOMEN = Target.the("Category Women")
            .locatedBy("//a[text()='Women']");
    public static final Target ADD_TO_CART_BUTTON = Target
            .the("Add to Cart Button")
            .locatedBy("#product_list > li:nth-child(1) > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default");

    public static final Target FIRST_ITEM = Target
            .the("Add to Cart Button")
            .locatedBy("#product_list > li:nth-child(1)");

    public static final Target CLOSE_BUTTON = Target
            .the("Close modal cross")
            .locatedBy("#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6 > span.cross");

    public static final Target ITEMS_IN_CATEGORY = Target
            .the("Items in category")
            .locatedBy("#product_list");

    public static final Target CART_QUANTITY = Target
            .the("Cart quantity")
            .locatedBy("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a > span.ajax_cart_quantity.unvisible");

}
