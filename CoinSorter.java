/*

Coin Sorting Program

*/

import java.util.Scanner;
import java.util.Arrays;

public class CoinSorter {

    // Currency in GDP: Pound Sterling (£)
    public String currency = "GDP"; 
    Scanner keyboard = new Scanner(System.in); // Create a Scanner object


    // These instance variables are visible for any child class
    public int minCoin = 0, maxCoin = 10000, totalCoinValue = 0, excludedCoin = 0, coinType = 0;

    // Original array of all the coin denominations in the form of pennies 
    int[] coinList = {
        200,
        100,
        50,
        20,
        10
    };

    // The Constructor 
    public CoinSorter(String currencyIn, int minValIn, int maxValIn, int coinListIn[]) {
        // Update all the instance variables to the new values 
        this.currency = currencyIn;
        this.minCoin = minValIn;
        this.maxCoin = maxValIn;
        this.coinList = coinListIn;

    }

    // These "set" methods should set corresponding attributes

    // Set currency and print new currency in terminal
    public void setCurrency(String currencyIn) {
        this.currency = currencyIn;
        System.out.println("You set the curency to: " + currency);

    }

    // Set new minimum coin value and print  in terminal
    public void setMinCoinIn(int minCoinIn) {
        this.minCoin = minCoinIn;
        System.out.println("You set the minimum coin input value to: " + minCoinIn);
    }

    // Set new maximum coin value and print  in terminal
    public void setMaxCoinIn(int maxCoinIn) {
        this.maxCoin = maxCoinIn;
        System.out.println("You set the maximum coin input value to: " + this.maxCoin);
    }

    // These “get” methods should return the corresponding attribute values. 

    // Get current currency
    public String getCurrency() {
        System.out.println(currency);
        return currency;
    }

    // Get the minimum coin value
    public int getMinCoinIn() {
        System.out.println(minCoin);
        return minCoin;
    }

    // Get the maximum coin value
    public int getMaxCoinIn() {
        System.out.println(this.maxCoin);
        return this.maxCoin;
    }

    // Print out all the available coin denominations
    public void printCoinList() {

        System.out.println("The current coin denominations are in circulation: \n" + Arrays.toString(coinList).replace("[", "").replace("]", ""));

    }

    // Validates total coin input is between expected range
    public void validateTotalCoinValue() {
    	
        // Checks if total coin value either/or outside the min and max coin values
        while (this.totalCoinValue < this.minCoin || this.totalCoinValue > this.maxCoin) {
            // If not prompts for a new one then updates variable
            System.out.println("You entered " + this.totalCoinValue + " which isn't an allowed value.\nPlease re-enter a total coin value between " + minCoin + " and " + maxCoin);
            this.totalCoinValue = keyboard.nextInt(); // Read user input		
        }



    }

    // Check if the chosen coin denomination to include is in the array

    public void validateExcludedCoin() {

        boolean coinFound = false;

        // Keep looping through until coin is found OR new coin entered is in coin list
        while (coinFound == false) {

            // Go through array to check chosen excluded coin type is in the list
            for (int i = 0; i < coinList.length; i++) {

                // If chosen coin is same as value from array change coinFound boolean to true
                if (this.excludedCoin == coinList[i]) {
                    coinFound = true;
                }

            }

            // If chosen coin is not found in the array prompt for new coin value
            if (coinFound == false) {
                System.out.println(this.excludedCoin + "p isn't a valid denominator.\nPlease choose a new denominator from the following: " + Arrays.toString(coinList).replace("[", "").replace("]", ""));
                this.excludedCoin = keyboard.nextInt(); // Read user input	= newCoin;
                System.out.println("Your chosen coin denomator is " + this.excludedCoin + "p");
            }

        }
    }



    // Calculates max no. of coins the input coin type can be exchanged for with a remainder
    public void coinCalculator(int coinExchangeIn, int coinTypeIn) {

        // Updates the total coin value and the coin type 
        this.excludedCoin = coinTypeIn;
        this.totalCoinValue = coinExchangeIn;

        // Validates whether the total coin value is between the min and max values
        validateTotalCoinValue();

        // Validates whether the coin type is valid 
        validateExcludedCoin();

        // Finds the remainder 
        int remainder = totalCoinValue % excludedCoin;
        // Converts remainder into a string
        String coinRemainder = Integer.toString(remainder);
        // Append p char to string so it is e.g 20p instead of 20
        coinRemainder += "p";
        int coinAmount = this.totalCoinValue / this.excludedCoin;
        System.out.println("A total of " + coinAmount + " x " + this.excludedCoin + "p coins can be exchanged, with a remainder of " + coinRemainder);
    }

    public void multiCoinCalculator(int totalCoinValIn, int excludedCoinIn) {

        // Initialise variables
        this.excludedCoin = excludedCoinIn;
        this.totalCoinValue = totalCoinValIn;

        // Validate total coin value between min and max
        validateTotalCoinValue();
        
        // Validate coin type inputted is within the coin list
        validateExcludedCoin();

        int change = totalCoinValIn;
        
        System.out.println("The coins exchanged are ");

        // Iterate through all of coin list 
        for (int i = 0; i < coinList.length; i++) {

        	// Checks if the coin type is the excluded one
            if (this.excludedCoin != coinList[i]) {
            	// If it isn't excluded then divide the total coin value by each coin type 
                int tempCoin = Math.round((int) change / coinList[i]);
                // Keep modulo-ing it and using the remainder to divide the next coin type in array
                change %= coinList[i];
                // Print the number of times total coin value breaks up into each coin types in order
                System.out.println(tempCoin + " x " + coinList[i] + "p");
            }

        }
        // Print the remainder out in terminal
        System.out.println("with a remainder of " + change + "p");

    }
    
    // Print current currency, min and max coin values
    public String displayProgramConfigs() {
        System.out.println("Currency: " + currency + "\nMinimum coin value: " + minCoin + "\nMaximum coin value: " + maxCoin);
        return currency + minCoin + maxCoin;

    }

}