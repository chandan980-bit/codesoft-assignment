package assignment1;
// 1 . Generate a random number with in a specified range, Such as 1 to 100.

import java.util.*;

public class Range{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a = (int) (Math.random() * 100);         //Random number
        System.out.println("Write any number in between 1 to 100 .");
        int x = 1;
        try{
            while( x<= 100){
                System.out.println();
                System.out.println(" - - - - - - - - - -ROUND "+x + " - - - - - - - - - ");
                for(int i=1; i<=5; i++){
                    System.out.println();
                    System.out.print(i+"th Guess number is : ");
                    int b = sc.nextInt();
                    if(b == a){
                        System.out.println("Correct Guess .");
                        System.out.println();
                        System.out.println();
                        System.out.println(" * * *         CONGRATULATION        * * *");
                        System.out.println();
                        System.out.println();
                        System.out.println("Your Score is Round no : "+ x +" and Guess time is : "+i);
                        System.out.println();
                        System.out.println();
                        return;
                    }
                    else if(b < a){
                        System.out.println("Too Low Guess");
                    }
                    else{
                        System.out.println("Too High Guess");
                    }
                }
                x++;
            }
        }
        catch(Exception e){
            System.out.println("Invalid Number...");
        }
        finally {
            sc.close();
        }   
    }
}
