import org.junit.Ignore;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ArquivoTest {

    @Test
    public void testArquivo() throws ParseException {
        Arquivo a = new Arquivo();
        //given
        String input = "arquivoTeste.txt";

        //when
        List<String> resultHotel = a.lerTexto(input);
        System.out.println(resultHotel);

        //then
        assertNotEquals(resultHotel, "teste");
    }

    @Test
    public void testWhenArquivoIsEmpty() throws ParseException {
        Arquivo a = new Arquivo();
        //given
        String input = "";
        List<String> listEmpty = new ArrayList<>();

        //when
        List<String> resultHotel = a.lerTexto(input);
        System.out.println(resultHotel);

        //then
        assertEquals(resultHotel, listEmpty);
    }
}
