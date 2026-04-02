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

    public double calculateVolumetricWeight(){
        return (width * length * height) / 5000;
    }
}
