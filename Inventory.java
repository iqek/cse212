import java.util.ArrayList;
import java.util.ListIterator;

public class Inventory {

    //array list of items
    private ArrayList<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void displayAllItems() {
        if(items.isEmpty()){
            System.out.println("Inventory is empty");
            return;
        }
        for(Item item:items){
            item.displayItem();
        }
    }

    public int getTotalNumberOfItems() {
        return items.size();
    }

    public void calculateTotalWorth() {
        for(Item item:items){
            System.out.println("Total Worth of Item " + item.getItemName() + " : " + item.calculateTotalWorth());
        }
    }

    public void increasePrice(String type, double raisePercent, ArrayList<Order> orders) {
        ListIterator<Item> it = items.listIterator();
 
        while (it.hasNext()) {
            Item item = it.next();
 
            if (item.getItemType().equalsIgnoreCase(type)) {
                boolean alreadyOrdered = false;
                for (Order o : orders) {
                    if (o.getItem() == item) {
                        alreadyOrdered = true;
                        break;
                    }
                }
 
                if (!alreadyOrdered) {
                    item.setItemPrice(item.getItemPrice() * (1 + raisePercent / 100));
                }
            }
        }
 
        System.out.println("The raise ratio was applied to " + type + " items.");
        displayAllItems();
    }
 
    public void listAboveShippingLimit(double limit) {
        ArrayList<Item> above = new ArrayList<>();
        ListIterator<Item> it = items.listIterator();
 
        while (it.hasNext()) {
            Item item = it.next();
            if (item.calculateShippingFee() > limit) {
                above.add(item);
            }
        }
 
        if (above.isEmpty()) {
            System.out.println("There is no item with a shipping fee over this limit.");
        } else {
            System.out.println("Items with shipping fees over " + limit + ":");
            for (Item item : above) {
                System.out.printf("Item: %s, Shipping Fee: %.2f%n",
                        item.getItemName(), item.calculateShippingFee());
            }
        }
    }

    public ArrayList<Item> getItems(){
        return items;
    } 
}
