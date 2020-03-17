import java.util.Arrays;

class arrayExercise6{
    public static void main(String args[]){
       
        int same[] = {1,2,3,4,5,4,3,2,1};

        for(int i = 0; i < same.length; i++){
            if(same[i] == same[same.length-i-1]){
                if(same[i] == same[same.length-1]){
                    System.out.println("True");
                    break;
                }
                continue;
            }
            else{
                System.out.println("False");
                break;
            }
            
        }
        
    }
    
}