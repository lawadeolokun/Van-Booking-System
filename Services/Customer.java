package Services;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String contactNumber;
    private String address; // 🔹 Add this field
    private List<BookingRequest> bookingRequests = new ArrayList<>();

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    // 🔹 New address methods
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addBookingRequest(BookingRequest request) {
        bookingRequests.add(request);
    }

    public List<BookingRequest> getBookingRequests() {
        return bookingRequests;
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + "', phone='" + contactNumber + "', address='" + address + "'}";
    }
}
