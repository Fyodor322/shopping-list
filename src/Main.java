import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int sizeArr = 8;
        int productCount = 0;
        String[] shoppingList = new String[sizeArr];
        Scanner scanner = new Scanner(System.in);


        while (true){
            System.out.println("Выберите одну из команд:");
            System.out.println("1. Добавить товар в список");
            System.out.println("2. Показать список");
            System.out.println("3. Очистить список");
            System.out.println("4. Завершить работу");

            int actionNumber = scanner.nextInt();

            switch (actionNumber){
                case 1:
                    String newProduct;
                    for (int i = 0; i < sizeArr; i++) {
                        if (productCount >= sizeArr) {
                            sizeArr++;
                            String[] tempArr = new String[sizeArr];
                            System.arraycopy(shoppingList, 0, tempArr, 0, sizeArr - 1);
                        }
                        if (shoppingList[i] == null){
                            System.out.println("Введите название нового товара");
                            scanner.nextLine();
                            newProduct = scanner.nextLine().replace(" ", "_");
                            boolean serchForDuplicates = true;
                            for (int j = 0; j < sizeArr; j++) {
                                if (newProduct.equals(shoppingList[j])) {
                                    serchForDuplicates = false;
                                }
                            }
                            if (serchForDuplicates) {
                                shoppingList[i] = newProduct;
                                System.out.println("Товар " + newProduct + " успешно добавлен под номером " + (i + 1));
                                productCount++;
                                break;
                            } else {
                                System.out.println("Такой товар уже существует под номером " + (i + 1));
                            }
                            break;
                        }
                    }
                    break;
                case 2:
                    if (productCount > 0){
                        for (int i = 0; i < productCount; i++) {
                            if (shoppingList[i] != null)
                                System.out.println(i+1 + "." + shoppingList[i]);
                        }
                    }else {
                        System.out.println("Список покупок пуст");
                    }

                    break;
                case 3:
                    for (int i = 0; i < productCount; i++) {
                        shoppingList[i] = null;
                    }
                    productCount = 0;
                    System.out.println("Список покупок пуст");
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Неизвестная команда!");
            }
        }
    }
}