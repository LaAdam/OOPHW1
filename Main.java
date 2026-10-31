Scanner INPUT = new Scanner(System.in);
ArrayList<Vehicle> Vehicles = new ArrayList<Vehicle>();
ArrayList<Customer> Customers = new ArrayList<Customer>();

void main() {
boolean quit = false;
while(!quit){
    IO.println("Choose what to do:");
    IO.println("1)\tAdd New Vehicle\n" +
            "2)\tDisplay All Vehicles\n" +
            "3)\tSearch for Vehicle\n" +
            "4)\tDisplay Available Vehicles\n" +
            "5)\tRegister New Customer\n" +
            "5)\tRegister New Customer\n" +
            "6)\tDisplay All Customers\n" +
            "7)\tRent a Vehicle\n" +
            "8)\tReturn a Vehicle\n" +
            "9)\tDisplay All Rentals\n" +
            "10)\tDisplay Customer Rental History\n" +
            "11)\tDisplay Total Revenue\n" +
            "12)\tFlag Vehicle for Maintenance\n" +
            "13)\tDisplay Vehicles Requiring Maintenance\n" +
            "14)\tPerform Vehicle Maintenance\n" +
            "0)\tExit");
    boolean found;
        switch (INPUT.nextInt()) {
            case 1:
                AddNewVehicle();
                break;
            case 2:
              for(Vehicle V: Vehicles){
                  V.displayInfo();
              }
              if(Vehicles.isEmpty())
                  IO.println("There is no vehicles currently.");
                break;
            case 3:
                IO.println("Search by:\n1)\tVehicle ID\n2)\tBrand Name");
                int searchChoice = INPUT.nextInt();
                if (searchChoice == 1) {
                    IO.println("What is the Vehicle's ID?");
                    SearchForVehicle(INPUT.nextInt());
                } else if (searchChoice == 2) {
                    IO.println("What is the vehicle's brand?");
                    SearchForVehicle(INPUT.next());
                } else {
                    IO.println("Invalid search option.");
                }
                break;
            case 4:
                found = false;
                for(Vehicle V: Vehicles){
                    if(V.flagged || !V.getStatus())
                        continue;
                    else {
                        V.displayInfo();
                        found = true;
                    }
                }
                if(!found)
                IO.println("There is no available vehicles currently.");
                break;
            case 5:
                RegisterNewCustomer();
                break;
            case 6:
               for(Customer C : Customers)
                   C.getInfo();
                break;
            case 7:
                RentVehicle();
                break;
            case 8:
              ReturnVehicle();
                break;
            case 9:
               DisplayAllRentals();
                break;
            case 10:
                DisplayCustomerRentalHistory();
                break;
            case 11:
           IO.println("Total revenue: " + Rent.totalProfits);
                break;
            case 12:
               FlagVehicleForMaintenance();
                break;
            case 13:
                found = false;
                for(Vehicle V: Vehicles){
                    if(((Maintainable) V).needsMaintenance()) {
                        V.displayInfo();
                        found = true;
                    }
                    else
                        continue;
                }
                if(!found)
                    IO.println("There is no vehicles in need of maintenance currently.");
                break;
            case 14:
                PerformVehicleMaintenance();
                break;
            case 0:
               quit = true;
                break;
            default:
                IO.println("Invalid option. Please choose between 0 and 14.");

    }
    IO.println("input anything to continue.");
    INPUT.next();
}

}

private void DisplayCustomerRentalHistory() {
    Customer C = NeedsIDC();
    if(C==null)
        return;
    IO.println("Rental history for: "+C.getFullName());
    C.getRents();
}

private void DisplayAllRentals() {
    for(Customer C : Customers) {
        IO.println("Rents for: "+C.getFullName());
        C.getRents();
    }
}

private void ReturnVehicle() {
    Customer C = NeedsIDC();
    if(C==null)
        return;
    IO.println("What is the order's ID?");
    C.Return(INPUT.nextInt());
}

private void RentVehicle() {
    Customer C = NeedsIDC();
    if(C==null)
        return;
    Vehicle V = NeedsID();
    if(V==null)
        return;
    IO.println("How long is the duration?");
    int duration = INPUT.nextInt();
    C.Rent(V,duration);

}

