class ElectricCar extends Car {

    private String Customer_Name;
    private int Battery_Capacity;
    private int Battery_Warrenty;
    private String Purchased_Date;
    private String Range;
    private int Recharge_Time;
    private boolean isBought;
    private boolean isSold;

    public ElectricCar(int carID, String car_name, String car_brand, String car_price, int Battery_Capacity) {

        super(carID,car_name, car_brand, car_price);
        this.Battery_Capacity = Battery_Capacity;
        this.Customer_Name = "";
        this.Battery_Warrenty = 0;
        this.Purchased_Date = "";
        this.Range = "";
        this.Recharge_Time = 0;
        this.isBought = false;
        this.isSold = false;

    }

    public String getCustomerName() {

        return this.Customer_Name;
    }
    public int getBatteryCapacity() {

        return this.Battery_Capacity;

    }
    public int getBatteryWarrenty() {

        return this.Battery_Warrenty;
    }
    public String getPurchasedDate() {

        return this.Purchased_Date;
    }
    public String getRange() {

        return this.Range;

    }
    public int getRechargeTime() {

        return this.Recharge_Time;
    }
    public boolean getSold() {

        return this.isSold;
    }
    public boolean getBought() {

        return this.isBought;

    }
    public void setCustomer_Name(String customerName) {
        
        if(this.isBought == false) {
            this.Customer_Name = customerName;
        } else{
            System.out.println("The electric car is already bought so cannot set the customer name");

        }

    }
    public void BuyElectricCar(String Customer_Name, String Battery_Warrenty, String Purchased_Date, String Range, String Recharge_Time) {
        if(this.isBought == false) {
            setCustomer_Name(Customer_Name);
            this.isBought = true;
        } else {

            System.out.println("The electric car is already bought");

        }
    }
    public void sellElectricCar(String newCustomerName) {
    
        this.Customer_Name = newCustomerName;
        if(isSold == false) {
            
            this.Battery_Capacity = 0;
            this.Battery_Warrenty = 0;
            this.Purchased_Date = "";
            this.Range = "";
            this.Recharge_Time = 0;
            this.isSold = true;
            this.isBought = false;
            if(isSold == true) {
                
                System.out.println("The car is already sold");

            }
        }
    }
    public String display() {

        String toReturn = super.display() + "\n";
        if(isBought == true) {

            toReturn += "The name of the customer is " + this.Customer_Name + "\n";
            toReturn += "The Battery Capacity is " + this.Battery_Capacity + "\n";
            toReturn += "The Battery Warrenty is " + this.Battery_Warrenty + "\n";
            toReturn += "The purchased date is " + this.Purchased_Date + "\n";
            toReturn += "The range is " + this.Range + "\n";
            toReturn += "The recharge time is " + this.Recharge_Time + "\n";

        }

        return toReturn;

    }
    

}
