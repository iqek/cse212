public class Streaming implements Service{
    
    private String title;
    private String category;
    private double costPerDay;
    private int days;
    private String type;

    public Streaming(String title, String category, double costPerDay, int days, String type){
        this.title = title;
        this.category = category;
        this.costPerDay = costPerDay;
        this.days = days;
        this.type = "Streaming";
    }

    @Override
    public double calculateService(){
        return (costPerDay * days) + calculateShippingFee();
    }

    @Override
    public double calculateShippingFee(){
        return 0;
    }

    @Override
    public void displayServiceInfo() {
        System.out.println("Title : " + title);
        System.out.println("Category: " + category);
        System.out.println("Cost Per Day: $" + costPerDay);
        System.out.println("Rental Days: " + days);
        System.out.println();
    }

    @Override
    public String getServiceType(){ 
        return type;
    }

    public String getTitle() {return title;}

}
