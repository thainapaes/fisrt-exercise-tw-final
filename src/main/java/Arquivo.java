import jdk.nashorn.internal.ir.WhileNode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {

    public static List<String> lerTexto(String pCaminhoArquivo) {
        boolean flag = true;
        String[] retorno = null;
        List<String> r = new ArrayList<>();
        try {
            BufferedReader buff = new BufferedReader(new FileReader(pCaminhoArquivo));
            String linha = "";
            while (flag) {
                if(linha != null){
                    r.add(linha);
                    System.out.println(linha);
                } else {
                    break;
                }
                linha = buff.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return r;
    }
}
