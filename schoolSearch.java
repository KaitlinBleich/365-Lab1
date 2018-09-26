import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.lang.*;

public class schoolSearch {
    private static void switchStatement(String[] array, String[][] data, int line)
    {
                           String fName = "";
                           String lName = "";
                           String GPA   = "";  
                           String teach = "";
                           String bus   = "";  
       /*System.out.println(array[0]);
       System.out.println(array[1]);
       System.out.println(array[0].equals("S"));
       System.out.println();*/
        switch (array[0]) {
           case "S":
           case "Student":
                for (int i = 0; i < line; i++) {
                    if (array[1].equals(data[i][0])) {
                        System.out.print(data[i][0] + ", "+ data[i][1] + ", ");
                        if(array.length == 3)
                        {
                            if(array[2].equals("B") || array[2].equals("Bus"))
                                System.out.print(data[i][4] + "\n");
                        }
                        else {
                            System.out.println(data[i][2]+ ", "+ data[i][3] +", "+ data[i][7] + " " + data[i][6]);
                        }
                    }
                }
                break;
            case "T":
            case "Teacher":
                for (int i = 0; i < line; i++) {
                    if (array[1].equals(data[i][6])) {
                        System.out.println(data[i][0] + ", " + data[i][1]);
                    }
                }
                break;
            case "B":
            case "Bus":
                for (int i = 0; i < line; i++) {
                    if (array[1].equals(data[i][4])) {
                        System.out.println(data[i][1] + " " + data[i][0]);
                    }
                }
                break;
            case "G":
            case "Grade":
                double high = 0;
                double low  = 0;
                if(array.length == 3)
                {
                    if(Integer.parseInt(array[1]) > 6)
                        break;
                   if(array[2].equals("H") || array[2].equals("High"))
                   {
                     for (int l = 0; l < line; l++) {
                        if (Double.parseDouble(data[l][5]) > high && /*greatest GPA */
                              array[1].equals(data[l][2]))           /* with given score*/
                        {
                        /*System.out.println("---NEW---");
                        System.out.println(high);
                        System.out.println(data[l][0]);
                        System.out.println(data[l][5]);
                        System.out.println("-------------");*/
                           fName = data[l][1];
                           lName = data[l][0];
                           GPA   = data[l][5];
                           teach = data[l][6];
                           bus   = data[l][4];

                           high = Double.parseDouble(data[l][5]);

                        }
                        /*if (array[1].equals(data[i][2])) {
                           System.out.println("LastName:\t" + data[i][0]);
                           System.out.println("FirstName:\t" + data[i][1]);*/
                     }
                     System.out.println(fName + " " + lName + ", " + GPA + ", "
                           + teach + ", " + bus);
                  }
                  else if(array[2].equals("L") || array[2].equals("Low"))
                  {
                     for (int l = 0; l < line; l++) {
                        /*System.out.println("comparing: " + data[l][2] + 
                              " and " + array[1]+ array[1].equals(data[l][2]));*/
                        if(array[1].equals(data[l][2]) && low == 0) 
                        {low = Double.parseDouble(data[l][5]);}

                     if (Double.parseDouble(data[l][5]) <= low && /*greatest GPA */
                           array[1].equals(data[l][2]))           /* with given score*/
                     {
                        /*System.out.println("---NEW---");
                        System.out.println(low);
                        System.out.println(data[l][0]);
                        System.out.println(data[l][5]);
                        System.out.println("-------------");*/
                           fName = data[l][1];
                           lName = data[l][0];
                           GPA   = data[l][5];
                           teach = data[l][6];
                           bus   = data[l][4];

                           low = Double.parseDouble(data[l][5]);

                        }
                        /*if (array[1].equals(data[i][2])) {
                           System.out.println("LastName:\t" + data[i][0]);
                           System.out.println("FirstName:\t" + data[i][1]);*/
                     }
                     System.out.println(fName + " " + lName + ", " + GPA + ", "
                           + teach + ", " + bus);
                  }

               }
                else{
                for (int i = 0; i < line; i++) {
                    if (array[1].equals(data[i][2])) {
                        System.out.println("LastName:\t" + data[i][0]);
                        System.out.println("FirstName:\t" + data[i][1]);
                    }
                }
                }
                break;
            case "A":
            case "Average":
            double sum = 0;
            int count = 0;
               for (int i = 0; i < line; i++)
               {
                  if(array[1].equals(data[i][2]))
                  {
                        /*System.out.println("---NEW---");
                        System.out.println(data[i][0]);
                        System.out.println(data[i][5]);
                        System.out.println("-------------");*/
                     sum += Double.parseDouble(data[i][5]);
                     count++;
                  }
               }
               System.out.println(array[1] + " - Average is: " + sum/count);
                break;
            case "I":
            case "Info":
                if(array.length != 1)
                    break;
                for (int i = 0; i<=6; i++)
                {
                   int students = 0;
                   for (int j = 0; j < line; j++)
                   {
                     if(i == Integer.parseInt(data[j][2]))
                     {
                        students++;
                     } 
                   }
                   System.out.println(i + ": " + students);
                }
                break;
            default:
        }
    }

    public static void main(String[] args) throws Exception {

        File file = new File("students.txt");
        if(!file.exists())
        {
            System.out.println("FIle not exists.");
            System.exit(1);
        }

        String[][] myData = new String[1000][8];
        Scanner Read = new Scanner(file);
        String myLine;
        int line = 0;

        // putting it in 2d array
        while (Read.hasNextLine()) {
            String[] array1 = Read.nextLine().split(",");
            for (int i = 0; i < array1.length; i++) {
                myData[line][i] = array1[i];
            }
            line++;
        }

        // start of the loop
        System.out.println("Enter command ");
        Scanner input = new Scanner(System.in);
        String in = "start";

        while (!in.equals("Q") && !in.equals("Quit")){
            in = input.nextLine();

            if(in.equals("Q") || in.equals("Quit"))
                break;

            String[] array2 = in.split(": | ");

            switchStatement(array2, myData, line);
        }
    }
}
