package View;

import Common.AppView;
import Data.models.CartItem;
import Data.models.Product;
import Data.services.ShopService;

import java.util.ArrayList;

public class CartView extends AppView {

    final ShopService shopService;

    public CartView(ShopService shopService, ArrayList<AppView> children) {
        super("Раздел \"Корзина\"", children);
        this.shopService = shopService;
    }

    @Override
    public void action() {
        shopService.getCart();
    }
}
