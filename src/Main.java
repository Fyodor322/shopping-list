import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int sizeArr = 8;
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
                    int productCount = 0;
                    for (int i = 0; i < sizeArr; i++) {
                        if (productCount < 8 && shoppingList[i] == null){
                            System.out.println("Введите название нового товара");
                            scanner.nextLine();
                            newProduct = scanner.nextLine().replace(" ", "_");
                            shoppingList[i] = newProduct;
                            productCount++;
                            break;
                        }else if(productCount == 8){
                            System.out.println("К сожалению, мест в списке не осталось(");
                        }
                    }
                    break;
                case 2:
                case 3:
                case 4:
                default:
                    System.out.println("Неизвестная команда!");
                    break;
            }
        }
    }
}