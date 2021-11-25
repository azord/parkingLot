package Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car {

    @Id
    @GeneratedValue
    private int id;

    private int license_plate;
    private String model;
    private String brand;

    public Car() {
    }

    public Car(int license_plate, String model, String brand) {
        this.license_plate = license_plate;
        this.model = model;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(int license_plate) {
        this.license_plate = license_plate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Car(int id, int license_plate, String model, String brand) {
        this.id = id;
        this.license_plate = license_plate;
        this.model = model;
        this.brand = brand;
    }
}
