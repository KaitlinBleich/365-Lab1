import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class schoolsearch {

    private static void switchStatement(String specifier)
    {
        switch (specifier) {
            case "S":
            case "Student":
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

        while ((myLine = bufRead.readLine()) != null) {
            String[] array1 = myLine.split(",");
            for (int i = 0; i < array1.length; i++) {
                myData[line][i] = array1[i];
            }
            line++;
        }
        System.out.println(line);
        for (int i = 0; i < line; i++) {
            String name = new String("NANCY");
            if(name.equals(myData[i][7]))
                System.out.println(myData[i][0]);
        }

        System.out.println("Enter whatever ");
        Scanner input = new Scanner(System.in);
        String in = "start";
        while (!in.equals("Q") && !in.equals("Quit")){
            in = input.nextLine();
            if(in.equals("Q") || in.equals("Quit"))
                break;

            String[] array2 = in.split(": ");
            String[] array3 = new String[2];
            System.out.println(array3[1]);
            array3 = array2[1].split(" ");
            System.out.println(array3[1]);

            if(array3[1] != null && (array3[1].equals("B") || array3[1].equals("Bus")))
            {
                for (int i = 0; i < line; i++) {
                    if (array3[0].equals(myData[i][0])) {
                        System.out.println("LastName " + myData[i][0]);
                        System.out.println("FirstName " + myData[i][1]);
                        System.out.println("BusRoute " + myData[i][4]);
                    }
                }
            }

            for (int i = 0; i < line; i++) {
                if (array2[1].equals(myData[i][1]))
                    System.out.println(myData[i][0]);
            }
        }
    }
}