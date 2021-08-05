package pos.machine;

public class Item {

    private String name;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private int itemsSubTotal;

    public Item(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }

    public int getItemsSubTotal() {
        return itemsSubTotal;
    }

    public void setItemsSubTotal(int itemsSubTotal) {
        this.itemsSubTotal = itemsSubTotal;
    }

    public String getName() {
        return name;
    }
}
