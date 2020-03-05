class arrayExercise4{
    public static void main(String[] args){
        int no4[] = {1,5,20,3,4,1,5,12,4,5,23};
        int result = 0;

        for(int i = 0; i < no4.length; i++){
            result = result + no4[i];
        }
        System.out.println(result);
    }
}