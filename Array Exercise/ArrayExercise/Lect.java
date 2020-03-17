package ArrayExercise;
public class Lect {
    public int getHighIndex(final int arr[],final int n){
        /**
         * @param array
         * aaaa
         */
        int index = 0;
        int high = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > high){
                high = arr[i];
                index = i;
            }
            else{
                continue;
            }
        }
        return index;
    }
}