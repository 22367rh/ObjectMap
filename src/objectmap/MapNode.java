package objectmap;

public class MapNode {
	private String Name;
	
	public MapNode(String nodeName) {
		Name = nodeName;
	}

	@Override
	public boolean equals(Object obj) {
		try {
			MapNode other = (MapNode)obj;
			return (this.Name == other.Name);
		} catch (Exception e)
		{
			return false;
		}
	}

	@Override
	public String toString() {
		return this.Name;
	}
}
