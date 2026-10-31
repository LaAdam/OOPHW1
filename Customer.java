import java.util.ArrayList;

public class Customer {
  static private int totalCustomer;
  private int CustomerID;
  private String fullName;
  private String phone;
  private String email;
  private String drivingLicenseNumber;
    private ArrayList<Rent> Rents = new ArrayList<Rent>();

    Customer(String fullName, String phone,String email, String drivingLicenseNumber){
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.CustomerID = totalCustomer;
        totalCustomer++;
    }

    Customer(String fullName, String phone) {
        this(fullName, phone, "N/A", "N/A");
    }
    public void Rent(Vehicle vehicle,int rentalDuration){
        if(vehicle.getStatus() && !vehicle.flagged)
            if(rentalDuration < 1)
            IO.println("Minimum duration is 1 day");
        else
        Rents.add(new Rent(this,vehicle,rentalDuration));
        else
            IO.println("Can't rent the car, Car is either flagged or rented.");
    }
    public  void Return(int rID){
        for(Rent R : Rents){
            if(R.getID() == rID){
                if(R.getStatus()) {
                    R.setStatus(false);
                    IO.println("Returned successfully");
                    R.addProfit();
                }
                else
                    IO.println("Rental is already returned.");
                return;
            }
        }
        IO.println("The rental ID doesn't exist for "+ fullName);
    }
    public String getFullName() {
        return fullName;
    }
    public void getRents(){
        for(Rent R : Rents)
            R.showInfo();
    }
    public void getInfo(){
        IO.println("Customer ID: "+ CustomerID + " | Full name: "+ fullName + " | " + " | Phone number: " + phone + " | Email: " + email + " | driving license number: " + drivingLicenseNumber);
    }
    public int getID(){
        return CustomerID;
    }

}
