
public class Node_unionfind {
	int parent;
	int rank;
	public Node_unionfind(int newParent, int newrank) {
		parent=newParent;
		rank=newrank;
	}
	public int getParent() {return parent;}
	public int getRank() {return rank;}
	public void setParent(int newparent) {
		parent=newparent;
	}
	public void setRank(int newRank) {
		rank=newRank;
	}
}
