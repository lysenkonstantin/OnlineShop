package View;

import Common.AppView;
import Data.models.Product;
import Data.services.ShopService;

import java.util.ArrayList;

public class CatalogView extends AppView {
    public CatalogView(ShopService shopService, ArrayList<AppView> children) {
        super("Раздел \"Каталог\"", children);
        this.shopService = shopService;
    }

    final ShopService shopService;

    @Override
    public void action() {
        ArrayList<Product> catalog = shopService.getCatalog();
        System.out.println("Список товаров: ");
        for (Product product : catalog) {
            System.out.println("Id товара: " + product.id + ", " + "Наименование товара: " + product.title +
                    ", " + "Цена товара: " + product.price);
        }
        System.out.println();
    }
}
