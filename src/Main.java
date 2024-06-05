import Common.AppView;
import Common.PageLoop;
import Data.data_source.cart.CartDataSource;
import Data.data_source.cart.MockCartDataSourceImpl;
import Data.data_source.catalog.CatalogDataSource;
import Data.data_source.catalog.MockCatalogDataSource;
import Data.data_source.order.MockOrderDataSourceImpl;
import Data.data_source.order.OrderDataSource;
import Data.services.ShopService;
import View.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CartDataSource cartDataSource = new MockCartDataSourceImpl();
        CatalogDataSource catalogDataSource = new MockCatalogDataSource();
        OrderDataSource orderDataSource = new MockOrderDataSourceImpl();
        ShopService shopService = new ShopService(catalogDataSource, cartDataSource, orderDataSource);

        AppView addToCartView = new AddToCartView(shopService);
        ArrayList<AppView> catalogChildren = new ArrayList<>();
        catalogChildren.add(addToCartView);
        AppView catalogView = new CatalogView(shopService, catalogChildren);

        AppView cartRemove = new CartRemove(shopService);
        ArrayList<AppView> catalogCartChildren = new ArrayList<>();
        catalogCartChildren.add(cartRemove);
        AppView cartView = new CartView(shopService, catalogCartChildren);

        AppView orderView = new OrderView(shopService);

        ArrayList<AppView> mainChildren = new ArrayList<>();
        mainChildren.add(catalogView);
        mainChildren.add(cartView);
        mainChildren.add(orderView);
        AppView mainView = new MainView(mainChildren);

        new PageLoop(mainView).run();
    }
}
