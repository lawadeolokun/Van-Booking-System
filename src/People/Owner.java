package People;

public class Owner extends Person{

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + this.getName() + '\'' +
                ", phone='" + this.getPhone() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                '}';
    }
}
