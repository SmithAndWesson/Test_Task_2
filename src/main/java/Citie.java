import java.util.ArrayList;
import java.util.List;

// Class implementing Comparator interface
// Representing a node in the graph
class Citie implements Comparable<Citie> {

  public final String name;
  public List<Edge> neighbors = new ArrayList<>();
  public double minCost = Double.POSITIVE_INFINITY;

  public Citie(String argName) {
    name = argName;
  }

  public String toString() {
    return name;
  }

  public int compareTo(Citie other) {
    return Double.compare(minCost, other.minCost);
  }

  public String getName() {
    return name;
  }

  public void refreshMinDistance(){
    minCost = Double.POSITIVE_INFINITY;
  }
}

