abstract public class Vehicle {
    protected static int TotalVehicles = 1;
    private double baseCost;
    private int VID;
    private int manfYear;
    private String brand;
    private String model;
    private double dailyRentalPrice;
    private boolean status;
    protected boolean flagged;

    Vehicle(int manfYear, String brand, String model, double dailyRentalPrice,boolean status){
        VID = TotalVehicles;
        TotalVehicles++;
        this.manfYear = manfYear;
        this.brand = brand;
        this.model = model;
        this.dailyRentalPrice = dailyRentalPrice;
        this.status = status;
        flagged = false;

    }

    void displayInfo(){
        IO.print("Vehicle's ID: "+VID+
                " | brand: "+brand+
                " | model: "+model+
                " | Manf. year: " + manfYear +
                " | daily rental price: "+ dailyRentalPrice+
                " | Status: " + (status ? "Available":"Rented")+
                " | Maintenance status: "+(flagged ? "flagged":"not flagged" ));
    }

     public void flag(){
         flagged = true;
     }



    public void setDailyRentalPrice(double dailyRentalPrice) {
        if(dailyRentalPrice > 0)
        this.dailyRentalPrice = dailyRentalPrice;
        else
            IO.println("nope, we don't pay our customers anywhere in our policy");
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public int getVID() {
        return VID;
    }
    public double getDailyRentalPrice() {
        return dailyRentalPrice;
    }

    public boolean getStatus(){
        return status;
    }
    public String getBrand() {
        return brand;
    }

    abstract public double calculateTotalCost(int duration);


}
