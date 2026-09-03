public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            printUsage();
            return;
        }

        ShoppingList shoppingList = new ShoppingList();
        int position = 0;
        boolean listPrinted = false;
        try {
            while (position < args.length) {
                String command = args[position++];
                if ("create".equals(command) || "add".equals(command)) {
                    if (position == args.length) {
                        throw new IllegalArgumentException(command + " requires an item.");
                    }
                    shoppingList.addItem(args[position++]);
                    listPrinted = false;
                } else if ("update".equals(command)) {
                    if (position + 1 >= args.length) {
                        throw new IllegalArgumentException("update requires an item number and a new item.");
                    }
                    int itemNumber = Integer.parseInt(args[position++]);
                    shoppingList.updateItem(itemNumber - 1, args[position++]);
                    listPrinted = false;
                } else if ("list".equals(command)) {
                    printList(shoppingList);
                    listPrinted = true;
                } else {
                    throw new IllegalArgumentException("Unknown command: " + command);
                }
            }
            if (!listPrinted) {
                printList(shoppingList);
            }
        } catch (IllegalArgumentException | IndexOutOfBoundsException exception) {
            System.out.println("Error: " + exception.getMessage());
            printUsage();
        }
    }

    private static void printList(ShoppingList shoppingList) {
        System.out.println("🛒 Shopping List:");
        for (int i = 0; i < shoppingList.getItems().size(); i++) {
            System.out.println("✅ " + (i + 1) + ". " + shoppingList.getItems().get(i));
        }
    }

    private static void printUsage() {
        System.out.println("Usage: java Main create <item> [add <item>] [update <number> <item>] [list]");
    }
}