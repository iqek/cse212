public interface Service {

    abstract String getServiceType();
    abstract double calculateService();
    abstract void displayServiceInfo();
    abstract double calculateShippingFee();
}