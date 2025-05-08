import java.util.List;

public class Route implements Comparable<Route> {
    List<Node> nodes;

    public Route(List<Node> nodes) {
        this.nodes = nodes;
    }

    public Node start() {
        return nodes.get(0);
    }

    public Node end() {
        return nodes.get(nodes.size() - 1);
    }

    public int weight(){
        return nodes.size();
    }

    public String key(){
        return Route.key(this.start(), this.end());
    }

    public static String key(Node lhs, Node rhs) {
        return lhs.name + "-" + rhs.name;
    }

    @Override
    public String toString() {
        return key() + " [" + this.weight() + "]" ;
    }

    @Override
    public int compareTo(Route o) {
        return Integer.compare(weight(), o.weight());
    }
}
