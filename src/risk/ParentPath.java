package risk;

public class ParentPath {

    int fromAStar, toAStar;
    Node parent;

    public ParentPath(Node x, int a, int b) {
        fromAStar = a;
        toAStar = b;
        parent = x;
    }
}
