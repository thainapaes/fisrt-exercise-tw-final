import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Hotel {
    // Regular: 16Mar2009(mon),17Mar2009(tues),18Mar2009(wed)
    public String sharedHotel(String info) throws ParseException {
        String resposta;
        List<Integer> novo = new ArrayList<>();
        String[] infoS = info.split(":");
        if (infoS[0].equals("Regular")) {
            List<Integer> priceW = Arrays.asList(110, 160, 220);
            List<Integer> priceWnd = Arrays.asList(90, 60, 150);
            String[] dayS = infoS[1].split(",");
            //int[] retornoFunc = dayOfWeek(dayS);
            novo = precosAtt(dayOfWeek(dayS), priceW, priceWnd);
            //novo.stream().min(Integer::compare).get();
        } else if (infoS[0].equals("Rewards")) {
            List<Integer> priceW = Arrays.asList(80, 110, 100);
            List<Integer> priceWnd = Arrays.asList(80, 50, 40);
            String[] dayS = infoS[1].split(",");
            //int[] retornoFunc = dayOfWeek(dayS);
            novo = precosAtt(dayOfWeek(dayS), priceW, priceWnd);
        } else {
            resposta = "Arquivo com informações incorretas";
            return resposta;
        }
        resposta = qualHotel(novo);
        return resposta;
    }

    private int[] dayOfWeek(String[] days) throws ParseException {
        int[] diasHospedagem = new int[days.length];
        int f = 0;
        for (String day : days) {
            String mes = day.substring(3, 6);
            switch (mes) {
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
            Date diaD = sdf.parse(day);
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(diaD);
            int diaDaSemana = gc.get(GregorianCalendar.DAY_OF_WEEK);
            diasHospedagem[f] = diaDaSemana;
            f++;
        }
        return diasHospedagem;
    }

    public String qualHotel(List<Integer> novo) {
        String hotel = null;
        boolean flag = false;
        boolean flagAux = false;
        int posicao = 0;

        int dd = Integer.compare(novo.get(0), novo.get(1));
        int da = Integer.compare(novo.get(0), novo.get(2));
        int db = Integer.compare(novo.get(1), novo.get(2));

        if (dd == 0) {
            posicao = 1;
            flag = true;
        } else if (da == 0 || db == 0) {
            posicao = 2;
            flag = true;
        }

        if (!flag) {
            if (dd == (-1)) {
                posicao = 0;
                flagAux = true;
            } else if (db == (-1)) {
                posicao = 1;
                flagAux = true;
            } else if (da == (-1)) {
                posicao = 0;
                flagAux = true;
            }
        }
        if (!flagAux) {
            if (dd == 1) {
                posicao = 1;
            } else if (da == 1) {
                posicao = 2;
            } else if (db == 1) {
                posicao = 2;
            }
        }

        switch (posicao) {
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

    public List<Integer> precosAtt(int[] retornoFunc, List<Integer> priceW, List<Integer> priceWnd) {
        //List<Integer> retorno = priceW;
        List<Integer> retorno = new ArrayList<>();
        int v = 0;
        for (int dias : retornoFunc) {
            if (dias >= 2 && dias < 7) {
                if (v == 0) {
                    for (int i = 0; i < priceW.size(); i++) {
                        int s = priceW.get(i);
                        retorno.add(s);
                    }
                    v++;
                } else {
                    for (int i = 0; i < priceW.size(); i++) {
                        int w = priceW.get(i);
                        w = w + retorno.get(i);
                        retorno.set(i, w);
                    }
                }
            } else if (dias == 1 || dias == 7) {
                if (v == 0) {
                    for (int i = 0; i < priceWnd.size(); i++) {
                        int w = priceWnd.get(i);
                        retorno.add(w);
                    }
                    v++;
                } else {
                    for (int i = 0; i < priceWnd.size(); i++) {
                        int w = priceWnd.get(i);
                        w = w + retorno.get(i);
                        retorno.set(i, w);
                    }
                }

            }

        }
        return retorno;
    }
}
