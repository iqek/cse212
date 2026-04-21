public abstract class Item implements Service {
    private String itemName;
    private double itemPrice;
    private int itemQuantity;
    private Provider provider;
    private String type;   //either digital or physical

    public Item(String itemName, double itemPrice, int itemQuantity, Provider provider, String type){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
        this.provider = provider;
        this.type = type;
    }

    public abstract void updateQuantity (int purchased);

    public abstract double calculateTotalWorth();

    public abstract double calculateVolumetricWeight ();

    public abstract double calculateShippingFee();

    @Override
    public double calculateService() {
        return itemPrice * itemQuantity;
    }
 
    @Override
    public String getServiceType() {
        return type;
    }
 
    @Override
    public void displayServiceInfo() {
        displayItem();
    }

    public void displayItem() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: " + itemPrice);
        System.out.println("Quantity: " + itemQuantity);
        System.out.println("Provider: " + provider.getName());
        System.out.println("Provider Contact: +" + provider.getCountryCode() + "(" + provider.getAreaCode() + ")" + provider.getPhoneNumber());
        System.out.println("");
    }

    public String getItemName(){
        return itemName;
    }

    public double getItemPrice(){
        return itemPrice;
    }

    public int getItemQuantity(){
        return itemQuantity;
    }

    public String getItemType(){
        return type;
    }

    public double setItemPrice(double price){
        return this.itemPrice = price;
    }

    public int setItemQuantity(int quantity){
        return this.itemQuantity = quantity;
    }

}
