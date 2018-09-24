import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class schoolsearch {

    private static void switchStatement(String[] array, String[][] data, int line)
    {
        switch (array[0]) {
            case "S":
            case "Student":
                for (int i = 0; i < line; i++) {
                    if (array[1].equals(data[i][0])) {
                        System.out.println("LastName:\t" + data[i][0]);
                        System.out.println("FirstName:\t" + data[i][1]);
                        if(array.length == 3)
                        {
                            if(array[2].equals("B") || array[2].equals("Bus"))
                                System.out.println("BusRoute:\t" + data[i][4]);
                        }
                        else {
                            System.out.println("Grade:\t\t" + data[i][2]);
                            System.out.println("Classroom:\t" + data[i][3]);
                            System.out.println("Teacher:\t" + data[i][7] + " " + data[i][6]);
                        }
                    }
                }
                break;
            case "T":
            case "Teacher":
                break;
            case "B":
            case "Bus":
                break;
            case "G":
            case "Grade":
                break;
            case "A":
            case "Average":
                break;
            case "I":
            case "Info":
                break;
            default:
        }
    }

    private static void search()
    {

    }

    public static void main(String[] args) throws Exception {
        FileReader file = new FileReader("students.txt");

        String[][] myData = new String[1000][8];
        BufferedReader bufRead = new BufferedReader(file);
        String myLine = null;
        int line = 0;

        // putting it in 2d array
        while ((myLine = bufRead.readLine()) != null) {
            String[] array1 = myLine.split(",");
            for (int i = 0; i < array1.length; i++) {
                myData[line][i] = array1[i];
            }
            line++;
        }

        // start of the loop
        System.out.println("Enter whatever ");
        Scanner input = new Scanner(System.in);
        String in = "start";

        while (!in.equals("Q") && !in.equals("Quit")){
            in = input.nextLine();

            if(in.equals("Q") || in.equals("Quit"))
                break;

            String[] array2 = in.split(": | ");

            switchStatement(array2, myData, line);


//            // this is student first and bus option.
//            if((array2[0].equals("S") || array2[0].equals("Student")) && (array3[1].equals("B") || array3[1].equals("Bus")))
//            {
//                for (int i = 0; i < line; i++) {
//                    if (array3[0].equals(myData[i][0])) {
//                        System.out.println("LastName " + myData[i][0]);
//                        System.out.println("FirstName " + myData[i][1]);
//                        System.out.println("BusRoute " + myData[i][4]);
//                    }
//                }
//            }
//            else {
//                switchStatement(array2[0], myData, line);
//            }
        }
    }
}