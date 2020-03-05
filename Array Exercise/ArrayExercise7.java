import java.util.Arrays;


class arrayExercise7{
    public static void main(String[] args){
        int no7[] = {1,2,3,4,5,6,7,8,9,10};
        int no7temp[] = new int[no7.length/2];
        int no7temp2[] = new int[no7.length/2];
        for(int i =0; i < no7.length/2; i++){
            no7temp[i] = no7[no7.length/2 + i];
            no7temp2[i] = no7[i];

        }
        System.out.print(Arrays.toString(no7temp2));
        System.out.print(Arrays.toString(no7temp));
    }
}