import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void SelectHotel(List<String> inputFile) throws ParseException {
        Hotel h = new Hotel();
        inputFile.remove(0);
        for (String e: inputFile) {
            String result = h.searchHotel(e);
            System.out.println(result);
        }

    }

    public static void main(String pathFile)  {
       List<String> inputFile = Arquivo.readText(pathFile);
       try {
           SelectHotel(inputFile);
       } catch (Exception e) {
           e.printStackTrace();
       }

    }
}
