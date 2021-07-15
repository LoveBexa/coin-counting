public class testCoinSorterGUI {

    private static int[] coinList = {
        200,
        100,
        50,
        20,
        10
    };

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CoinSorterGUI c = new CoinSorterGUI("USD", 0, 1000, coinList);
        c.runMenu();
    }

}