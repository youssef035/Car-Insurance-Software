package Policy;

import java.io.Serializable;

public class Customer implements Serializable {

    String fName, LName, City;
    int c_Phone;
    Policy policy;

    public Customer() {
    }

    public Customer(String fName, String LName, String city, int c_Phone, Policy policy) {
        this.fName = fName;
        this.LName = LName;
        City = city;
        this.c_Phone = c_Phone;
        this.policy = policy;
    }


    public String getfName() {
        return fName;
    }

    public String getLName() {
        return LName;
    }

    public String getCity() {
        return City;
    }

    public int getC_Phone() {
        return c_Phone;
    }

    public Policy getPolicy() {
        return policy;
    }

    @Override
    public String toString() {
        return
                "fName='" + fName + '\'' +
                        "\n LName='" + LName + '\'' +
                        "\n City='" + City + '\'' +
                        "\n c_Phone=" + c_Phone +
                        "\n policy=" + policy ;
    }
}
