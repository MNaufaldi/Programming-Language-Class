import java.util.ArrayList;
public class Driver{
    public static void main(String[] args){
        ArrayList<PoliceCar> popos = new ArrayList<PoliceCar>();
        PoliceCar popo1 = new PoliceCar("Poo",5,120,4);
        popos.add(popo1);
        popos.get(0).askPullover();
        // i have no idea what you mean by adding it to a list... like what type so ill make 2 list
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        vehicles.add(popo1);
    }
}