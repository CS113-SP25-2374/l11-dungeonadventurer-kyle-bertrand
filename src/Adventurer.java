import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Adventurer {

    char[][] map;
    List<Node> pointsOfInterests = new ArrayList<>();
    Map<String, Route> routes = new HashMap<>();

    public Adventurer() {

    }

    public void solveMap(char[][] map) {
        this.map = map;

        findPOI(); //find points of interest
        findPaths(); //use a* to find the shortest paths between them
        findMST(); // find the minimum tree to get to all these locations
    }

    void findPOI() {
        for(int y = 0, i = 0; y < map.length; y++){
            for(int x = 0; x < map[y].length; x++){
               char c = map[y][x];
               if(c == DungeonMap.WALL || c == DungeonMap.OPEN) continue;
               pointsOfInterests.add(new Node(x, y, c));
            }
        }
    }

    void findPaths() {
        for(int a = 0; a < pointsOfInterests.size(); a++){
            for(int b = a+1; b < pointsOfInterests.size(); b++){
                List<Node> route;
                route = AStar.shortestPath(map, pointsOfInterests.get(a), pointsOfInterests.get(b));
                Route r = new Route(route);
                routes.put(r.key(), r);

            }
        }
    }

    void findMST() {
        List<Route> mst = Prims.findMST(pointsOfInterests, routes);
        System.out.println(mst);
    }

}
