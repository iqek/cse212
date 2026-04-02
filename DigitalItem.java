public class DigitalItem extends Item {
    double diskSpace;

    DigitalItem (String itemName, double itemPrice, int itemQuantity, Provider provider, String type, double diskSpace){
        super(itemName, itemPrice, itemQuantity, provider, "digital");
        this.diskSpace = diskSpace;
    }

    @Override
    public double calculateShippingFee(){
        return 0;
    }
}
