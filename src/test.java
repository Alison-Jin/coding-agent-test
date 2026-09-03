public class test {
    public static void main(String[] args) {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.addItem("Milk");
        shoppingList.addItem("Bread");
        shoppingList.updateItem(1, "Eggs");

        if (!shoppingList.getItems().toString().equals("[Milk, Eggs]")) {
            throw new AssertionError("Items should be created and updated.");
        }
    }
}
