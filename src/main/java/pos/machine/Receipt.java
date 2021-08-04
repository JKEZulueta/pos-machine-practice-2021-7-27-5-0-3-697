package pos.machine;

import java.util.List;

public class Receipt {
    private List<Item> itemDetails;
    private int totalPrice;

    public Receipt(List<Item> itemDetails, int totalPrice) {
        this.itemDetails = itemDetails;
        this.totalPrice = totalPrice;
    }

    public List<Item> getItemDetails() {
        return itemDetails;
        //gets the Item details in itemDetails
    }

    public void setItemDetails(List<Item> itemDetails) {
        this.itemDetails = itemDetails;
        //sets item details to list ItemDetails
    }

    public int getTotalPrice() {
        return totalPrice;
        //gets the total price
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
        //sets the total price
    }
}
