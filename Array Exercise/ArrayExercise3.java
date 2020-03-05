import java.util.Arrays;
import java.util.Scanner;

class arrayExercise3{
    public static void main(String[]args){
        Scanner myObj = new Scanner(System.in);
        int no3[] = new int[20];
        int result[] = new int[5];

        for(int i = 0; i < 20; i++){
            System.out.println("Enter an integer["+(i+1)+"]: ");
            int tmp = myObj.nextInt();
            no3[i] = tmp;
            
        }
        
        for(int j = 0; j < no3.length; j++) {
                
            //Zero - 4
            if(no3[j] == 0){
                result[4] = result[4] + 1;
            }

            //Negative - 1
            else if(no3[j] < 0){
                result[1] = result[1] + 1;
                //Negative Even - 3
                if(no3[j] % 2 == 0 && no3[j] > 0){
                    result[3] = result[3] + 1;
                }
                //Negative Odd - 2
                else if(no3[j] % 2 != 0 && no3[j] > 0){
                    result[2] = result[2] + 1;
            }
            
        }
            //Positive - 0
            else if(no3[j] > 0){
                result[0] = result[0] + 1;
                //Positive Even - 3
                if(no3[j] % 2 == 0 && no3[j] > 0){
                    result[3] = result[3] + 1;
                }
                //Positive Odd - 2
                else if(no3[j] % 2 != 0 && no3[j] > 0){
                    result[2] = result[2] + 1;
            }

            }
            
        }
        System.out.println("Number of positive numbers: " + result[0]);
        System.out.println("Number of negative numbers: " + result[1]);
        System.out.println("Number of odd numbers: " + result[2]);
        System.out.println("Number of even numbers: " + result[3]);
        System.out.println("Number of zeros: " + result[4]);

    }
}