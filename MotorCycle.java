import java.util.Scanner;

public class MotorCycle extends  Vehicle implements Maintainable{
    Scanner INPUT = new Scanner(System.in);
    boolean helmetStatus;
    int engineCapacity;
    MotorCycle(int manfYear, String brand, String model, double dailyRentalPrice,boolean status,int engineCapacity){
        super(manfYear, brand, model, dailyRentalPrice, status);
        this.helmetStatus = false;
        this.engineCapacity = engineCapacity;
    }



    @Override
    void displayInfo() {
        super.displayInfo();
        IO.println(" | Engine Capacity (CC): "+engineCapacity);
    }

    @Override
    public double calculateTotalCost(int duration) {
        IO.println("do you want to add helmet? ( yes or no )");
        helmetStatus = INPUT.next().toLowerCase().equals("yes") ;
        return getDailyRentalPrice()*duration + (helmetStatus ? (5*duration):0);
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
    public void setHelmetStatus(boolean s){
        helmetStatus = s;
    }
    public boolean getHelmetStatus(boolean s){
        return helmetStatus;
    }
}
