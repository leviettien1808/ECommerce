package Actions;

import Objects.Product;
import Pages.Page_Shopping_Checkout;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class Action_Shopping_Checkout {
    /**
     * So sánh tên sản phẩm trên Basket popup với tên sản phẩm ở trên
     * Checkout popup có giống nhau không?
     * @param driver
     * @param product dùng để lấy tên sản phẩm
     */
    public static void checkProductsDisplayOnCheckoutPopup(WebDriver driver, Product product) {
        Action_Shopping_ManageBasket.addItemToBasket(driver);
        // Lấy tên sản phẩm ở Basket popup.
        // expected = name product on Basket popup
        String expected = Action_Shopping_ManageBasket.getNameProductOnBasketPopup(driver);
        // Gán cái tên sản phẩm mới lấy được ở Basket popup vào đối tượng product.
        product.setName(expected);
        // Chuyển qua Checkout popup
        Action_Shopping_ManageBasket.clickOderButton(driver);
        // actual = name product on Checkout popup
        String actual = Page_Shopping_Checkout.txt_CheckoutPopup_NameProduct(product);
        try {
            assertEquals("List of selected products are incorrect", expected, actual);
            System.out.println("There selected products display on Checkout popup!!!");
        } catch (AssertionError assertionError) {
            assertionError.printStackTrace();
        }
    }
}