import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CoinSorterGUI extends CoinSorter {

    // Array of menu options to select from
    private String menuSelectList[] = {
        "Exit",
        "Display Configurations",
        "Set Details",
        "Print List",
        "Multi Calculator",
        "Coin Calculator"
    };

    // Drop down menu options
    public Object[] options = {
        "Currency",
        "Minimum coin input value",
        "Maximum coin input value"
    };

    // Initialise variables 

    String currencyIn;
    public int minValIn, maxValIn;
    public JFrame frame = new JFrame();


    // Constructor
    public CoinSorterGUI(String currencyIn, int minValIn, int maxValIn, int coinListIn[]) {

        super(currencyIn, minValIn, maxValIn, coinListIn);
        //		this.currencyIn = currencyIn;
        //		this.minValIn = minValIn;
        //		this.maxValIn = maxValIn;


    }

    // Start menu 
    public void runMenu() {

        int option = getChoice();

        // If option are not 6 then allow choice

        while (option != 6) {
            //Menu action depending on choice

            if (option == 5) // Coin Calcuator 
            {
                // Convert the array of the coin type list to display as a string in pop up
                String coinListed = Arrays.toString(super.coinList).replace("[", "").replace("]", "");

                // Create new JTextFields for total coin value & coin type to count in
                JTextField coinExchange = new JTextField();
                JTextField coinType = new JTextField();

                // Message + input fields to display 
                Object[] message = {
                    "Total Coin Count:",
                    coinExchange,
                    "Coin Type To Count In.\nPlease select from\n" + coinListed,
                    coinType
                };

                // jOption pane box 
                int option2 = JOptionPane.showConfirmDialog(frame, message, "Coin Calculator", JOptionPane.OK_CANCEL_OPTION);

                if (option2 == JOptionPane.OK_OPTION) {

                    // Collect JTextField inputs of coin count 
                    // Convert both integar string then into integar to send to coin calculation method
                    String coinExchangeString = coinExchange.getText();
                    int coinExchangeInt = Integer.parseInt(coinExchangeString);
                    String coinTypeString = coinType.getText();
                    int coinTypeInt = Integer.parseInt(coinTypeString);

                    // Sends converted variables into calculation method
                    super.coinCalculator(coinExchangeInt, coinTypeInt);
                }


            } else if (option == 4) // Multiple Coin calculator  
            {
                // Convert the array of the coin type list to display as a string in pop up
                String coinListed = Arrays.toString(super.coinList).replace("[", "").replace("]", "");

                // Create new JTextFields for total coin value & coin type to exclude 
                JTextField totalCoinCount = new JTextField();
                JTextField excludedCoin = new JTextField();

                // Message + input fields to display 
                Object[] message = {
                    "Total Coin Count:",
                    excludedCoin,
                    "Coin Type To Exclude.\nPlease select from\n" + coinListed,
                    totalCoinCount
                };

                // jOption pane box 
                int option2 = JOptionPane.showConfirmDialog(frame, message, "Multiple Coin Calculator", JOptionPane.OK_CANCEL_OPTION);
                if (option2 == JOptionPane.OK_OPTION) {

                    // Collect JTextField inputs of coin count 
                    // Convert both int string then into integars to send to coin cal method
                    String totalCoinCountString = totalCoinCount.getText();
                    int totalCoinCountInt = Integer.parseInt(totalCoinCountString);
                    String excludedCoinString = totalCoinCount.getText();
                    int excludedCoinInt = Integer.parseInt(excludedCoinString);

                    // Sends converted variables into calculation method
                    super.multiCoinCalculator(totalCoinCountInt, excludedCoinInt);
                }
            } else if (option == 3) // Prints a list of the coin denominator 
            {

                // Lists array of coin types. Removes the [ and ] in an array and adds , to style it.
                // Converts into string to display
                String coinTypeListed = Arrays.toString(super.coinList).replace("[", "").replace("]", "");

                int coinType = JOptionPane.showConfirmDialog(null, "List of coin denomations\n" + coinTypeListed, "Coin Types", JOptionPane.OK_CANCEL_OPTION);
                if (coinType == JOptionPane.OK_CANCEL_OPTION) {

                    System.out.println("Bye");
                }
            }

            // Sub menu to set configurations
            else if (option == 2) {
                frame.setAlwaysOnTop(true);

                // Passing frame as first parameter
                Object selectionObject = JOptionPane.showInputDialog(frame, "Select to set new...", "Configuration Settings", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                String selectionString = selectionObject.toString();

                // Set new currency 
                if (selectionString == options[0]) {
                    String setNewCurrency = JOptionPane.showInputDialog(null, "New currency", "Currency Settings", JOptionPane.PLAIN_MESSAGE);
                    super.setCurrency(setNewCurrency);
                }

                // Set new min value 
                if (selectionString == options[1]) {
                    String setMinValue = JOptionPane.showInputDialog(null, "New mininum coin value", "Minimum Coin Value", JOptionPane.PLAIN_MESSAGE);
                    super.setMinCoinIn(Integer.parseInt(setMinValue));
                }

                // Set new max coin value
                if (selectionString == options[2]) {
                    String setMaxValue = JOptionPane.showInputDialog(null, "New maximum coin value", "Maximum Coin Value", JOptionPane.PLAIN_MESSAGE);
                    super.setMaxCoinIn(Integer.parseInt(setMaxValue));
                }
            } else if (option == 1) { // Display Program Configurations!
                JOptionPane.showMessageDialog(frame,
                    "Current Program Configurations:\n" + super.displayProgramConfigs(),
                    "Program Configurations",
                    JOptionPane.PLAIN_MESSAGE);

            } else {
                // Ask to confirm exit of program YES | NO | CANCEL 
                int result = JOptionPane.showConfirmDialog(frame,
                    "Are you sure you want to exit the coin sorter program?",
                    "Exit Program", JOptionPane.YES_NO_CANCEL_OPTION);
                if (result == JOptionPane.YES_OPTION) System.exit(0);
            }
            //Prompt again

            option = getChoice();

        } //End while

    }



    // Gets the main menu list 
    public int getChoice() {
        // Shows options from array initalised
        int choice = JOptionPane.showOptionDialog(null, "Select from ..", "Coin Calculator",
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, menuSelectList, menuSelectList[0]);
        return choice;
    }


}