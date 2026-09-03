import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<String> createShoppingList(String[] items) {
        List<String> shoppingList = new ArrayList<>();
        if (items == null) {
            return shoppingList;
        }

        for (String item : items) {
            if (item != null) {
                String trimmed = item.trim();
                if (!trimmed.isEmpty()) {
                    shoppingList.add(trimmed);
                }
            }
        }
        return shoppingList;
    }

    public static boolean updateShoppingList(List<String> shoppingList, String currentItem, String updatedItem) {
        if (shoppingList == null || currentItem == null || updatedItem == null) {
            return false;
        }

        String current = currentItem.trim();
        String updated = updatedItem.trim();
        if (current.isEmpty() || updated.isEmpty()) {
            return false;
        }

        int index = shoppingList.indexOf(current);
        if (index == -1) {
            return false;
        }

        shoppingList.set(index, updated);
        return true;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage:");
            System.out.println("  java Main create <item1> <item2> ...");
            System.out.println("  java Main update <currentItem> <updatedItem> <item1> <item2> ...");
            return;
        }

        String action = args[0];
        if ("create".equalsIgnoreCase(action)) {
            String[] items = new String[args.length - 1];
            System.arraycopy(args, 1, items, 0, items.length);
            List<String> shoppingList = createShoppingList(items);
            System.out.println("Shopping list: " + shoppingList);
            return;
        }

        if ("update".equalsIgnoreCase(action)) {
            if (args.length < 4) {
                System.out.println("Usage: java Main update <currentItem> <updatedItem> <item1> <item2> ...");
                return;
            }

            String currentItem = args[1];
            String updatedItem = args[2];
            String[] items = new String[args.length - 3];
            System.arraycopy(args, 3, items, 0, items.length);

            List<String> shoppingList = createShoppingList(items);
            boolean updated = updateShoppingList(shoppingList, currentItem, updatedItem);
            if (updated) {
                System.out.println("Updated shopping list: " + shoppingList);
            } else {
                System.out.println("Item not found. Shopping list: " + shoppingList);
            }
            return;
        }

        System.out.println("Unknown action: " + action);
    }
}