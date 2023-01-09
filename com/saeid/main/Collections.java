package com.saeid.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class Collections {

  public static void iteratingOverCollections() {
    // Iterating over List
    List<String> names = new ArrayList<>(
      Arrays.asList("Clementine", "Duran", "Mike")
    );
    // Version ≥ Java SE 8
    names.forEach(System.out::println);
    // If we need parallelism use
    names.parallelStream().forEach(System.out::println);
    // Version ≥ Java SE 5
    for (String name : names) {
      System.out.println(name);
    }

    // Version < Java SE 5
    for (int i = 0; i < names.size(); i++) {
      System.out.println(names.get(i));
    }

    // Creates ListIterator which supports both forward as well as backward traversel
    ListIterator<String> listIterator = names.listIterator();
    // Iterates list in forward direction
    while (listIterator.hasNext()) {
      System.out.println(listIterator.next());
    }
    // Iterates list in backward direction once reaches the last element from above iterator in forward direction
    while (listIterator.hasPrevious()) {
      System.out.println(listIterator.previous());
    }

    // Iterating over Set
    Set<String> namesSet = new HashSet<>(
      Arrays.asList("Clementine", "Duran", "Mike")
    );
    
    // Version ≥ Java SE 8
    namesSet.forEach(System.out::println);
    // Version ≥ Java SE 5
    for (Iterator<String> iterator = namesSet.iterator(); iterator.hasNext();) {
      System.out.println(iterator.next());
    }

    for (String name : namesSet) {
      System.out.println(name);
    }
    
    // Version < Java SE 5
    Iterator iterator = namesSet.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    // Iterating over Map
    Map<Integer, String> nameSet = new HashMap<>();
    nameSet.put(1, "Clementine");
    nameSet.put(2, "Duran");
    nameSet.put(3, "Mike");
    // Version ≥ Java SE 8
    nameSet.forEach((key, value) ->
      System.out.println("Key: " + key + " Value: " + value)
    );
    // Version ≥ Java SE 5
    for (Map.Entry<Integer, String> entry : nameSet.entrySet()) {
      System.out.println(entry.getKey());
      System.out.println(entry.getValue());
    }

    // Iterating over only keys
    for (Integer key : nameSet.keySet()) {
      System.out.println(key);
    }
    // Iterating over only values
    for (String value : nameSet.values()) {
      System.out.println(value);
    }

    // Version < Java SE 5
    Iterator entries = nameSet.entrySet().iterator();
    while (entries.hasNext()) {
      Map.Entry entry = (Map.Entry) entries.next();
      System.out.println(entry.getKey());
      System.out.println(entry.getValue());
    }    
  }
}
