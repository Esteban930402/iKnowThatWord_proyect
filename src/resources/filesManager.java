package resources;

import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class filesManager {
    public List<String> getRandomLines(String explorerID, int level) throws IOException{
        List<String> lineas= new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(explorerID))){
            String linea;
            while ((linea=br.readLine())!=null){
                lineas.add(linea);

            }
        }
        List<String> randomLines = new ArrayList<>();
        Random random = new Random();
        int totalLines= lineas.size();
        int wordsAmmount=0;
        switch (level){
            case 1:
                wordsAmmount=20;
                break;
            case 2:
                wordsAmmount=40;
                break;
            case 3:
                wordsAmmount=50;
                break;
            case 4:
                wordsAmmount=60;
                break;
            case 5:
                wordsAmmount=70;
                break;
            case 6:
                wordsAmmount=80;
                break;
            case 7:
                wordsAmmount=100;
                break;
            case 8:
                wordsAmmount=120;
                break;
            case 9:
                wordsAmmount=140;
                break;
            case 10:
                wordsAmmount=200;
                break;
        }


        for (int i=0;i<wordsAmmount;i++){
            int randomI = random.nextInt(totalLines);
            randomLines.add(lineas.get(randomI));
        }
        return randomLines;
    }

}
