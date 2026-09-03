import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingList {
    private final List<String> items = new ArrayList<>();

    public void addItem(String item) {
        items.add(requireItem(item));
    }

    public void updateItem(int index, String item) {
        items.set(index, requireItem(item));
    }

    public List<String> getItems() {
        return Collections.unmodifiableList(items);
    }

    private String requireItem(String item) {
        if (item == null || item.trim().isEmpty()) {
            throw new IllegalArgumentException("Shopping list items cannot be blank.");
        }
        return item.trim();
    }
}
