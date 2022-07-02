import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

  // Dijkstra's Algorithm
  // the article i used is :
  // "https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue/"
  public static void CalculateMinimumCost(List<Citie> cities, Citie source) {
    // Cost to the source is 0
    source.minCost = 0.;
    PriorityQueue<Citie> citiesQueue = new PriorityQueue<Citie>();
    // Add source city to the priority queue
    citiesQueue.add(source);

    while (!citiesQueue.isEmpty()) {
      Citie u = citiesQueue.poll();

      // Visit each edge exiting u
      for (Edge e : u.neighbors ) {
        Citie v = cities.get(e.target-1);
        double costThroughU = u.minCost + e.cost;
        // If new distance is cheaper in cost
        if (costThroughU < v.minCost) {
          citiesQueue.remove(v);
          v.minCost = costThroughU;
          citiesQueue.add(v);
        }
      }
    }
  }
}
