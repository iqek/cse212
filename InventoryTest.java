import java.util.*;

public class InventoryTest {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        ArrayList<Order> orders = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\nINVENTORY MENU:");
            System.out.println("1. Add a New Service");
            System.out.println("2. Display all Services");
            System.out.println("3. Display the Total Number of Services");
            System.out.println("4. Calculate the Total Worth of the Inventory");
            System.out.println("5. Increase Price of Specific Type");
            System.out.println("6. List Services with Shipping Fee Above a Limit");
            System.out.println("7. Remove Order for a Specific City");
            System.out.println("CUSTOMER MENU:");
            System.out.println("8. Add an Order");
            System.out.println("9. Calculate Order Cost");
            System.out.println("10. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            Menu option = Menu.fromInt(choice);

            if (option == null) {
                System.out.println("Invalid choice.");
                continue;
            }

            switch (option) {

                case ADD_ITEM:
                    System.out.println("1. Item (Physical/Digital)");
                    System.out.println("2. Streaming");
                    System.out.println("3. Food Delivery");
                    int serviceChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (serviceChoice == 1) {
                        System.out.println("Item's Information:");
                        System.out.print("Enter item name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter item price: $");
                        double price = scanner.nextDouble();

                        System.out.print("Enter item quantity: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println();
                        System.out.println("Provider's Information:");
                        System.out.print("Enter provider name: ");
                        String prv_name = scanner.nextLine();

                        System.out.print("Enter country code: ");
                        int country_code = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter area code: ");
                        int area_code = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter phone number: ");
                        int phone_num = scanner.nextInt();
                        scanner.nextLine();

                        Provider provider = new Provider(prv_name, country_code, area_code, phone_num);

                        System.out.print("Physical or Digital Item? ");
                        String type = scanner.nextLine();
                        Item item = null;

                        if (type.equalsIgnoreCase("Physical")) {
                            System.out.print("Enter width: ");
                            double width = scanner.nextDouble();
                            System.out.print("Enter length: ");
                            double length = scanner.nextDouble();
                            System.out.print("Enter height: ");
                            double height = scanner.nextDouble();
                            scanner.nextLine();

                            item = new PhysicalItem(name, price, quantity, provider, type, width, length, height);
                            System.out.println("Physical item added successfully.");

                        } else if (type.equalsIgnoreCase("Digital")) {
                            System.out.print("Enter disk space: ");
                            double disk_space = scanner.nextDouble();
                            scanner.nextLine();

                            item = new DigitalItem(name, price, quantity, provider, type, disk_space);
                            System.out.println("Digital item added successfully.");

                        } else {
                            System.out.println("Unknown item type. Item not added.");
                            break;
                        }

                        inventory.addService(item);

                    } else if (serviceChoice == 2) {
                        System.out.println("Streaming Information:");
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();

                        System.out.print("Enter category: ");
                        String category = scanner.nextLine();

                        System.out.print("Enter cost per day: ");
                        double costPerDay = scanner.nextDouble();

                        System.out.print("Enter days: ");
                        int days = scanner.nextInt();
                        scanner.nextLine();

                        inventory.addService(new Streaming(title, category, costPerDay, days, "Streaming"));
                        System.out.println("Streaming added successfully.");

                    } else if (serviceChoice == 3) {
                        System.out.println("Food Delivery Information:");
                        System.out.print("Enter food name: ");
                        String foodName = scanner.nextLine();

                        System.out.print("Enter restaurant name: ");
                        String restaurantName = scanner.nextLine();

                        System.out.print("Enter meal price: $");
                        double mealPrice = scanner.nextDouble();

                        System.out.print("Enter food count: ");
                        int count = scanner.nextInt();
                        scanner.nextLine();

                        inventory.addService(new FoodDelivery(foodName, restaurantName, mealPrice, count, "Food Delivery"));
                        System.out.println("Food Delivery added successfully.");

                    } else {
                        System.out.println("Invalid service type.");
                    }
                    break;

                case DISPLAY_ITEMS:
                    inventory.displayAllServices();
                    break;

                case TOTAL_ITEMS:
                    System.out.println("Total number of services: " + inventory.getTotalNumberOfServices());
                    break;

                case TOTAL_WORTH:
                    inventory.calculateTotalWorth();
                    break;

                case INC_PRICE:
                    System.out.print("Which type of items will be raised in price?: ");
                    String raiseType = scanner.nextLine();

                    System.out.print("How much will the raise ratio(%) be?: ");
                    double raisePercent = scanner.nextDouble();
                    scanner.nextLine();

                    inventory.increasePrice(raiseType, raisePercent, orders);
                    break;

                case ABOVE_LIMIT:
                    System.out.print("Enter a limit: ");
                    double limit = scanner.nextDouble();
                    scanner.nextLine();

                    inventory.listAboveShippingLimit(limit);
                    break;

                case REMOVE_CITY:
                    System.out.print("Type a name to remove orders destined to a specific city: ");
                    String city = scanner.nextLine();

                    boolean found = false;
                    ListIterator<Order> cityIt = orders.listIterator();
                    while (cityIt.hasNext()) {
                        Order o = cityIt.next();
                        if (o.getDestinationCity().equalsIgnoreCase(city)) {
                            cityIt.remove();
                            found = true;
                        }
                    }

                    if (found) {
                        System.out.println("The order(s) for " + city + " was deleted successfully");
                    } else {
                        System.out.println("There are no orders placed for " + city);
                    }
                    break;

                case ADD_ORDER:
                    System.out.print("Enter the item name you want to order: ");
                    String orderName = scanner.nextLine();

                    System.out.print("Enter the quantity: ");
                    int orderQuantity = scanner.nextInt();
                    scanner.nextLine();

                    Service foundService = null;
                    for (Service s : inventory.getServices()) {
                        String sName = null;
                        if (s instanceof Item) sName = ((Item) s).getItemName();
                        else if (s instanceof FoodDelivery) sName = ((FoodDelivery) s).getFoodName();
                        else if (s instanceof Streaming) sName = ((Streaming) s).getTitle();

                        if (sName != null && sName.equalsIgnoreCase(orderName)) {
                            foundService = s;
                            break;
                        }
                    }

                    if (foundService == null) {
                        System.out.println("Service not found. Order cannot be placed.");
                        break;
                    }

                    System.out.print("Enter destination region: ");
                    String region = scanner.nextLine();

                    System.out.print("Enter destination city: ");
                    String destCity = scanner.nextLine();

                    System.out.print("Enter destination post code: ");
                    int postCode = scanner.nextInt();
                    scanner.nextLine();

                    Order newOrder = new Order(foundService);
                    newOrder.setQuantity(orderQuantity);
                    newOrder.setDestinationRegion(region);
                    newOrder.setDestinationCity(destCity);
                    newOrder.setDestinationPostCode(postCode);

                    if (newOrder.checkStorage()) {
                        orders.add(newOrder);
                        newOrder.displayOrderInfo();
                    }
                    break;

                case ORDER_COST:
                    if (orders.isEmpty()) {
                        System.out.println("No orders placed yet.");
                    } else {
                        for (Order o : orders) {
                            o.calculateOrderCost();
                        }
                    }
                    break;

                case EXIT:
                    System.out.println("Exiting... Goodbye!");
                    break;
            }

        } while (choice != 10);

        scanner.close();
    }
}