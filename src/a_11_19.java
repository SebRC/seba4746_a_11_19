import java.util.EmptyStackException;
import java.util.Map;
import java.util.TreeMap;

public class a_11_19
{
    public static void main(String[] args)
    {
        // Write a method called rarest that accepts a map whose keys are strings
        // and whose values are integers as a parameter
        // and returns the integer value that occurs the fewest times in the map.
        // If there is a tie, return the smaller integer value. If the map is empty, throw an exception.

        Map<String, Integer> map = new TreeMap<>();
        map.put("Jens", 2);
        map.put("Jensine", 3);
        map.put("Jensen", 2);
        System.out.println(rarest(map));

    }

    //returns the integer occurring the least amount of times in the map
    public static int rarest(Map<String, Integer> map)
    {
        //set number of occurrences to 0
        int numOfOccurrence = 0;

        //set limit to 50
        int limit = 50;

        //set rarestnumber to 50
        int rarestNumber = 50;

        //checks if map is empty and throws an exception if empty
        if(map.isEmpty())
        {
            throw new EmptyStackException();
        }

        //runs through each entry in map1
        for (Map.Entry<String, Integer> m1: map.entrySet())
        {
            //runs through each entry in map2
            for (Map.Entry<String, Integer> m2: map.entrySet())
            {
                //if values are the same increment number of occurrences
                if(m1.getValue() == m2.getValue())
                {
                    numOfOccurrence++;
                }
            }

            //if numOfOccurrence is les than limit and m1 value is less than rarest number
            //set limit to numofoccurrence and rarestnumber to current value m1
            if(numOfOccurrence <= limit && m1.getValue() < rarestNumber)
            {
                limit= numOfOccurrence;
                rarestNumber = m1.getValue();
            }

            //reset numofoccurrence to 0
            numOfOccurrence = 0;
        }

        //return rarestnumber
        return rarestNumber;
    }
}
