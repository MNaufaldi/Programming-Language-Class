import java.util.Arrays;
import java.util.Scanner;

public class Utility{
    Scanner ask = new Scanner(System.in);

    public void number1(){
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
        //System.out.println(max);
        //System.out.println(max2);
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

    public void number2(){
        int no9[] = {1,2,3,4,5};
        
        
        System.out.println("How many ROT? ");
        int k = ask.nextInt();
        
        for(int j = 0; j < k; j++ ){
            int last = no9[no9.length-1];
            for(int i=no9.length; i > 0;i--){
                
                if((i-1)==0){
                    no9[0] = last;
                }
                else{   
                no9[i-1] = no9[i-2];

                }
            }
        }
        System.out.println(Arrays.toString(no9));
        
    }

    public void number3(){
        //for testing purposes
        int[][] mat = { {1,2,3},
                        {2,4,5},
                        {3,5,1}};

        //
        
        for(int i = 0;i < mat[0].length;i++){
            if(i == 0){
                continue;
            }
            else if(i == mat[0].length - 1){
                System.out.println("Symmetric");
                break;
            }
            else if(i == 1){
                //check
                if(mat[0][i] == mat[i][0]){
                    continue;
                }
                else{
                    System.out.println("Not Symmetric");
                    break;
                }
            }
            else if(i > 1){
                //check
                for(int j = 0; j < mat[0].length; j++){
                    if(mat[j][i] == mat[i][j]){
                        continue;
                    }
                    else{
                        System.out.println("Not Symmetric");
                        break;
                    }
                }

                if(i == mat[0].length - 1){
                    System.out.println("Symmetric");
                    break;
                }
            }
        }
    }

    public void number4(){
        //Odd numbers
        //Up one right one pattern -wikihow
        int coordsC = 0;
        int coordsR = 0;
        int tempR = 0;
        int tempC = 0;
        System.out.println("Please input the size of the matrix[Odd numbers only]: ");
     
        int size = ask.nextInt();
        while(size % 2 == 0){
            System.out.println("Please input the size of the matrix[Odd numbers only]: ");
             size = ask.nextInt();
        }

       
        //Create matrix
        int [][] magic = new int[size][size];
        //The magic constant = n[(n^2+1)/2]
        int Mconstant = size*((size*size+1)/2);
        //All row and diagonal = magic constant
        
        //Up one right one starts from mid top
        for(int i=0;i < size * size;i++){
            //First number mid top
            if(i == 0){
                coordsC = size/2;
                coordsR = 0;
                tempR = coordsR;
                tempC = coordsC;
            }
            else{
                coordsR = coordsR - 1;
                coordsC = coordsC + 1;
                
                if(coordsR < 0 && coordsC > size - 1){
                     coordsR = size -1;
                     coordsC = 0;
                }
                else if(coordsC > size - 1){
                    coordsC = 0;
                }
                else if(coordsR < 0 ){
                    coordsR = size-1;
                }  
            }
            if(magic[coordsR][coordsC] == 0){
                magic[coordsR][coordsC] = i + 1;
                tempR = coordsR;
                tempC = coordsC;
            }
            else{
                magic[tempR+1][tempC] = i+1;
                coordsR = tempR+1;
                coordsC = tempC;
                
            }
        }
        for (int i = 0; i < magic.length; i++) {
            for (int j = 0; j < magic[i].length; j++) {
                System.out.print(magic[i][j] + " ");
            }
            System.out.println();
        }
        ask.close();
    }
    
}
