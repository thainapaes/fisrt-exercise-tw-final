import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Hotel {
    
    public String searchHotel(String info) throws ParseException {
        String answer;
        List<Integer> priceSet = new ArrayList<>();
        String[] infoS = info.split(":");
        if (infoS[0].equals("Regular")) {
            List<Integer> priceW = Arrays.asList(110, 160, 220);
            List<Integer> priceWnd = Arrays.asList(90, 60, 150);
            String[] dayS = infoS[1].split(",");
            priceSet = priceUpdate(dayOfWeek(dayS), priceW, priceWnd);
        } else if (infoS[0].equals("Rewards")) {
            List<Integer> priceW = Arrays.asList(80, 110, 100);
            List<Integer> priceWnd = Arrays.asList(80, 50, 40);
            String[] dayS = infoS[1].split(",");
            priceSet = priceUpdate(dayOfWeek(dayS), priceW, priceWnd);
        } else {
            answer = "The file format is incorrect try another!";
            return answer;
        }
        answer = whichHotel(priceSet);
        return answer;
    }
	
	/*
	    Nesse método é possível determinar quais são os dias da semana das datas selecionadas pelo cliente.
        A entrada é um String[] com os dias selecionados pelo cliente, que é tratado a partir de uma verificação onde é identificado
        qual foi o mês escolhido e com algumas modificações qual é o dia da semana desta data em questão.
        A saída é um int[] com a sequência dos dias selecionados, todos em ordem de entrada e de acordo com GregorianCalendar.DAY_OF_WEEK.
	*/

    private int[] dayOfWeek(String[] days) throws ParseException {
        int[] daysInHotel = new int[days.length];
		//interator para saber em qual posição está sendo utilizada no array
        int f = 0;
        for (String day : days) {
            String month = day.substring(3, 6);
            switch (month) {
                case "Jan":
                    day = day.replaceAll("Jan", "/01/");
                    break;
                case "Feb":
                    day = day.replaceAll("Feb", "/02/");
                    break;
                case "Mar":
                    day = day.replaceAll("Mar", "/03/");
                    break;
                case "Apr":
                    day = day.replaceAll("Apr", "/04/");
                    break;
                case "May":
                    day = day.replaceAll("May", "/05/");
                    break;
                case "Jun":
                    day = day.replaceAll("Jun", "/06/");
                    break;
                case "Jul":
                    day = day.replaceAll("Jul", "/07/");
                    break;
                case "Aug":
                    day = day.replaceAll("Aug", "/08/");
                    break;
                case "Sep":
                    day = day.replaceAll("Sep", "/09/");
                    break;
                case "Oct":
                    day = day.replaceAll("Oct", "/10/");
                    break;
                case "Nov":
                    day = day.replaceAll("Nov", "/11/");
                    break;
                case "Dec":
                    day = day.replaceAll("Dec", "/12/");
                    break;
                default:
                    System.out.println("Wrong month, try again.");
                    break;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dayParse = sdf.parse(day);
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(dayParse);
            int inTheWeek = gc.get(GregorianCalendar.DAY_OF_WEEK);
            daysInHotel[f] = inTheWeek;
            f++;
        }
        return daysInHotel;
    }

	/*
	    Esse método retorna qual é o melhor hotel para o cliente em questão.
        A entrada é um List com os preços já atualizados de acordo com a estádia desejada.
        Nesse método a ordem de hotéis foi respeitada de acordo com a suas classificações
        , por exemplo: 1. Lakewood (Nota: 3) 2. Bridgewood (Nota: 4) 3. Ridgewood (Nota: 5).
        A saída é qual é a melhor escolha de hotel para hospedagem.
	*/

    public String whichHotel(List<Integer> pricesGroup) {
        String hotel = null;
		//foi necessário criar as flag para ter um controle do que já foi comparado, evitando comparações desnecessárias
        boolean flag = false;
        boolean flagAux = false;
		//foi criada para verificar qual é o hotel que foi selecionado no final das comparações, por exemplo se a posição está no 1 então o hotel selecionado foi o Bridgewood
        int position = 0;

        int lakeWbridg = Integer.compare(pricesGroup.get(0), pricesGroup.get(1));
        int lakeWridg = Integer.compare(pricesGroup.get(0), pricesGroup.get(2));
        int bridgWridg = Integer.compare(pricesGroup.get(1), pricesGroup.get(2));

        if (lakeWbridg == 0) {
            position = 1;
            flag = true;
        } else if (lakeWridg == 0 || bridgWridg == 0) {
            position = 2;
            flag = true;
        }

        if (!flag) {
            if (lakeWbridg == (-1)) {
                position = 0;
                flagAux = true;
            } else if (bridgWridg == (-1)) {
                position = 1;
                flagAux = true;
            } else if (lakeWridg == (-1)) {
                position = 0;
                flagAux = true;
            }
        }
        if (!flagAux) {
            if (lakeWbridg == 1) {
                position = 1;
            } else if (lakeWridg == 1) {
                position = 2;
            } else if (bridgWridg == 1) {
                position = 2;
            }
        }

        switch (position) {
            case 0:
                hotel = "Lakewood";
                break;
            case 1:
                hotel = "Bridgewood";
                break;
            case 2:
                hotel = "Ridgewood";
                break;
            default:
                return "Dont have this hotel";
        }

        return hotel;
    }

	/*
        Esse método atualiza os preços de acordo com a quantidade de dias que o usuário for passar no hotel.
        Esse método atualiza os preços de acordo com a quantidade de dias que o cliente pretender ficar hospedado no hotel.
        A entrada é composto por um int[] que são os dias da semana que a pessoa vai passar, um List que apresenta os preços durante a semana
        e outro List que apresenta os preços durante o fim de semana. Esses List's são montados de acordo com o tipo de cliente.
        Sua saída é um List com o valor a ser cobrado de cada hotel.
	*/

    public List<Integer> priceUpdate(int[] entryFunc, List<Integer> priceW, List<Integer> priceWnd) {
        List<Integer> updateAnswer = new ArrayList<>();
        int v = 0;
        for (int d : entryFunc) {
            if (d >= 2 && d < 7) {
                if (v == 0) {
                    for (int i = 0; i < priceW.size(); i++) {
                        int wFirst = priceW.get(i);
                        updateAnswer.add(wFirst);
                    }
                    v++;
                } else {
                    for (int i = 0; i < priceW.size(); i++) {
                        int w = priceW.get(i);
                        w = w + updateAnswer.get(i);
                        updateAnswer.set(i, w);
                    }
                }
            } else if (d == 1 || d == 7) {
                if (v == 0) {
                    for (int i = 0; i < priceWnd.size(); i++) {
                        int wndFirst = priceWnd.get(i);
                        updateAnswer.add(wndFirst);
                    }
                    v++;
                } else {
                    for (int i = 0; i < priceWnd.size(); i++) {
                        int wnd = priceWnd.get(i);
                        wnd = wnd + updateAnswer.get(i);
                        updateAnswer.set(i, wnd);
                    }
                }

            }

        }
        return updateAnswer;
    }
}
