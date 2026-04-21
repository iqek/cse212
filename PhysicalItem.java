public class PhysicalItem extends Item {
    private double width;
    private double length;
    private double height;

    PhysicalItem(String itemName, double itemPrice, int itemQuantity, Provider provider, String type, double width, double length, double height){
        super(itemName, itemPrice, itemQuantity, provider, "physical");
        this.width = width;
        this.length = length;
        this.height = height;
    }

    @Override
    public double calculateVolumetricWeight(){
        return (width * length * height) / 5000;
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
        return getItemPrice() * vw * rate;
    }

    @Override
    public void displayItem() {
        super.displayItem();
        System.out.println("Width: " + width + ", Length: " + length + ", Height: " + height);
        System.out.println();
    }
}
