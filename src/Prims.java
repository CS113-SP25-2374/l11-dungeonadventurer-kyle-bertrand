import java.util.*;

public class Prims {

    public static List<Route> findMST(List<Node> nodes, Map<String, Route> edges){
        List<Route> result = new ArrayList<>();
        Set<Character> visited = new HashSet<>();
        PriorityQueue<Route> priority = new PriorityQueue<>();

        Node from = nodes.get(0);
        visited.add(from.name);

        //add start edges
        for(Node to : nodes){
            if(to.name == from.name) continue;
            Route r = edges.get(Route.key(from , to));

            priority.add(r);

        }

        while(!priority.isEmpty()){
            Route r = priority.remove();
            Node to = r.end();

            if(visited.contains(to.name)) continue;
            visited.add(to.name);
            result.add(r);

            for(Node n : nodes){
                if(!visited.contains(n.name)){
                    Route nr = edges.get(Route.key(to, n));
                    if(nr != null) {
                        priority.add(nr);
                    }
                }
            }
        }

        return result;
    }


}
