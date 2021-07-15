import java.util.Scanner;

public class testCoinSorter {



	public static void main(String[] args) {
        // new scanner object to accept inputs
        Scanner keyboard = new Scanner(System.in);

        // initialise new variable to use for the scanner input parameters methods;

        int coinExchange, coinType, excludedCoin, totalCoinVal, minCoin, maxCoin;
        char choice, submenu;
        // Original list of coins in array
        int[] coinList2 = { 200, 100, 50, 20, 10
        };

        // Initialising coin sorter 

        CoinSorter c = new CoinSorter("USD", 0, 10000, coinList2);

        do {

            // Start the textual menu

            System.out.println(" ");
            System.out.println("***Coin Sorter - Main Menu***");
            System.out.println("1 - Coin calculator");
            System.out.println("2 - Multiple coin calculator");
            System.out.println("3 - Print coin list");
            System.out.println("4 - Set details");
            System.out.println("5 - Display program configurations");
            System.out.println("6 - Quit the program");
            System.out.println("Enter choice [1-6]:");

            // Enter menu choice via keyboard 

            choice = keyboard.next().charAt(0);
            System.out.println(" ");


            switch (choice) {
                // Enter total coin count and which coin type to exchange it into 
                case '1':
                    System.out.print("Enter the total amount (must be between " + c.minCoin + " and " + c.maxCoin + "): ");
                    coinExchange = keyboard.nextInt();
                    System.out.print("Enter the coin you want to exchange it to: ");
                    coinType = keyboard.nextInt();
                    c.coinCalculator(coinExchange, coinType);
                    break;
                    // Input coin amount and coin types to exclude and count how much per coin types.
                case '2':
                    System.out.print("Enter the total coin amount: ");
                    totalCoinVal = keyboard.nextInt();
                    System.out.print("Enter the coin you want to exclude from the count: ");
                    excludedCoin = keyboard.nextInt();
                    c.multiCoinCalculator(totalCoinVal, excludedCoin);
                    break;

                    // Prints a list of coin types 
                case '3':
                    c.printCoinList();
                    break;
                case '4':
                    // Start the sub menu to edit values
                    System.out.println(" ");
                    System.out.println("***Set Details Sub-Menu***");
                    System.out.println("1 - Set currency");
                    System.out.println("2 - Set minimum coin input value");
                    System.out.println("3 - Set maximum coin input value");
                    System.out.println("4 - Return to main menu");
                    submenu = keyboard.next().charAt(0);
                    System.out.println(" ");

                    switch (submenu) {
                        case '1':
                            System.out.println("Set currency to: ");
                            String currency2 = keyboard.nextLine();
                            currency2 = keyboard.nextLine();
                            c.setCurrency(currency2);
                            break;
                        case '2':
                            System.out.println("Set minimum coin input value to: ");
                            minCoin = keyboard.nextInt();
                            c.setMinCoinIn(minCoin);
                            break;
                        case '3':
                            System.out.println("Set maximum coin input value to: ");
                            maxCoin = keyboard.nextInt();
                            c.setMaxCoinIn(maxCoin);
                            break;
                        case '4':
                            break;
                    }
                    break;
                case '5':
                    c.displayProgramConfigs();
                    break;


            }


        }
        while (choice != '6');
        System.out.println("Goodbye");
        keyboard.close();


    }
    

}