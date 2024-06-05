package Data.data_source.cart;

import Data.models.CartItem;
import Data.models.Product;

import java.util.ArrayList;

public abstract class CartDataSource {

    public abstract void addToCart(Product product, int count);

    public abstract ArrayList<CartItem> getCart();
}
