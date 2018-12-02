package risk;

import java.util.Comparator;

public class NodeComparator implements Comparator <Node> {

	public int compare(Node arg0, Node arg1) {
		if(arg0.cost == arg1.cost) {
			 return 0;
		}
		if(arg0.cost < arg1.cost) {
			 return 1;
		}
		return -1;
	}

}
