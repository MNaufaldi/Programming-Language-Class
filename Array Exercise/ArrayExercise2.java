import java.util.Arrays;
import java.util.Scanner;

class arrayExercise2{
    public static void main(String[]args){
        Scanner myObj = new Scanner(System.in);
        // 1.
        int no2[] = new int[10];
        for(int i=0; i<10; i++){
            System.out.println("Input an integer["+(i+1)+"]: ");
            int tmp = myObj.nextInt();
            no2[i] = tmp;
        }
        
        System.out.println("Enter an integer: ");
        int tmp = myObj.nextInt();

        Arrays.sort(no2);
        if(Arrays.binarySearch(no2, tmp)>0){
            System.out.println(tmp+" Exist in the array");
        }
        else{
            System.out.println(tmp+" Not found");
        }
        
        myObj.close();
    }
}