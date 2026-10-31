public class Rent {
    static private int totalRents;
    static public double totalProfits;
    private int rentalID;
    private Customer customer;
    private Vehicle vehicle;
    private int rentalDuration;
    private double totalRentalCost;
    private boolean status;

    Rent(Customer customer,Vehicle vehicle, int rentalDuration){
        rentalID = totalRents;
        totalRents++;
        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalDuration = rentalDuration;
        this.totalRentalCost = vehicle.calculateTotalCost(rentalDuration);
        status = true;
        vehicle.setStatus(false);
    }

    public void showInfo(){
        IO.println("Rental ID: " + rentalID + " | Customer: " + customer.getFullName()+ " | Vehicle ID: "+ vehicle.getVID()+ " | Rental duration: " + rentalDuration+ " | Total rental cost: "+totalRentalCost);
    }
    public void  setStatus(boolean s){
        status = s;
        vehicle.setStatus(!this.status);
    }
    public double getTotalProfits(){
        return totalProfits;
    }
    public int getID(){
        return rentalID;
    }
    public boolean getStatus(){
        return status;
    }
    public void addProfit(){
        totalProfits += totalRentalCost;
    }
}
