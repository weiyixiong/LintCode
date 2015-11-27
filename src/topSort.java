import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by winney on 15/11/24.
 */
public class topSort {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        int[] visited = new int[graph.size()];
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(i).neighbors.size(); j++) {
                visited[graph.get(i).neighbors.get(j).label] = 1;
            }
        }
        ArrayList<DirectedGraphNode> headCache = new ArrayList<DirectedGraphNode>;
        for (int j = 0; j < visited.length; j++) {
            if (visited[j] == 0 && graph.get(j).neighbors.size() != 0) {
                headCache.add(graph.get(j));
            } else {
                visited[j] = 0;
            }
        }
        int i = 0;
        while (!headCache.isEmpty() && topSort(graph, headCache.get(i++), new ArrayList<>(res), visited.clone()).size() != graph.size())
            ;

        return res;
    }

    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph, DirectedGraphNode head, ArrayList<DirectedGraphNode> res, int[] visited) {
        if (res.size() == graph.size()) {
            return res;
        }
        res.add(head);
        ArrayList<DirectedGraphNode> tmpLst = head.neighbors;
        res.add(tmpLst.get(0));
        visited[tmpLst.get(0).label] = 1;
        for (int i = 0; i < tmpLst.size(); i++) {
            if (visited[tmpLst.get(i).label] == 0) {
                topSort(graph, head, new ArrayList<>(res), visited.clone());
            }
        }

        return res;
    }

}
