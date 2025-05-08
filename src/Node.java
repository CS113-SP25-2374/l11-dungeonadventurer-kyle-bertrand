public class Node implements Comparable<Node>{

    public int x;
    public int y;
    public int g;
    public int h;
    public char name;
    public Node parent;

    public Node(int x, int y, char name){
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public Node(int x, int y, char name, int g, int h){
        this(x, y, name);
        this.g = g;
        this.h = h;
    }

    public Node(int x, int y, char name, int g, int h, Node parent){
        this(x, y, name, g, h);
        this.parent = parent;
    }

    public Node(Node node){
        this.x = node.x;
        this.y = node.y;
        this.g = node.g;
        this.h = node.h;
        this.name = node.name;
    }

    public int f(){return g + h;}


    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.f(), o.f());
    }
}
