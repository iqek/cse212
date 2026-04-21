public class DigitalItem extends Item {
    double diskSpace;

    DigitalItem (String itemName, double itemPrice, int itemQuantity, Provider provider, String type, double diskSpace){
        super(itemName, itemPrice, itemQuantity, provider, "digital");
        this.diskSpace = diskSpace;
    }

    @Override
    public double calculateVolumetricWeight (){
        return 0;
    }
    
    @Override
    public double calculateShippingFee(){
        return 0;
    }

    @Override
    public void updateQuantity (int purchased){
        setItemQuantity(getItemQuantity() - purchased);
    }

    @Override
    public double calculateTotalWorth(){
        return getItemPrice() * getItemQuantity();
    }

    @Override
    public void displayItem() {
        super.displayItem();
        System.out.println("Disk Space: " + diskSpace);
        System.out.println();
    }
}
