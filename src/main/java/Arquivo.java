import jdk.nashorn.internal.ir.WhileNode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {

    public static List<String> readText(String pCaminhoArquivo) {
        boolean flag = true;
        //String[] retorno = null;
        List<String> r = new ArrayList<>();
        try {
            BufferedReader buff = new BufferedReader(new FileReader(pCaminhoArquivo));
            String line = "";
            while (flag) {
                if(line != null){
                    r.add(line);
                    //System.out.println(line);
                } else {
                    break;
                }
                line = buff.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return r;
    }
}
