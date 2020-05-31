public class PoliceCar extends Vehicle implements LandVehicle,IsEmergency {
    PoliceCar(){

    }
    PoliceCar(String name, int maxPassengers, int maxSpeed, int numWheels){
        super(name,maxPassengers,maxSpeed);
        super.setNumWheels(numWheels);
    }
    public void askPullover(){
        System.out.println("Please pullover");
    }
    @Override
    public void drive(){
        System.out.println("Vroom");
    }
    public void soundSiren(){
        System.out.println("NINUNINU");
    }
}