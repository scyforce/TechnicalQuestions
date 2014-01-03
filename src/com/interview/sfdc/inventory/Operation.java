package com.interview.sfdc.inventory;

public interface Operation {
   void newItem(Inventory inventory, String itemName, double buyingPrice, double sellingPrice);
   void deleteItem(Inventory inventory, String itemName);
   void buyItem(Inventory inventory, String itemName, int stock);
   void sellItem(Inventory inventory, String itemName, int stock);
   String report(Inventory inventory);
}
