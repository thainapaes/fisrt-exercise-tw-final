import org.junit.Test;

import java.text.ParseException;

public class MenuTest {
    @Test
    public void testArquivoIncorreto() throws ParseException {
        Menu m = new Menu();

        //given
        String input = "arquivoTeste.txt";

        //when
        m.main(input);
        //System.out.println(resultHotel);

        //then
        //assertNotEquals(resultHotel, "teste");
    }

    @Test
    public void testArquivoCorreto() throws ParseException {
        Menu m = new Menu();

        //given
        String input = "arquivoCorreto.txt";

        //when
        m.main(input);
        //System.out.println(resultHotel);

        //then
        //assertNotEquals(resultHotel, "teste");
    }
}
