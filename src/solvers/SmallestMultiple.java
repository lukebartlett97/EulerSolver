package solvers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
//PROBLEM 5
//2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
//What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
public class SmallestMultiple extends EulerSolver
{
  @Override
  public void main()
  {
    printExample(smallestMultiple(10));
    printSolution(smallestMultiple(20));
  }

  private int smallestMultiple(int limit)
  {
     return Stream.iterate(1, n -> n+1)
            .limit(limit)
            .map(SmallestMultiple::findPrimeFactors)
            .map(SmallestMultiple::fromListToMap)
            .reduce(SmallestMultiple::reduceToOneMap)
            .map(SmallestMultiple::getProductFromMap)
            .orElse(-1);
  }

  /**
   * Find all prime factors of a given list, returned as a list.
   * E.g. 8 -> [2,2,2]
   */
  private static List<Integer> findPrimeFactors(int num)
  {
    int counter = 2;
    List<Integer> factors = new ArrayList<>();
    while(counter < num)
    {
      if(num % counter == 0)
      {
        num = num / counter;
        factors.add(counter);
        counter = 1;
      }
      counter++;
    }
    factors.add(num);
    return factors;
  }

  /**
   * Transforms a list into a map, mapping the value to the amount of each value.
   * E.g. [2,2,3] -> {2:2,3:1}
   */
  private static Map<Integer, Integer> fromListToMap(List<Integer> numbers)
  {
    Map<Integer, Integer> out = new HashMap<>();
    for(Integer number : numbers)
    {
      if(out.containsKey(number))
      {
        out.put(number, out.get(number) + 1);
      }
      else
      {
        out.put(number, 1);
      }
    }
    return out;
  }

  /**
   * Reduces maps into the highest value for each element
   * E.g. {2:2,3:1,4:1}, {2:1,3:2} -> {2:2,3:2,4:1}
   */
  private static Map<Integer, Integer> reduceToOneMap(Map<Integer, Integer>  map1, Map<Integer, Integer> map2)
  {
    for(Integer key : map2.keySet())
    {
      if(!map1.containsKey(key) || map1.get(key) < map2.get(key))
      {
        map1.put(key, map2.get(key));
      }
    }
    return map1;
  }

  /**
   * Creates a product of the keys using the value as the amount
   * E.g. {2:2, 3:1, 4:3} -> 2*2*3*4*4*4 -> 768
   */
  private static int getProductFromMap(Map<Integer, Integer> map)
  {
    int product = 1;
    for(Integer key : map.keySet())
    {
      for(int i = 0; i < map.get(key); i++)
      {
        product *= key;
      }
    }
    return product;
  }
}
