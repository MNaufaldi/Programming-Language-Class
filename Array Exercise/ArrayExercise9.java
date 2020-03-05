import java.util.Arrays;
class arrayExercise9{
    public static void main(String[] args){
        int no9[] = {1,2,3,4,5};
        int last = no9[no9.length-1];
        for(int i=no9.length; i > 0;i--){
            
            if((i-1)==0){
                no9[0] = last;
            }
            else{   
               no9[i-1] = no9[i-2];

            }
        }
        System.out.println(Arrays.toString(no9));
    }
}