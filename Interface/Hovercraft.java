public class Hovercraft extends Vehicle implements SeaVessel,LandVehicle {
    Hovercraft(){

    }
    Hovercraft(String name, int maxPassengers, int maxSpeed, int displacement, int numWheels){
        super(name,maxPassengers,maxSpeed);
        super.setDisplacement(displacement);
        super.setNumWheels(numWheels);
    }
    public void enterLand(){
        System.out.println("Is now on land");
    }
    public void enterSea(){
        System.out.println("Is unda da sea");
    }
    @Override
    public void launch(){
        System.out.println("Whoosh");
    }
    public void drive(){
        System.out.println("Vroom");
    }
}