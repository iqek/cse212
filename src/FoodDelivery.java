public class FoodDelivery implements Service{

    private String foodName;
    private String restaurantName;
    private double mealPrice;
    private int count;
    private String type;

    public FoodDelivery(String foodName, String restaurantName, double mealPrice, int count, String type){
        this.foodName = foodName;
        this.restaurantName = restaurantName;
        this.mealPrice = mealPrice;
        this.count = count;
        this.type = "Food Delivery";
    }

    @Override
    public double calculateService(){
        return (mealPrice * count) + calculateShippingFee();
    }

    @Override
    public double calculateShippingFee(){
        return 5;
    }

    @Override
    public void displayServiceInfo() {
        System.out.println("Food Name: " + foodName);
        System.out.println("Restaurant Name: " + restaurantName);
        System.out.println("Meal Price: $" + mealPrice);
        System.out.println("Food Count: " + count);
        System.out.println();
    }

    @Override
    public String getServiceType(){
        return type;
    }

    public String getFoodName() { return foodName; }
}
