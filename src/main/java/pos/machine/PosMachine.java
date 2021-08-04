package pos.machine;

import java.util.ArrayList;
import java.util.List;

public class PosMachine {
    public String printReceipt(List<String> barcodes) {
        String myReceipt = generateReceipt(receipt);
        List<Item> boughtItems = convertToItems(barcodes);
        Receipt receipt = computerReceipt(boughtItems);
    }

    private List<Item> convertToItems(List<String> barcodes) {
        List<ItemInfo> itemsInfo = getAllItemsInfo();
        List<Item> boughtItems = new ArrayList<>();


    }

    private Receipt computerReceipt(List<Item> boughtItems) {
        return null;
    }

    public static List<ItemInfo> getAllItemsInfo() {
        return ItemDataLoader.loadAllItemInfos();
    }

    public String generateReceipt(Receipt receipt){

    }
}
