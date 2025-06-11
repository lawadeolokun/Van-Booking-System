import People.Driver;
import People.Owner;
import Services.BookingRequest;
import Services.Customer;
import Services.ServiceType;
import Services.Van;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Owner and vans setup
        Owner owner1 = new Owner();
        owner1.setName("Jimmy Neutron");
        owner1.setPhone("0831783910");
        owner1.setAddress("53 Waterville Lane, Dublin 15");

        List<Van> vans = new ArrayList<>();

        Van van1 = new Van(true);
        van1.setType("Sprinter");
        van1.setCapacity(3);
        van1.setAvailability(true);
        van1.setOwner(owner1);
        vans.add(van1);

        Van van2 = new Van(true);
        van2.setType("Transit");
        van2.setCapacity(2);
        van2.setAvailability(true);
        van2.setOwner(owner1);
        vans.add(van2);

        // Driver setup
        Driver driver1 = new Driver();
        driver1.setName("Sammy");
        driver1.setPhone("0847283902");

        List<Customer> customers = new ArrayList<>();

        System.out.println("Welcome to the Van Booking System!");

        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Register a Customer");
            System.out.println("2. Create a Booking Request");
            System.out.println("3. View All Bookings");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter contact number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    Customer newCustomer = new Customer();
                    newCustomer.setName(name);
                    newCustomer.setContactNumber(phone);
                    newCustomer.setAddress(address);
                    customers.add(newCustomer);
                    System.out.println("Customer registered: " + name);
                    break;

                case 2:
                    if (customers.isEmpty()) {
                        System.out.println("No customers registered.");
                        break;
                    }

                    System.out.println("Select a customer:");
                    for (int i = 0; i < customers.size(); i++) {
                        System.out.println((i + 1) + ". " + customers.get(i).getName());
                    }
                    int custIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    System.out.println("Choose a service type:");
                    for (ServiceType type : ServiceType.values()) {
                        System.out.println((type.ordinal() + 1) + ". " + type);
                    }
                    int serviceChoice = scanner.nextInt() - 1;
                    scanner.nextLine();

                    Date date = null;
                    while (true) {
                        System.out.print("Enter booking date (DD-MM-YYYY): ");
                        String dateStr = scanner.nextLine();
                        try {
                            date = new SimpleDateFormat("dd-MM-yyyy").parse(dateStr);
                            if (date.before(new Date())) {
                                System.out.println("Cannot book a past date.");
                            } else {
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid date format.");
                        }
                    }

                    System.out.println("Available vans:");
                    List<Van> availableVans = new ArrayList<>();
                    for (int i = 0; i < vans.size(); i++) {
                        if (vans.get(i).isAvailable()) {
                            availableVans.add(vans.get(i));
                            System.out.println((availableVans.size()) + ". " + vans.get(i).getType());
                        }
                    }

                    if (availableVans.isEmpty()) {
                        System.out.println("No vans available.");
                        break;
                    }

                    System.out.print("Select a van: ");
                    int vanChoice = scanner.nextInt() - 1;
                    scanner.nextLine();
                    Van selectedVan = availableVans.get(vanChoice);
                    selectedVan.setAvailability(false);

                    BookingRequest request = new BookingRequest();
                    request.setServiceType(ServiceType.values()[serviceChoice]);
                    request.setPreferredDate(date);
                    request.setAssignedVan(selectedVan);

                    Customer selectedCustomer = customers.get(custIndex);
                    selectedCustomer.addBookingRequest(request);

                    System.out.println("\nBooking Details:");
                    System.out.println("Customer Name: " + selectedCustomer.getName());
                    System.out.println("Customer Phone Number: " + selectedCustomer.getContactNumber());
                    System.out.println("Customer Address: " + selectedCustomer.getAddress());
                    System.out.println("Service: " + request.getServiceType());
                    SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
                    System.out.println("Date: " + outputFormat.format(request.getPreferredDate()));
                    System.out.println("Van: " + selectedVan.getType());
                    System.out.println("Driver Name: " + driver1.getName());
                    System.out.println("Driver Phone Number: " + driver1.getPhone());
                    break;

                case 3:
                    if (customers.isEmpty()) {
                        System.out.println("No bookings found.");
                        break;
                    }
                    for (Customer c : customers) {
                        System.out.println("\nBookings for " + c.getName() + ":");
                        for (BookingRequest br : c.getBookingRequests()) {
                            String vanInfo = (br.getAssignedVan() != null)
                                    ? "Van: " + br.getAssignedVan().getType()
                                    : "No van assigned";
                            System.out.println("- " + br.getServiceType() + " on " + br.getPreferredDate() + " | " + vanInfo);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
