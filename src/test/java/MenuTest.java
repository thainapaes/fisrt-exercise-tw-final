import org.junit.Test;

import java.text.ParseException;

public class MenuTest {
    @Test
    public void testIncorrectFile() throws ParseException {
        Menu m = new Menu();

        //given
        String input = "arquivoTeste.txt";

        //when
        m.main(input);

        //then
        //assertEquals(resultHotel, "The file format is incorrect try another!");
    }

    @Test
    public void testCorrectFile() throws ParseException {
        Menu m = new Menu();

        //given
        String input = "arquivoCorreto.txt";

        //when
        m.main(input);

        //then
        //assertNotEquals(resultHotel, "teste");
    }
}
