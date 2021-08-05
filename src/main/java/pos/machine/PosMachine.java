package pos.machine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PosMachine {
    public String printReceipt(List<String> barcodes) {
        List<Item> boughtItems = convertToItems(barcodes);
        Receipt receipt = calculateReceipt(boughtItems);

        return renderReceipt(receipt);
    }

    private List<Item> convertToItems(List<String> barcodes) {
        List<ItemInfo> itemsInfo = getAllItemsInfo();
        List<Item> boughtItems = new ArrayList<>();
        //create a for loop like in activity stream distinct
        for(ItemInfo item : itemsInfo){
            for (String barcode : barcodes //barcode = variable barcodes = the inputs
                    .stream() //java stream
                    .distinct() //distincts the same barcodes
                    .collect(Collectors.toList())){

                if(item.getBarcode().equals(barcode)){
                    Item defItem = new Item(item.getName(),item.getPrice(), Collections.frequency(barcodes, barcode));
                    boughtItems.add(defItem);
                }
            }
        } return boughtItems;
    }

    public List<Item> calculateItemsSubtotal(List<Item> boughItems){
        for(Item item : boughItems){
            item.setItemsSubTotal(item.getQuantity() * item.getPrice());
        }
        return boughItems;
    }

    public Receipt calculateTotalPrice(List<Item> boughtItemsWithSub){
        int totalPrice = 0;
        for(Item item : boughtItemsWithSub) { //item as variable, boughtItems as input
            totalPrice = totalPrice + item.getItemsSubTotal(); //total price is equals to total price + itemsSubtotal
        }
        Receipt receipt = new Receipt(boughtItemsWithSub, totalPrice); //instace receipt add new Receipt via boughtItems(input) and totalPrice
        return receipt;
    }

    public Receipt calculateReceipt(List<Item> boughtItems){
            List<Item> boughItemsWithSub = calculateItemsSubtotal(boughtItems);

            return calculateTotalPrice(boughItemsWithSub);
    }

    public String spliceItemDetails (Receipt receipt){
        String itemDetails = "";
        for(Item item : receipt.getItemDetails()){
            itemDetails = itemDetails + String.format( "Name: %s, Quantity: %d, Unit price: %d (yuan), Subtotal: %d (yuan)\n",
                    item.getName(), item.getQuantity(), item.getPrice(), item.getItemsSubTotal());
        }

        return "***<store earning no money>Receipt***\n" + itemDetails;
    }


    public static List<ItemInfo> getAllItemsInfo() {
        return ItemDataLoader.loadAllItemInfos();
    }

    public String spliceReceipt(String itemDetails, Double totalPrice){
        return itemDetails + "----------------------\n" + String.format("Total: %d (yuan)\n**********************", totalPrice.intValue());
    }

    public String renderReceipt(Receipt receipt){
        String itemDetails = spliceItemDetails(receipt);
        double totalPrice = receipt.getTotalPrice();

        return spliceReceipt(itemDetails, totalPrice);
    }
}
