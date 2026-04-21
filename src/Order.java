public class Order {

    private Service service;
    private int quantity;

    private String destinationRegion;
    private String destinationCity;
    private int destinationPostCode;

    public Order(Service service) {
        this.service = service;;
    }

    public boolean checkStorage() {
        if (service instanceof Item) {
            Item item = (Item) service;
            if (item.getItemQuantity() >= quantity) {
                item.updateQuantity(quantity);
                return true;
            }
            System.out.println("Insufficient stock. Available quantity: " + item.getItemQuantity());
            return false;
        }
        return true;
    }

    public void displayOrderInfo() {
        System.out.println("Order has been placed successfully.");
    }

    public void calculateOrderCost() {
        String name;
        if (service instanceof Item) {
            name = ((Item) service).getItemName();
        } else if (service instanceof FoodDelivery) {
            name = ((FoodDelivery) service).getFoodName();
        } else if (service instanceof Streaming) {
            name = ((Streaming) service).getTitle();
        } else {
            name = service.getServiceType();
        }
        System.out.println("The total cost of " + name + " order is: $" + service.calculateService());
    }

    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setDestinationRegion(String region) { this.destinationRegion = region; }
    public void setDestinationCity(String city) { this.destinationCity = city; }
    public void setDestinationPostCode(int postCode) { this.destinationPostCode = postCode; }
 
    public Service getService() { return service; }
    public int getQuantity() { return quantity; }
    public String getDestinationCity() { return destinationCity; }

    public Item getItem() {
        if (service instanceof Item){
            return (Item) service;
        }
        return null;
    }
}
