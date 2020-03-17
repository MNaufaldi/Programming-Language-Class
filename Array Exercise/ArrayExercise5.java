import java.util.Arrays;

class arrayExercise5{
    public static void main(String[] args){
        int no5[] = {1,5,20,3,4,1,5,12,4,5,23};
        Arrays.sort(no5);
        System.out.println("Max: "+no5[no5.length-1]);
        System.out.println("Min: "+no5[0]);
        
    }
}