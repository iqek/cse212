public class Order {

    private Item item;
    private String type;
    private int quantity;

    public Order(Item item, String type) {
        this.item = item;
        this.type = type;
    }

    public boolean checkStorage() {
        if(item.getItemQuantity() >= quantity){
            item.updateQuantity(quantity);
            return true;
        } 
        System.out.println("Insufficient stock. Available quantity: " + item.getItemQuantity());
        return false;
    }

    public void displayOrderInfo() {
        System.out.println("Order has been placed successfully.");
    }

    public void calculateOrderCost() {
        double cost = (item.getItemPrice() + item.calculateShippingFee()) * quantity;
        System.out.println("The total cost of " + item.getItemName() + " order is: " + cost);
    }

    public Item setItem(Item item){
        return this.item = item;
    }

    public String setType(String type){
        return this.type = type;
    }

    public int setQuantity(int quantity){
        return this.quantity = quantity;
    }

    public Item getItem(){
        return item;
    }

    public String getType(){
        return type;
    }

    public int getQuantity(){
        return quantity;
    }
}
