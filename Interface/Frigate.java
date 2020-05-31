public class Frigate extends Vehicle implements SeaVessel {
    Frigate(){

    }
    Frigate(String name, int maxPassengers, int maxSpeed, int displacement){
        super(name,maxPassengers,maxSpeed);
        super.setDisplacement(displacement);
    }
    public void fireGun(){
        System.out.println("Pap");
    }
    @Override
    public void launch(){
        System.out.println("Whoosh");
    }
}