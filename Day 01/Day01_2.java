import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Day01_2 {

    public static Integer n = 3;

    public static void main(String args[]) throws FileNotFoundException 
    { 
        //creating File instance to reference text file in Java
        File text = new File("Day 01/input.txt");
     
        //Creating Scanner instance to read File in Java
        Scanner scanner = new Scanner(text);
     
        List<Integer> caloriesList = new ArrayList<Integer>();
        List<Integer> totalCaloriesList = new ArrayList<Integer>();

        while(scanner.hasNextLine())
        {
            //Calling nextLine() is a kind of pop method so we should only call it once per loop
            String nxt = scanner.nextLine();

            if (nxt == "")
            {
                totalCaloriesList.add(caloriesList.stream().reduce(0, Integer::sum));
                caloriesList.clear();
            }

            else
            {
                caloriesList.add(Integer.parseInt(nxt));
            }
        }  

        totalCaloriesList.add(caloriesList.stream().reduce(0, Integer::sum));
        caloriesList.clear();

        scanner.close();

        //Put list in order
        Collections.sort(totalCaloriesList);

        //Get last 3 elements of list (the 3 largest elements)
        List<Integer> tail = totalCaloriesList.subList(Math.max(totalCaloriesList.size() - n, 0), totalCaloriesList.size());
        
        System.out.println(tail.stream().reduce(0, Integer::sum));
    }  
}

