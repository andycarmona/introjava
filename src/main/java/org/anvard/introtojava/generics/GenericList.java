package org.anvard.introtojava.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class GenericList {

  public static int sum(List<Integer> l) {
    int sum = 0;
    for (Integer i: l) {
      sum += i; // No cast needed
    }
    return sum;
  }

  public static List<String> getSortedCharacters(List<String> myList)
  {
      List<String> result = myList.stream()
              .filter( s -> s.startsWith( "c" ) )
              .map( String::toUpperCase )
              .sorted()
              .collect( Collectors.toList());

      return result;
  }

  public static void printList(List<?> list) {
    for (Object elem: list)
        System.out.print(elem + " ");
    System.out.println();
  }
  public static void main(String args[]) {
    List<Integer> l = new ArrayList<>();
    l.add(5); l.add(6); l.add(7);
    System.out.println("Sum: " + sum(l));
    // l.add("Can't - compiler error");
  }
}
