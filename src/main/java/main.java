import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {

  public static void main(String[] args) throws IOException {


    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    //s [the number of tests <= 10]
    int s = Integer.parseInt(bufferedReader.readLine());
    if(s > 0 && s <= 10) {
      for (int i = 0; i < s; i++) {
        List<Citie> cities = new ArrayList<>();

        //s [the number of tests <= 10]
        int n = Integer.parseInt(bufferedReader.readLine());
        if(n > 0 && n <= 10000){
          for(int j = 0; j < n ; j++){

            //NAME [city name]
            String NAME = bufferedReader.readLine();
            Citie currentCity = new Citie(NAME);
            cities.add(currentCity);

            //p [the number of neighbors of city NAME]
            int p = Integer.parseInt(bufferedReader.readLine());

            for(int ij = 0; ij < p; ij++){
              //nr cost [nr - index of a city connected to NAME (the index of the first city is 1)]
              //           [cost - the transportation cost]
              int[] nrCost = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
              currentCity.neighbors.add(new Edge(nrCost[0],nrCost[1]));
            }
          }
        }
        //r [the number of paths to find <= 100]
        int r = Integer.parseInt(bufferedReader.readLine());
        if (r <= 100){
          double[] outPut = new double[r];
          for(i = 0; i < r; i++) {
            //NAME1 NAME2 [NAME1 - source, NAME2 - destination]
            String[] names = bufferedReader.readLine().split(" ");
            Dijkstra.CalculateMinimumCost(cities, cities.stream().filter(city -> city.getName().equals(names[0])).findAny().orElse(null));
            outPut[i] = cities.stream().filter(city -> city.getName().equals(names[1])).findAny().orElse(null).minCost;
            cities.stream().forEach(citie -> citie.refreshMinDistance());

          }
          System.out.println();
          Arrays.stream(outPut).forEach( System.out::println);
        }
      }
    }
   }
}

