import java.util.Arrays;

class arrayExercise8{
    public static void main(String[] args){
        int no8[] = {4,8,6,3,2};
        int copy[] = new int[no8.length+1];
        int max = 0;
        int max2 = 0;
        int k = 0;
        
        for(int i = 0; i < no8.length;i++){
            if(no8[i] > max){
                max = no8[i];
            }
            else if(no8[i] > max2 && no8[i] < max){
                max2 = no8[i];
            }

            }
        System.out.println(max);
        System.out.println(max2);
            for(int j = 0; j < no8.length+1;j++){
                
                if(no8[k] == max){
                    copy[j] = max2;
                    copy[j+1] = max - max2;
                    j++;
                }
                else{
                    copy[j] = no8[k];
                    
                }
                k++;

            }
        System.out.println(Arrays.toString(copy));

        }
    }