private void RegisterNewCustomer() {
    IO.println("Name of the customer?");
    String fullName = INPUT.next();
    IO.println("phone number of the customer?");
    String phone = INPUT.next();
    IO.println("Email of the customer?");
    String email = INPUT.next();
    IO.println("driving license nubmer of the customer?");
    String drivingLicenseNumber = INPUT.next();
    Customers.add(new Customer(fullName,phone,email,drivingLicenseNumber));

}

private void PerformVehicleMaintenance() {
    Vehicle V = NeedsID();
    if (V != null) {
        Maintainable MV = (Maintainable) V;
        if (MV.needsMaintenance()) {
            MV.performMaintenance();
        } else {
            IO.println("This vehicle does not need maintenance.");
        }
    }
}

Vehicle NeedsID(){
    IO.println("What is the Vehicle's ID?");
    int ID = INPUT.nextInt();
    for(Vehicle V: Vehicles){
        if(V.getVID() == ID){
            return V;
        }
    }
    IO.println("Vehicle not found.");
    return null;

}
Customer NeedsIDC(){
    IO.println("What is the Customer's ID?");
    int ID = INPUT.nextInt();
    for(Customer C: Customers){
        if(C.getID() == ID){
            return C;
        }
    }
    IO.println("Customer not found.");
    return null;

}
private void FlagVehicleForMaintenance() {
    Vehicle V = NeedsID();
    if(V != null)
        V.flag();
}

private void SearchForVehicle(int id) {
    for (Vehicle V : Vehicles) {
        if (V.getVID() == id) {
            V.displayInfo();
            return;
        }
    }
    IO.println("Vehicle not found.");
}

private void SearchForVehicle(String brand) {
    boolean found = false;
    for (Vehicle V : Vehicles) {
        if (V.getBrand().equalsIgnoreCase(brand)) {
            V.displayInfo();
            found = true;
        }
    }
    if (!found) {
        IO.println("No vehicles found for brand: " + brand);
    }
}

void AddNewVehicle(){
 IO.println("What year was the vehicle manufactured?");
    int manfYear = INPUT.nextInt();
    IO.println("What is the vehicle's brand?");
    String brand = INPUT.next();
    IO.println("What is the vehicle's model?");
    String model =  INPUT.next();
    IO.println("How much is the vehicle's daily rental price?");
    double dailyRentalPrice = INPUT.nextDouble();
    IO.println("is the Vehicle available for rental? (yes or no)");
    boolean status = INPUT.next().toLowerCase().equals("yes");
    IO.println("What type of Vehicle?");
    IO.println("1)\tCar\n2)\tMotorcycle\n3)\tTruck");
    switch (INPUT.nextInt()){
        case 1:
            CarAdder(manfYear,brand,model,dailyRentalPrice,status);
            break;
        case 2:
            MotorcycleAdder(manfYear,brand,model,dailyRentalPrice,status);
            break;
        case 3:
            TruckAdder(manfYear,brand,model,dailyRentalPrice,status);
            break;
        default:
            IO.println("invalid option");
    }

}

private void CarAdder(int manfYear, String brand, String model, double dailyRentalPrice, boolean status) {
IO.println("How many seats does your car have?");
int seats = INPUT.nextInt();
IO.println("What is the transmission type?");
String transmissionType = INPUT.next();
Vehicles.add(new Car(manfYear,brand,model,dailyRentalPrice,status,transmissionType,seats));
    IO.println("Added your car successfully");
}

void MotorcycleAdder(int manfYear, String brand, String model, double dailyRentalPrice,boolean status){
    IO.println("What is the Engine's Capacity?");
    int EC = INPUT.nextInt();
    Vehicles.add(new MotorCycle(manfYear,brand,model,dailyRentalPrice,status, EC));
    IO.println("Added your MotorCycle successfully");
}
void TruckAdder(int manfYear, String brand, String model, double dailyRentalPrice,boolean status){
    IO.println("What is the Maximum Load Capacity?");
    int MLC = INPUT.nextInt();
    Vehicles.add(new Truck(manfYear,brand,model,dailyRentalPrice,status,MLC));
    IO.println("Added your Truck successfully");
}