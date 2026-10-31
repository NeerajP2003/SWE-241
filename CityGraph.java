import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class CityGraph {

    // Task 2
    Map<String, City> cityMap = new HashMap<>();

    public void readCities(String filename) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(":");

                String name = parts[0].trim();
                int population = Integer.parseInt(parts[1].trim());

                // Keeps the first occurrence for each city name
                if(!cityMap.containsKey(name)) {
                    City city = new City(name, population);
                    cityMap.put(name, city);
                }
            }
        }
    }

    public void readRoads(String filename) throws IOException {

    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

        String line;

        while ((line = reader.readLine()) != null) {

            String[] roads = line.split(":");
            
            String name1 = roads[0].trim();
            String name2 = roads[1].trim();

            City city1 = cityMap.get(name1);
            City city2 = cityMap.get(name2);

            if (city1 != null && city2 != null) {
                city1.connectedCities.add(city2);
                city2.connectedCities.add(city1);
            }
         }
      }
   }

   // Task 3
   public int countIslands() {

    Set<City> visited = new HashSet<>();
    int islands = 0;

    // Loops through every city in cities
    for (City city: cityMap.values()){

        if (!visited.contains(city)) {
         islands++;
         dfs(city, visited);
        }
   }
    return islands;
   }

   // Took help of ChatGPT with recursive dfs
   private void dfs(City city, Set<City> visited) {

     visited.add(city);

    for (City neighbor : city.connectedCities) {
        if (!visited.contains(neighbor)) {
            dfs(neighbor, visited);
        }
    }
  }

  // Task 4
  public List<Integer> getIslandPopulations() {

    Set<City> visited = new HashSet<>();
    List<Integer> populations = new ArrayList<>();

    for (City city : cityMap.values()) {

        if (!visited.contains(city)) {

            int total = dfsPopulation(city, visited);
            populations.add(total);
        }
    }

    return populations;
   }

   // Took ChatGPT help with recursive dfsPopulation
   private int dfsPopulation(City city, Set<City> visited) {

    visited.add(city);

    int total = city.population;

    for (City neighbor : city.connectedCities) {

        if (!visited.contains(neighbor)) {
            total = total + dfsPopulation(neighbor, visited);
        }
    }

    return total;
  }

  // Task 5
  public int minimumHighways(String startName, String destinationName) {

    City start = cityMap.get(startName);
    City destination = cityMap.get(destinationName);

    if (start == null || destination == null) {
        return -1;
    }

    Queue<City> queue = new LinkedList<>();
    Map<City, Integer> distances = new HashMap<>();

    distances.put(start, 0);
    queue.add(start);

    while (!queue.isEmpty()) {
        City current = queue.remove();

    if (current == destination) {
        return distances.get(current);
    }

    for (City neighbor : current.connectedCities) {
        if (!distances.containsKey(neighbor)) {
            distances.put(neighbor, distances.get(current) + 1);
            queue.add(neighbor);
        }
    }
  }
     return -1;
  }
}