package pos.machine;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        ItemDataLoader allItemsInfos = new ItemDataLoader();
        List<ItemInfo> allItemInfo = allItemsInfos.getAllItemsInfo();
        System.out.println(allItemInfo);


    }
}
