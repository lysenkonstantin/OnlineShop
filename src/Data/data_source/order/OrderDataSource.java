package Data.data_source.order;

import Data.models.CartItem;
import Data.models.Order;
import Data.models.Product;

import java.util.ArrayList;

public abstract class OrderDataSource {

    public abstract void createOrder(Order order);

    public abstract Order getOrder();

}
