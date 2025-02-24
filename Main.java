class Vehicle {
    String registrationNumber;
    String color;
    String type;

    Vehicle(String registrationNumber, String color) {
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    public String getColor() {
        return this.color;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}

class Car extends Vehicle {
    Car(String registrationNumber, String color) {
        super(registrationNumber, color);
        this.type = "Car";
    }

    // car vehicle functinoality
}

class Motorcycle extends Vehicle {
    Motorcycle(String registrationNumber, String color) {
        super(registrationNumber, color);
        this.type = "Motorcycle";
    }

    // motorcycle vehicle functionality
}

class Truck extends Vehicle {
    Truck(String registrationNumber, String color) {
        super(registrationNumber, color);
        this.type = "Truck";
    }

    // truck vehicle functionality
}

/* Slots in floor */
class Slot {
    int slotNumber;
    Vehicle vehicle;

    Slot(int slotNumber, Vehicle vehicle) {
        this.slotNumber = slotNumber;
        this.vehicle = vehicle;
    }

    public int getSlotNumber() {
        return this.slotNumber;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}

class Floor {
    int floorNumber;
    Slot[] slots;

    Floor(int floorNumber, int numberOfSlots) {
        this.floorNumber = floorNumber;
        this.slots = new Slot[numberOfSlots];
        for (int i = 0; i < numberOfSlots; i++) {
            this.slots[i] = new Slot(i + 1, null);
        }
    }

    public int getFloorNumber() {
        return this.floorNumber;
    }

    public Slot[] getSlots() {
        return this.slots;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void setSlots(Slot[] slots) {
        this.slots = slots;
    }
}

// ParkingLot Service
class ParkingLot {
    int numberOfFloors;
    Floor[] floors;

    ParkingLot(int numberOfFloors, int numberOfSlots) {
        this.numberOfFloors = numberOfFloors;
        this.floors = new Floor[numberOfFloors];
        for (int i = 0; i < numberOfFloors; i++) {
            this.floors[i] = new Floor(i + 1, numberOfSlots);
        }
    }

    public void park(Vehicle vehicle) {

        for (int i = 0; i < this.numberOfFloors; i++) {
            for (int j = 0; j < this.floors[i].slots.length; j++) {
                if (this.floors[i].slots[j].vehicle == null) {
                    this.floors[i].slots[j].vehicle = vehicle;
                    System.out.println("Allocated slot number: " + this.floors[i].slots[j].slotNumber);
                    System.out.println("********************************************************************\n");
                    return;
                }
            }
        }
        System.out.println("Sorry, parking lot is full");
        System.out.println("********************************************************************\n");
    }

    public void leave(int slotNumber) {

        for (int i = 0; i < this.numberOfFloors; i++) {
            for (int j = 0; j < this.floors[i].slots.length; j++) {
                if (this.floors[i].slots[j].slotNumber == slotNumber) {
                    this.floors[i].slots[j].vehicle = null;
                    System.out.println("Slot number " + slotNumber + " is free");
                    System.out.println("********************************************************************\n");
                    return;
                }
            }
        }
        System.out.println("Slot number " + slotNumber + " is already empty");
        System.out.println("********************************************************************\n");
    }

    public void status() {

        System.out.println("Slot No.\tRegistration No\tColor");
        for (int i = 0; i < this.numberOfFloors; i++) {
            for (int j = 0; j < this.floors[i].slots.length; j++) {
                if (this.floors[i].slots[j].vehicle != null) {
                    System.out.println(this.floors[i].slots[j].slotNumber + "\t"
                            + this.floors[i].slots[j].vehicle.registrationNumber + "\t"
                            + this.floors[i].slots[j].vehicle.color);
                }
            }
        }
        System.out.println();
        System.out.println("********************************************************************\n");
    }

    public void getRegistrationNumbersForCarsWithColour(String color) {

        for (int i = 0; i < this.numberOfFloors; i++) {
            for (int j = 0; j < this.floors[i].slots.length; j++) {
                if (this.floors[i].slots[j].vehicle != null && this.floors[i].slots[j].vehicle.color.equals(color)) {
                    System.out.print(this.floors[i].slots[j].vehicle.registrationNumber + ", ");
                }
            }
        }
        
        System.out.println();
        System.out.println("********************************************************************\n");
    }

    public void getSlotNumbersForCarsWithColour(String color) {

        for (int i = 0; i < this.numberOfFloors; i++) {
            for (int j = 0; j < this.floors[i].slots.length; j++) {
                if (this.floors[i].slots[j].vehicle != null && this.floors[i].slots[j].vehicle.color.equals(color)) {
                    System.out.print(this.floors[i].slots[j].slotNumber + ", ");
                }
            }
        }
        System.out.println();
        System.out.println("********************************************************************\n");
        
    }

    public void getSlotNumberForRegistrationNumber(String registrationNumber) {

        for (int i = 0; i < this.numberOfFloors; i++) {
            for (int j = 0; j < this.floors[i].slots.length; j++) {
                if (this.floors[i].slots[j].vehicle != null
                        && this.floors[i].slots[j].vehicle.registrationNumber.equals(registrationNumber)) {
                    System.out.println(this.floors[i].slots[j].slotNumber);
                    System.out.println("********************************************************************");
                    return;
                }
            }
        }
        System.out.println("Not found");
        System.out.println("********************************************************************\n");
    }

}

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(3, 5);
        parkingLot.park(new Car("KA-01-HH-1234", "White"));
        parkingLot.park(new Car("KA-01-HH-9999", "White"));
        parkingLot.park(new Car("KA-01-BB-0001", "Black"));
        parkingLot.park(new Car("KA-01-HH-7777", "Red"));
        parkingLot.park(new Car("KA-01-HH-2701", "Blue"));
        parkingLot.park(new Car("KA-01-HH-3141", "Black"));
        parkingLot.leave(4);
        parkingLot.status();
        parkingLot.park(new Motorcycle("KA-01-HH-1234", "White"));
        parkingLot.park(new Motorcycle("KA-01-HH-9999", "White"));
        parkingLot.park(new Motorcycle("KA-01-BB-0001", "Black"));
        parkingLot.park(new Motorcycle("KA-01-HH-7777", "Red"));
        parkingLot.park(new Motorcycle("KA-01-HH-2701", "Blue"));
        parkingLot.park(new Motorcycle("KA-01-HH-3141", "Black"));
        parkingLot.leave(4);
        parkingLot.status();
        parkingLot.getRegistrationNumbersForCarsWithColour("White");
        parkingLot.getSlotNumbersForCarsWithColour("White");
        parkingLot.getSlotNumberForRegistrationNumber("KA-01-HH-3141");
    }
}
