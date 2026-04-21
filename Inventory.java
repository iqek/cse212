import java.util.ArrayList;
import java.util.ListIterator;

public class Inventory {

    private ArrayList<Service> services;

    public Inventory() {
        services = new ArrayList<>();
    }

    public void addService(Service service) {
        services.add(service);
    }

    public void displayAllServices() {
        if (services.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        for (Service s : services) {
            s.displayServiceInfo();
        }
    }

    public int getTotalNumberOfServices() {
        return services.size();
    }

    public void calculateTotalWorth() {
        for (Service s : services) {
            System.out.println("Total Worth of Service " + s.getServiceType() + ": $" + s.calculateService());
        }
    }

    public void increasePrice(String type, double raisePercent, ArrayList<Order> orders) {
        ListIterator<Service> it = services.listIterator();

        while (it.hasNext()) {
            Service s = it.next();

            if (s instanceof Item && s.getServiceType().equalsIgnoreCase(type)) {
                Item item = (Item) s;
                boolean alreadyOrdered = false;
                for (Order o : orders) {
                    if (o.getItem() == item) {
                        alreadyOrdered = true;
                        break;
                    }
                }
                if (!alreadyOrdered) {
                    item.setItemPrice(item.getItemPrice() * (1 + raisePercent / 100));
                }
            }
        }

        System.out.println("The raise ratio was applied to " + type + " items.");
        displayAllServices();
    }

    public void listAboveShippingLimit(double limit) {
        ArrayList<Service> above = new ArrayList<>();
        ListIterator<Service> it = services.listIterator();

        while (it.hasNext()) {
            Service s = it.next();
            if (s.calculateShippingFee() > limit) {
                above.add(s);
            }
        }

        if (above.isEmpty()) {
            System.out.println("There is no item with a shipping fee over this limit.");
        } else {
            System.out.println("Items with shipping fees over " + limit + ":");
            for (Service s : above) {
                System.out.printf("Item: %s, Shipping Fee: %.2f%n",
                        s.getServiceType(), s.calculateShippingFee());
            }
        }
    }

    public ArrayList<Service> getServices() {
        return services;
    }
}