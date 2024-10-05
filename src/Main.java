import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sizeArr = 8;
        int productCount = 0;
        String[] shoppingList = new String[sizeArr];
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("Выберите одну из команд:");
            System.out.println("1. Добавить товар в список");
            System.out.println("2. Показать список");
            System.out.println("3. Очистить список");
            System.out.println("4. Завершить работу");

            int actionNumber = scanner.nextInt();

            switch (actionNumber) {
                case 1:
                    String newProduct;
                    if (productCount >= sizeArr) {
                        sizeArr++;
                        String[] tempArr = new String[sizeArr];
                        System.arraycopy(shoppingList, 0, tempArr, 0, sizeArr - 1);
                        shoppingList = tempArr;
                    }

                    System.out.println("Введите название нового товара");
                    scanner.nextLine();
                    newProduct = scanner.nextLine().replace(" ", "_");
                    boolean serchForDuplicates = true;
                    for (int j = 0; j < sizeArr; j++) {
                        if (newProduct.equalsIgnoreCase(shoppingList[j])) {
                            serchForDuplicates = false;
                            break;
                        }
                    }
                    if (serchForDuplicates) {
                        shoppingList[productCount] = newProduct;
                        System.out.println("Товар " + newProduct + " успешно добавлен под номером " + (productCount + 1));
                        productCount++;
                        break;
                    } else {
                        System.out.println("Такой товар уже существует");
                    }
                    break;
                case 2:
                    if (productCount > 0) {
                        for (int i = 0; i < productCount; i++) {
                            System.out.println(i + 1 + "." + shoppingList[i]);
                        }
                    } else {
                        System.out.println("Список покупок пуст");
                    }
                    break;
                case 3:
                    Arrays.fill(shoppingList, null);
                    productCount = 0;
                    System.out.println("Список покупок пуст");
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Неизвестная команда!");
            }
        }
    }
}