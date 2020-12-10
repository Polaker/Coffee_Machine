package machine;
import java.util.*;
public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("The coffee machine has:\n");
        // Utworzenie zmiennych typu int do przechowywania wartosci ile czego ma maszyna
        int howManyMlWater = 400;
        int howManyMlMilk = 540;
        int howManyGrams = 120;
        int howManyCups = 9;
        int money = 550;
        // Utworzenie zmiennych odnoszacych sie do kazdej kawy
        int waterEspresso = 250,beansEspresso = 16, costEspresso = 4, cupEspresso=1;
        int waterLatte = 350,beansLatte = 20, milkLatte = 75, costLatte = 7, cupLatte=1;
        int waterCappuccino = 200,beansCappuccino = 12, milkCappuccino = 100, costCappuccino = 6, cupCappuccino = 1;
        boolean isActive = true;
        while(isActive){


            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            String option = scanner.nextLine(); // String pobierajacy odpowiedz na powyzsze pytanie
            switch (option){
                case "buy": // W przypadku gdy klient chce kupic kawe
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String optionOfCaffe = scanner.next();
                    switch (optionOfCaffe){
                        case "1": // W przypadku gdy ktos chce espresso
                            if (howManyMlWater >= waterEspresso && howManyGrams >= beansEspresso && howManyCups >= cupEspresso) {
                                System.out.println("I have enough resources, making you a coffee!");
                                howManyMlWater -= waterEspresso;
                                howManyGrams -= beansEspresso;
                                howManyCups -= 1;
                                money += costEspresso;
                                break;
                            } else {
                                System.out.println("Sorry, not enough water!");
                                break;
                            }
                        case "2": // W przypadku gdy ktos latte
                            if (howManyMlWater >= waterCappuccino && howManyMlMilk >= milkLatte && howManyGrams >= beansLatte && howManyCups >= cupLatte) {

                                howManyMlWater -= waterLatte;
                                howManyGrams -= beansLatte;
                                howManyMlMilk -= milkLatte;
                                howManyCups -= 1;
                                money += costLatte;
                                break;
                            } else {
                                System.out.println("Sorry, not enough water!");
                                break;
                            }
                        case "3": // W przypadku gdy ktos chce cappuccino
                            if (howManyMlWater >= waterCappuccino && howManyGrams >= beansCappuccino && howManyMlMilk >= milkCappuccino && howManyCups >= cupCappuccino) {

                                howManyMlWater -= waterCappuccino;
                                howManyGrams -= beansCappuccino;
                                howManyMlMilk -= milkCappuccino;
                                howManyCups -= 1;
                                money += costCappuccino;
                                break;
                            } else {
                                System.out.println("Sorry, not enough water!");
                                break;
                            }
                        case "back":
                            break;
                    }
                    break;
                case "fill":
                    int waterToAdd,milkToAdd,beansToAdd,cupsToAdd;
                    System.out.println("Write how many ml of water do you want to add:");
                    waterToAdd = scanner.nextInt();
                    howManyMlWater += waterToAdd;
                    System.out.println("Write how many ml of milk do you want to add:");
                    milkToAdd = scanner.nextInt();
                    howManyMlMilk += milkToAdd;
                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    beansToAdd = scanner.nextInt();
                    howManyGrams += beansToAdd;
                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    cupsToAdd = scanner.nextInt();
                    howManyCups += cupsToAdd;
                    break;
                case "take" :
                    System.out.println("I gave you $" + money);
                    money -= money;
                    break;
                case "remaining" :
                    System.out.println(howManyMlWater + " of water");
                    System.out.println(howManyMlMilk + " of milk");
                    System.out.println(howManyGrams + " of coffee beans");
                    System.out.println(howManyCups + " of disposable cups");
                    System.out.println(money + " of money");
                    break;
                case "exit" :
                    isActive = false;
                    break;
            }

        }

    }
}
