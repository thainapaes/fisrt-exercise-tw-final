import org.junit.Test;

import java.text.ParseException;
import static org.junit.Assert.*;

public class MenuTest {
    @Test
    public void testIncorrectFile() throws ParseException {
        Menu m = new Menu();

        //given
        String input = "arquivoIncorreto.txt";

        //when
        boolean resultBool = m.main(input);

        //then
        assertTrue(resultBool);
    }

    @Test
    public void testCorrectFile() throws ParseException {
        Menu m = new Menu();

        //given
        String input = "arquivoCorreto.txt";

        //when
        boolean resultBool = m.main(input);

        //then
        assertTrue(resultBool);
    }
}
