import org.junit.Ignore;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.*;

public class HotelTest {

    public Hotel h = new Hotel();

    @Ignore
    @Test
   public void testThatFails() {
       assertTrue("This should fail", false);
   }

    @Ignore
    @Test
    public void testThatWork() {
        assertTrue("This should Work", true);
    }


    @Test
    @Ignore
    public void testWhenInputIsEmpty() throws ParseException {
        //given
        String input = "";

        //when
        String resultHotel = h.sharedHotel(input);

        //then
        assertEquals(resultHotel, null);
    }

    @Test
    @Ignore
    //ok
    public void testWhenIsBridgewood() throws ParseException {
        //given
        //Regular: 20Mar2009(fri), 21Mar2009(sat), 22Mar2009(sun)
        String input = "Regular: 20Mar2009, 21Mar2009, 22Mar2009";

        //when
        String resultHotel = h.sharedHotel(input);
        System.out.println(resultHotel);

        //then
        assertEquals(resultHotel, "Bridgewood");
    }

    @Test
    @Ignore
    //ok
    public void testWhenIsLakewood() throws ParseException {
        //given
        //Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)
        String input = "Regular: 16Mar2009, 17Mar2009, 18Mar2009";

        //when
        String resultHotel = h.sharedHotel(input);
        System.out.println(resultHotel);

        //then
        assertEquals(resultHotel, "Lakewood");
    }

    @Test
    @Ignore
    //ok
    public void testWhenIsRidgewood() throws ParseException {
        //given
        //Rewards: 26Mar2009(thur), 27Mar2009(fri), 28Mar2009(sat)
        String input = "Rewards: 26Mar2009, 27Mar2009, 28Mar2009";

        //when
        String resultHotel = h.sharedHotel(input);
        System.out.println(resultHotel);

        //then
        assertEquals(resultHotel, "Ridgewood");
    }

    @Test
    public void mesEntregue() throws ParseException {
        //given
        String diaEscolhido = "20/03/2009";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date ontem = sdf.parse(diaEscolhido);
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(ontem);
        int diaDaSemana = gc.get(GregorianCalendar.DAY_OF_WEEK);
        assertEquals(diaDaSemana, 2);
    }

    @Test
    public void soma() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> novo = new ArrayList<>();
        Integer sum = integers.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);
        integers.forEach(integer -> {
            novo.add( integer += integer);
        });
        List<Integer> n = Arrays.asList(290, 280, 520);
        System.out.println(n.stream().min(Integer::compare).get());
    }

    @Test
    @Ignore
    //ok
    public void testValor() throws ParseException {
        //given
        int[] a = new int[3];
        a[0] = 6;
        a[1] = 7;
        a[2] = 1;
        String input = "Regular: 20Mar2009, 21Mar2009, 22Mar2009";
        List<Integer> priceW = Arrays.asList(110, 160, 220);
        List<Integer> priceWnd = Arrays.asList(90, 60, 150);
        //when
        List<Integer> resultHotel = h.precosAtt(a, priceW, priceWnd);
        System.out.println(resultHotel);

        //then
        //assertEquals(resultHotel, "Bridgewood");

    }

    @Test
    @Ignore
    //ok
    public void testHotel() throws ParseException {
        //given
        //List<Integer> resultT = Arrays.asList(290, 280, 520);
        //List<Integer> resultT = Arrays.asList(240, 270, 240);
        //List<Integer> resultT = Arrays.asList(280, 290, 520);
        List<Integer> resultT = Arrays.asList(280, 280, 120);

        //when
        String resultHotel = h.qualHotel(resultT);
        System.out.println(resultHotel);

        //then
        assertEquals(resultHotel, "Bridgewood");
    }


}
