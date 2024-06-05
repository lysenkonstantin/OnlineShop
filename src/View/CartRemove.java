package View;

import Common.AppView;
import Data.models.CartItem;
import Data.models.Product;
import Data.services.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

public class CartRemove extends AppView {
    public CartRemove(ShopService shopService) {
        super("Очистить корзину", new ArrayList<AppView>());
        this.shopService = shopService;
    }

    final ShopService shopService;

    @Override
    public void action() {
        ArrayList<CartItem> cart = shopService.getCart();
        cart.removeAll(cart);
        System.out.println("Все товары из корзины удалены!");

    }
}
