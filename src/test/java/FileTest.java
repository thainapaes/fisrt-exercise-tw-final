import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FileTest {

    @Test
    public void testWhenFileIsCorrect() throws ParseException {
        File a = new File();
        //given
        String input = "arquivoCorreto.txt";

        //when
        List<String> resultHotel = a.readText(input);
        System.out.println(resultHotel);

        //then
        //esse retorno vai de acordo com o que é colocado no arquivo
        assertNotEquals(resultHotel, "Regular: 10Jan2020, 11Jan2020, 12Jan2020, 13Jan2020");
    }

    @Test
    public void testWhenFileIsInCorrect() throws ParseException {
        File a = new File();
        //given
        String input = "arquivoTeste.txt";

        //when
        List<String> resultHotel = a.readText(input);
        System.out.println(resultHotel);

        //then
        assertNotEquals(resultHotel, "The file format is incorrect try another!");
    }


    @Test
    public void testWhenFileIsEmpty() throws ParseException {
        File a = new File();
        //given
        String input = "";
        List<String> listEmpty = new ArrayList<>();

        //when
        List<String> resultHotel = a.readText(input);
        System.out.println(resultHotel);

        //then
        assertEquals(resultHotel, listEmpty);
    }
}
