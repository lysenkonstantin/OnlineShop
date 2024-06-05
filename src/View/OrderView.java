package View;

import Common.AppView;
import Data.models.CartItem;
import Data.models.Product;
import Data.services.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderView extends AppView {
    public OrderView(ShopService shopService) {
        super("Раздел \"Оформление заказа\"", new ArrayList<AppView>());
        this.shopService = shopService;
    }

    final ShopService shopService;

    @Override
    public void action() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите свое имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите свой телефон: ");
        String phone = scanner.nextLine();
        System.out.println("Введите свой адрес: ");
        String adress = scanner.nextLine();
        System.out.println("Введите тип оплаты (наличные или карта): ");
        String paymentType = scanner.nextLine();
        System.out.println("Введите время доставки: ");
        String deliveryTime = scanner.nextLine();
        shopService.createOrder(name, phone, adress, paymentType, deliveryTime);
        System.out.println("Заказ на имя " + name + ", телефон: " + phone + ", по адресу: " +
                adress + ", с типом оплаты: " + paymentType + ", и доставкой: " + deliveryTime + " сформирован!");
    }
}
