import java.text.ParseException;
import java.util.List;

public class Menu {

    public static void SelectHotel() throws ParseException {
        List<String> inputFile = File.readText("arquivoCorreto.txt");
        Hotel h = new Hotel();
        inputFile.remove(0);
        for (String e: inputFile) {
            String result = h.searchHotel(e);
            System.out.println(result);
        }

    }

    public static void main(String[] args)  {
        try {
            SelectHotel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
