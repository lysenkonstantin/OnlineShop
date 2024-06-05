package Data.models;

public class CartItem {

    public final Product product;
    public final int count;
    public final int sum;

    public CartItem(Product product, int count) {
        this.product = product;
        this.count = count;
        this.sum = count * this.product.price;
    }
}
