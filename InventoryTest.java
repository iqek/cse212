import java.util.*;

public class InventoryTest {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        ArrayList<Order> orders = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);   

        int choice;

        do {
            System.out.println("\nINVENTORY MENU:");
            System.out.println("1. Add a New Item");
            System.out.println("2. Display all Items");
            System.out.println("3. Display the Total Number of Items");
            System.out.println("4. Calculate the Total Worth of the Inventory");
            System.out.println("CUSTOMER MENU:");
            System.out.println("5. Add an Order");
            System.out.println("6. Calculate Order Cost");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            Menu option = Menu.fromInt(choice);

            if (option == null) {
                System.out.println("Invalid choice");
                continue;
            }

            switch (option) {

                case ADD_ITEM:
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
                    System.out.println("Item's Information:");
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

                    System.out.println();
                    System.out.println("Physical or Digital Item? ");
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
 
                    inventory.addItem(item);
                    break;

                case DISPLAY_ITEMS:
                    inventory.displayAllItems();
                    break;

                case TOTAL_ITEMS:
                    System.out.println("Total number of items: " + inventory.getTotalNumberOfItems());
                    break;

                case TOTAL_WORTH:
                    inventory.calculateTotalWorth();
                    break;

                case ADD_ORDER:
                    System.out.print("Enter the item name you want to order: ");
                    String orderName = scanner.nextLine();
 
                    System.out.print("Enter the quantity: ");
                    int orderQuantity = scanner.nextInt();
                    scanner.nextLine();
 
                    Item foundItem = null;
                    for (Item i : inventory.getItems()) {
                        if (i.getItemName().equalsIgnoreCase(orderName)) {
                            foundItem = i;
                            break;
                        }
                    }
 
                    if (foundItem == null) {
                        System.out.println("Item not found in inventory. Order cannot be placed.");
                        break;
                    }
 
                    Order newOrder = new Order(foundItem, foundItem.getItemType());
                    newOrder.setQuantity(orderQuantity);
 
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

        } while (choice != 7);

        scanner.close();
    }
}