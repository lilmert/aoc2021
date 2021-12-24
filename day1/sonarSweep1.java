package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Arrays; 
import java.util.List; 

public class sonarSweep1 {

  public static int sweep1(List<Integer> input) {
    int count = 0;
    for (int i=0; i < input.size(); i++) {
      if (i != 0) {
        int current = input.get(i);
        int previous = input.get(i-1);
        if (current > previous) {
           count++;
        }
      }
    }
    return count;
  }

  public static int sweep2(List<Integer> input) {
    int count = 0;
    int previous = 0;
    for (int i=0; i < input.size() - 2; i++) {
      int current = 0;
      for (int j=0; j < 3; j++) {
        current += input.get(i+j);        
      }
      if (i != 0) {
        if (current > previous) {
          count++;
        }
      }
      previous = current;
    }
    return count;
  }
   public static void main(String[] args) {
      String fileName = "day1/input1.txt"; 
      try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
        List<Integer> input = stream.map(Integer::valueOf).collect(Collectors.toList());
        int answerOne = sweep1(input);
        int answerTwo = sweep2(input);
        System.out.println(answerOne);
        System.out.println(answerTwo);
      } catch (IOException e) {
          e.printStackTrace();
      }
   } 
}
