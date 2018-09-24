import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class schoolSearch
{
   public static void main(String[] args)
   {
      File file = new File("students.txt");
      String array[] = new String[8];
      List<String[]> twoArr = new ArrayList<String[]>();
      int x=0;

     /* for (int x = 1; x <= 4; x++)
      {
          twoArr.add(new int[] {x, x+1, x+2});        
          twoArr.add(new int[] {x, x+1, x+2});
          twoArr.add(new int[] {x, x+1, x+2});
      }*/

      /*for (int[] thang : twoArr)
      {
         System.out.println("Row = " + Arrays.toString(thang));
      }
*/
      try {
      Scanner scanner = new Scanner(file);
      scanner.useDelimiter("\n");

      while (scanner.hasNext()) {
         String[] values = scanner.next().split(",");
         System.out.println(values[0]);
         twoArr.add(values);
      }
      scanner.close();
      }
      catch (FileNotFoundException e) {
         e.printStackTrace();
      }


   }
}

