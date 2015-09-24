package com.khaannn.sorting;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by jeff on 9/17/15.
 */
public class ReadFromTextFile {

    public static PairData[] test(String fileName){
        Path file = Paths.get(fileName);
        List<String> inputArray = null;
        PairData[] pairData = null;
        try {
             inputArray = Files.readAllLines(file);
        } catch (IOException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }
        try{
            pairData = new PairData[inputArray.size()];
            int i = 0;
            for(String line : inputArray){
                String[] split = line.split(" ");
                pairData[i] = new PairData(Integer.parseInt(split[0]), split[1]);
                i++;
            }
        } catch (NullPointerException e){
            System.out.println("The file is empty");
            e.printStackTrace();
        }
        return pairData;
    }

}
