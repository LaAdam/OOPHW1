import java.util.Scanner;

public class Car extends Vehicle implements Maintainable {
    Scanner INPUT = new Scanner(System.in);
    boolean insuranceStatus;
    String transmissionType;
    int seats;
     Car(int manfYear, String brand, String model, double dailyRentalPrice,boolean status,String transmissionType, int seats){
         super(manfYear, brand, model, dailyRentalPrice, status);
         this.insuranceStatus = false;
         this.transmissionType = transmissionType;
         this.seats = seats;
     }



    @Override
    void displayInfo() {
       super.displayInfo();
       IO.println(" | Number of seats: "+seats + " | transmission type: "+transmissionType);
    }

    @Override
    public double calculateTotalCost(int duration) {
         IO.println("do you want to add insurance? ( yes or no )");
         insuranceStatus = INPUT.next().toLowerCase().equals("yes") ;

        return getDailyRentalPrice()*duration + (insuranceStatus ? (15*duration):0);
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
    public void setInsuranceStatus(boolean s){
         insuranceStatus = s;
    }
    public boolean getInsuranceStatus(){
       return insuranceStatus;
    }
}
