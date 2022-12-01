import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Day01_1 {

    private static Integer CheckMaxCals(List<Integer> lst, Integer currentMaxCals)
    {
        Integer calSum = lst.stream().reduce(0, Integer::sum);

        if (calSum > currentMaxCals)
        {
            return calSum;
        }
        else
        {
            return currentMaxCals;
        }
    }

    public static void main(String args[]) throws FileNotFoundException 
    { 
        //creating File instance to reference text file in Java
        File text = new File("Day 01/input.txt");
     
        //Creating Scanner instance to read File in Java
        Scanner scanner = new Scanner(text);
     
        List<Integer> caloriesList = new ArrayList<Integer>();

        int maxCals = 0;

        while(scanner.hasNextLine())
        {
            //Calling nextLine() is a kind of pop method so we should only call it once per loop
            String nxt = scanner.nextLine();

            if (nxt == "")
            {
                maxCals = CheckMaxCals(caloriesList, maxCals);
                caloriesList.clear();
            }

            else
            {
                caloriesList.add(Integer.parseInt(nxt));
            }
        }  

        maxCals = CheckMaxCals(caloriesList, maxCals);
        caloriesList.clear();

        scanner.close();
        
        System.out.println(maxCals);
    }  
}

