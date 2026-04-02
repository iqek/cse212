import java.util.ArrayList;

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

    public ArrayList<Item> getItems(){
        return items;
    } 
}
