package Services;

import People.Owner;

public class Van {
    private boolean hasLift;
    private String type;
    private int capacity;
    private boolean available;
    private Owner owner;

    public Van(boolean hasLift) {
        this.hasLift = hasLift;
    }

    // Getter and setter for 'available'
    public boolean isAvailable() {
        return available;
    }

    public void setAvailability(boolean available) {
        this.available = available;
    }

    // Getter and setter for 'type'
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Getter and setter for 'capacity'
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Getter and setter for 'owner'
    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    // Optional: toString for debugging
    @Override
    public String toString() {
        return "Van{" +
                "type='" + type + '\'' +
                ", capacity=" + capacity +
                ", hasLift=" + hasLift +
                ", available=" + available +
                ", owner=" + (owner != null ? owner.getName() : "None") +
                '}';
    }
}
