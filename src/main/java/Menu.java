import java.text.ParseException;
import java.util.List;

public class Menu {

    public static void SelectHotel(List<String> inputFile) throws ParseException {
        Hotel h = new Hotel();
        inputFile.remove(0);
        for (String e: inputFile) {
            String result = h.searchHotel(e);
            System.out.println(result);
        }

    }

    public static boolean main(String pathFile)  {
       List<String> inputFile = File.readText(pathFile);
       try {
           SelectHotel(inputFile);
           return true;
       } catch (Exception e) {
           e.printStackTrace();
           return false;
       }

    }
}
