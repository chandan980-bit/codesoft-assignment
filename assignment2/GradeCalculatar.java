import java.util.*;
public class GradeCalculatar {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Student : ");
        int a = sc.nextInt();
        System.out.print("Enter Total no of subject : ");
        int b = sc.nextInt();
        double total;
        for(int i= 1;i<=a;i++){             //Student
            total = 0;
            for(int j=1;j<=b;j++){          //Subject
                System.out.println();
                System.out.print(j+"th Mark is : ");
                double n = sc.nextDouble();
                System.out.println();
                System.out.println(i +"th students " + j + "th subject "+" mark is "+n);
                total = total + n;
            }
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - -");
            System.out.println("* * * * * *         "+i+"th STUDENT      * * * * * * ");
            System.out.println();
            System.out.println();
            System.out.println("Total Mark is "+ total );
            double percent =(total/(b*100)) * 100;   
            System.out.println("Total Percentage is : "+percent);
            if(percent >30 && percent <= 50){
                System.out.println("GRADE - E");
            }else if(percent >50 && percent <= 60){
                System.out.println("GRADE - D");
            }
            else if(percent >60 && percent <= 70){
                System.out.println("GRADE - C");
            }
            else if(percent >70 && percent <= 80){
                System.out.println("GRADE - B");
            }
            else if(percent >80 && percent <= 90){
                System.out.println("GRADE - A");
            }
            else if(percent >90 && percent <= 100){
                System.out.println("GRADE - O");
            }
            else{
                System.out.println("Fail");
            }
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - -");
        }

        sc.close();
    }
}
