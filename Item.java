public class Item {
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

    public void updateQuantity (int purchasedQ){
        this.itemQuantity -= purchasedQ;
    }

    public double calculateVolumetricWeight (){
        return 0;
    }

    public double calculateShippingFee(){
        double vw = calculateVolumetricWeight();
        double rate = 0;

        if (vw < 1) {
            rate = 0.10;
        } else if (vw < 2) {
            rate = 0.25;
        } else if (vw < 5) {
            rate = 0.35;
        } else {
            rate = 0.50;
        }
        return itemPrice * vw * rate;
    }

    public double calculateTotalWorth(){
        return (itemPrice + calculateShippingFee()) * itemQuantity;
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

}
