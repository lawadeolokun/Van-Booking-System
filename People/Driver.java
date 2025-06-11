package People;

public class Driver extends Person{

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + this.getName() + '\'' +
                ", phone='" + this.getPhone() + '\'' +
                '}';
    }
}
