import java.util.List;
import java.util.ArrayList;

public class City{

    // Task 1
    String name;
    int population;
    List <City> connectedCities;

    public City(String name, int population) {
        this.name = name;
        this.population = population;
        this.connectedCities = new ArrayList<City>();
   }

   public int getPopulation(){
      return population;
   }

   

  


}