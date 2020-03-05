import java.util.Arrays;
import java.util.Scanner;


class arrayExercise{
    public static void main(String[]args){
        Scanner myObj = new Scanner(System.in);
        // 1.
        int no1[] = new int[10];
        for(int i=0; i<10; i++){
            System.out.println("Input an integer["+(i+1)+"]: ");
            int tmp = myObj.nextInt();
            no1[i] = tmp;
        }
        System.out.println(Arrays.toString(no1));
        
    }
}