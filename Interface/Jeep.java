public class Jeep extends Vehicle implements LandVehicle {
    Jeep(){
    }
    Jeep(String name, int maxPassengers, int maxSpeed, int numWheels){
        super(name,maxPassengers,maxSpeed);
        super.setNumWheels(numWheels);
    }
    public void soundHorn(){
        System.out.println("Bonk");
    }
    
    @Override
    public void drive(){
        System.out.println("Vroom");
    }
}