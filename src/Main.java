import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        boolean done = false;

        do{
            displayList(list);
            String choice = SafeInput.getRegExString(in, "Choose [A]Add, [D]Delete, [I]Insert, [P]Print, [Q]Quit","[AaDdIiPpQq]").toUpperCase();

            switch (choice) {
                case "A" -> addItem(list, in);
                case "D" -> deleteItem(list, in);
                case "I" -> insertItem(list, in);
                case "P" -> displayList(list);
                case "Q" -> {
                    if (SafeInput.getYNConfirm(in, "Are you sure you want to quit?")) {
                        done = true;
                    }
                }
            }

        }while(!done);
        System.out.println("You Quit");
    }
    private static void addItem(ArrayList<String> list, Scanner in){
        String item = SafeInput.getNonZeroLenString(in, "Enter item to add");
        list.add(item);
    }
    private static void deleteItem(ArrayList<String> list, Scanner in) {
        if (list.isEmpty()) {
            System.out.println("List is empty, nothing to delete.");
            return;
        }
        displayNumberedList(list);
        int index = SafeInput.getRangedInt(in, "Enter index to delete", 1, list.size()) - 1;
        list.remove(index);
    }
    private static void insertItem(ArrayList<String> list, Scanner in) {
        String item = SafeInput.getNonZeroLenString(in, "Enter item to insert");

        int position = SafeInput.getRangedInt(in,
                "Enter position to insert at", 1, list.size() + 1) - 1;

        list.add(position, item);
    }
    private static void displayList(ArrayList<String> list) {
        System.out.println("\nCurrent List:");
        for (String item : list) {
            System.out.println("- " + item);
        }
        System.out.println();
    }
    private static void displayNumberedList(ArrayList<String> list) {
        System.out.println("\nNumbered List:");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d: %s\n", i + 1, list.get(i));
        }
        System.out.println();
    }
}

