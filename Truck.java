public class Truck extends  Vehicle implements Maintainable{

   static public int serviceFee = 50;
    private int maximumLoadCapacity;

    Truck(int manfYear, String brand, String model, double dailyRentalPrice,boolean status,int maximumLoadCapacity){
        super(manfYear, brand, model, dailyRentalPrice, status);
        this.maximumLoadCapacity = maximumLoadCapacity;
    }



    @Override
    void displayInfo() {
        super.displayInfo();
        IO.println(" | Maximum Load Capacity: "+ maximumLoadCapacity);
    }

    @Override
    public double calculateTotalCost(int duration) {
        return getDailyRentalPrice()*duration + serviceFee;
    }


    @Override
    public void performMaintenance() {
        if(!getStatus()){
            IO.println("Vehicle is rented.");
            return;
        }
        flagged = false;
        IO.println("Vehicle Maintained succefully");
    }

    @Override
    public boolean needsMaintenance() {
        return flagged;
    }

}
