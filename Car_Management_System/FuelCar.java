class FuelCar extends Car {

    private String Distributor_Name;
    private String Fuel_Type;
    private int Number_of_seats;
    private String Booked_Date;
    private String Purchased_Date;
    private int Mileage;
    private String Transmission_Type;
    private boolean isPurchased;

    public FuelCar(int carID, String car_name, String car_brand, String car_price, String Fuel_Type, int Number_of_seats, int Mileage) {

        super(carID,car_name, car_brand, car_price);
        this.Distributor_Name = "";
        this.Fuel_Type = Fuel_Type;
        this.Number_of_seats = Number_of_seats;
        this.Mileage = Mileage;
        this.Booked_Date = "";
        this.Purchased_Date = "";
        this.Transmission_Type = "";
        this.isPurchased = false;


    }
    public String getDistributor_Name() {


        return this.Distributor_Name;
    }
    public String getFuel_Type() {

        return this.Fuel_Type;
    }
    public int getNumber_of_seats(){

        return this.Number_of_seats;
    }
    public String getBooked_Date() {
        
        return this.Booked_Date;

    }
    public String getPurchased_Date() {

        return this.Purchased_Date;

    }
    public int getMileage(){

        return this.Mileage;

    }
    public String getTransmission_Type() {

        return this.Transmission_Type;

    }

    public boolean getPurchasedinfo() {

        return this.isPurchased;

    }

    public void setDistributor_Name(String Distributor) {

        this.Distributor_Name = Distributor;

    }
    public void setTransmission_Type(String Transmission) {

        this.Transmission_Type = Transmission;

    }
    public String purchase(String Purchased_Date, String Booked_Date) {
        String toReturn = "";
        if(this.isPurchased == true) {

            super.setcolor("black");

            toReturn += "The car id is " + getcarID() + "\n";
            toReturn += "The car name is " + getcar_name() + "\n";
            toReturn += "The car brand is " + getcar_brand() + "\n";
            toReturn += "The car color is " + getcar_color() + "\n";
            toReturn += "The price of the car is " + getcar_price() + "\n";
            toReturn += "The distributor's name is " + getDistributor_Name() + "\n";

        } else {

            System.out.println("abc");
            // this.setTransmission_Type("Manual");
            // this.setDistributor_Name("Ferrari");
            this.Purchased_Date = Purchased_Date;
            this.Booked_Date = Booked_Date;
            this.isPurchased = true;

        }
        return toReturn;

    }

    public String display() {

        String toReturn = super.display() + "\n";
        if(isPurchased == true) {

                toReturn += "The distributor name is: " + this.Distributor_Name + "\n";
                toReturn += "The type of fuel used is: " + this.Fuel_Type + "\n";
                toReturn += "The purchased date is: " + this.Purchased_Date + "\n";
                toReturn += "The booked date is: " + this.Booked_Date + "\n";
                toReturn += "The mileage is: " + this.Mileage + "\n";
                toReturn += "The Number of seats available is :" + this.Number_of_seats + "\n";
                toReturn += "The Transmission Type is: " + this.Transmission_Type + "\n";
        }
            return toReturn;

    }
}
