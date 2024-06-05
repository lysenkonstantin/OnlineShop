package View;

import Common.AppView;
import Data.services.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

public class AddToCartView extends AppView {
    public AddToCartView(ShopService shopService) {
        super("Раздел \"Добавить товар\"", new ArrayList<AppView>());
        this.shopService = shopService;
    }

    final ShopService shopService;

    @Override
    public void action() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите id продукта: ");
            String productId = scanner.nextLine();
            System.out.println("Введите количество продукта: ");
            int count = 0;
            try {
                count = scanner.nextInt();
            } catch (RuntimeException e) {
                System.out.println("Не удалось добавить товар. Попробуйте снова!");
                continue;
            }
            final boolean res = shopService.addToCart(productId, count);
            if (res) {
                System.out.println("Товар c " + productId + " добавлен");
                break;
            } else {
                System.out.println("Не удалось добавить товар. Попробуйте снова!");
                continue;
            }
        }
    }
}
