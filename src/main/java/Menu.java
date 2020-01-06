import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void OpcaoGeral(List<String> entrada) throws ParseException {
        Hotel h = new Hotel();
        entrada.remove(0);
        for (String e: entrada) {
            String resposta = h.sharedHotel(e);
            System.out.println(resposta);
        }

    }

    public static void main(String pathArquivo)  {
       List<String> entrada = Arquivo.lerTexto(pathArquivo);
       try {
           OpcaoGeral(entrada);
       } catch (Exception e) {
           e.printStackTrace();
       }

    }
}
