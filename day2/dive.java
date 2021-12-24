package day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Arrays; 
import java.util.List; 

/**
 * dive
 */
public class dive {
    public int horizontal;
    public int depth;
    public int aim;

    public dive() {
      horizontal = 0;
      depth = 0;
      aim =  0;
    }

    public String processCommandOne(String command) {
      String[] temp = command.trim().split(" ");
      int steps = Integer.parseInt(temp[1]);
      String direction = temp[0];

      if (direction.equals("forward")) {
        horizontal += steps;
      } else if (direction.equals("down")) {
        depth += steps;
      } else if (direction.equals("up")) {
        depth -= steps;
      }

      return command;
    } 
    
    public String processCommandTwo(String command) {
      String[] temp = command.trim().split(" ");
      
      int steps = Integer.parseInt(temp[1]);
      String direction = temp[0];

      if (direction.equals("forward")) {
        horizontal += steps;
        depth += aim * steps;
      } else if (direction.equals("down")) {
        aim += steps;
      } else if (direction.equals("up")) {
        aim -= steps;
      }

      return command;
    } 

    public static void main(String[] args) {
      String fileName = "day2/input2.txt"; 
      try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
        dive scenario = new dive();
        
        // stream.forEach(i -> scenario.processCommandOne(i));
        stream.forEach(i -> scenario.processCommandTwo(i));
        
        System.out.println(scenario.horizontal * scenario.depth);
      } catch (IOException e) {
          e.printStackTrace();
      }
   } 
}
