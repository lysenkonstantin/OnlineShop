package Common;

import java.util.Scanner;

public class PageLoop {
    final AppView view;

    public PageLoop(AppView view) {
        this.view = view;
    }

    public void run() {
        while (true) {
            dislplayChildrens();
            Scanner scanner = new Scanner(System.in);
            int value = scanner.nextInt();
            if (value < 0 || value > view.children.size() + 1) {
                System.out.println("Неверное значение страницы");
            } else if (value == view.children.size() + 1) {
                System.out.println("Вы завершили работу с \"" + view.title);
                break;
            } else {
                AppView selectedView = view.children.get(value - 1);
                new PageLoop(selectedView).run();
            }
        }
    }

    void dislplayChildrens() {
        System.out.println(view.title);
        view.action();
        System.out.println("Выберете вариант (от 1 до " + (view.children.size() + 1) + "): ");
        for (int i = 0; i < view.children.size(); i++) {
            AppView _view = view.children.get(i);
            System.out.println((i + 1) + " - " + _view.title);
        }
        System.out.println((view.children.size() + 1) + " - Назад");
    }
}
