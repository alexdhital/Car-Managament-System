public class Car {
    
    private int carID;
    private String car_name;
    private String car_brand; 
    private String car_color;
    private String car_price;

    public Car(int carID, String car_name, String car_brand, String car_price) {

        this.carID = carID;
        this.car_name = car_name;
        this.car_brand = car_brand;
        this.car_price = car_price;
        this.car_color = "";
    }

    public int getcarID() {

        return this.carID;
    }

    public String getcar_name() {

        return this.car_name;
    }

    public String getcar_brand() {

        return this.car_brand;
    }

    public String getcar_price() {

        return this.car_price;
    }

    public String getcar_color() {

        return this.car_color;
    }

    public void setcolor(String newColor) {

        this.car_color = newColor;
    }

    public String display() {
        String toReturn = "";
        if(this.car_color == "") {

            toReturn = "The color of " + this.getcar_name() + " is empty\n";

        }
        return toReturn;
    }
}
