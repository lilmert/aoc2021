package day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class BinaryDiagnostic {
  
  public Map<Integer, List<Integer>> counter;
 
  public BinaryDiagnostic(){
   counter = new HashMap<Integer, List<Integer>>(); 
  }
  
  public String processBin(String bin){
    if (counter.isEmpty()){
      for (int j=0; j < bin.length(); j++){      
        counter.put(j, new ArrayList<Integer>(Collections.nCopies(2,0)));
      }
    }    
    
    for (int i=0; i < bin.length(); i++){
      int digit = Character.getNumericValue(bin.charAt(i));
      List<Integer> temp = counter.get(i);
      temp.set(digit, temp.get(digit)+1);
      counter.put(i, temp);
    } 
    return bin;
  }

  public static void main(String[] args) {
    String fileName = "day3/input3.txt"; 
    try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
      BinaryDiagnostic scenario = new BinaryDiagnostic();
      stream.forEach(i -> scenario.processBin(i));
      String gammaRate = "";
      String epsilonRate = "";
      for (List<Integer> value : scenario.counter.values()) {
        System.out.println(Arrays.toString(value.toArray()));
        if (value.get(0) > value.get(1)) {
          gammaRate = gammaRate.concat("0");
          epsilonRate = epsilonRate.concat("1");
        } else {
          gammaRate = gammaRate.concat("1");
          epsilonRate = epsilonRate.concat("0");
        }
      }
      System.out.println(Integer.parseInt(gammaRate,2));
      System.out.println(Integer.parseInt(epsilonRate,2));
      System.out.println(Integer.parseInt(epsilonRate, 2) * Integer.parseInt(gammaRate, 2));
    } catch (IOException e) {
        e.printStackTrace();
    }
  } 
}
