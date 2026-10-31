import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {

        CityGraph graph = new CityGraph();

        graph.readCities("city_population.txt");
        graph.readRoads("road_network.txt");

        System.out.println("Number of islands: " + graph.countIslands());

        System.out.println("Island populations: "+ graph.getIslandPopulations());

        System.out.println("Irvine to Long Beach: " + graph.minimumHighways("Irvine", "Long Beach"));

        System.out.println("New York to Los Angeles: " + graph.minimumHighways("New York", "Los Angeles"));

        System.out.println("Irvine to Irvine: " + graph.minimumHighways("Irvine", "Irvine"));

        System.out.println("Irvine to Unknown City: " + graph.minimumHighways("Irvine", "Unknown City"));
    }
}