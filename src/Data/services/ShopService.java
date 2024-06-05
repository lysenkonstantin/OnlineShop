package Data.services;

import Data.data_source.cart.CartDataSource;
import Data.data_source.catalog.CatalogDataSource;
import Data.data_source.order.OrderDataSource;
import Data.models.CartItem;
import Data.models.Order;
import Data.models.Product;

import java.util.ArrayList;

public class ShopService {
    final CatalogDataSource catalogDataSource;
    final CartDataSource cartDataSource;
    final OrderDataSource orderDataSource;

    public ShopService(CatalogDataSource catalogDataSource, CartDataSource cartDataSource, OrderDataSource orderDataSource) {
        this.catalogDataSource = catalogDataSource;
        this.cartDataSource = cartDataSource;
        this.orderDataSource = orderDataSource;
    }

    public ArrayList<Product> getCatalog() {
        return catalogDataSource.getCatalog();
    }

    public boolean addToCart(String productId, int count) {
        ArrayList<Product> products = getCatalog();
        for (Product p : products) {
            if (p.id.equals(productId)) {
                cartDataSource.addToCart(p, count);
                return true;
            }
        }
        return false;
    }

    public ArrayList<CartItem> getCart() {
        ArrayList<CartItem> cart = cartDataSource.getCart();
        int totalSum = 0;
        System.out.println("Список выбранных товаров: ");
        for (CartItem cartItem : cart) {
            System.out.println("Id товара: " + cartItem.product.id + ", Наименование товара: " + cartItem.product.title + ", Количество товара: "
                    + cartItem.count + ", Стоимость: " + cartItem.sum + " рублей");
            totalSum += cartItem.sum;
        }
        System.out.println("Общая стоимость всех товаров в заказе: " + totalSum + " рублей");
        return cart;
    }

    public void createOrder(String name, String phone, String address, String paymentType, String deliveryTime) {
        ArrayList<CartItem> cart = getCart();
        Order newOrder = new Order(name, phone, address, paymentType, deliveryTime, cart);
        orderDataSource.createOrder(newOrder);
    }
}
