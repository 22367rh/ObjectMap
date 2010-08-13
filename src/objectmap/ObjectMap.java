package objectmap;

import java.util.*;

public class ObjectMap {
	private String Title;
	private ArrayList<MapNode> nodes;
	private HashMap<String, ArrayList<String>> links;
	
	public ObjectMap(String mapTitle) {
		Title = mapTitle;
		nodes = new ArrayList<MapNode>();
		links = new HashMap<String, ArrayList<String>>();
	}
	
	public void Add(MapNode node) throws Exception
	{
		if (node != null)
		{
			if (!nodes.contains(node))
				nodes.add(node);
			else
				throw new Exception("Node already exists in Map.");
		} else {
			throw new Exception("Given Node was equal to Null.");
		}
	}
	
	public void Draw()
	{
		for (int i = 0; i < nodes.size(); i++)
		{
			String str = nodes.get(i).toString();
			if (links.containsKey(str))
			{
				for (String S : links.get(str))
					System.out.println(str + " -> " + S);
			}
		}
	}
	
	public void Link(String parent, String child) throws Exception
	{
		if (parent != null && child != null)
		{
			if (nodes.contains(new MapNode(parent)) && nodes.contains(new MapNode(child)))
				if (links.containsKey(parent))
				{
					ArrayList<String> S = links.get(parent);
					if (!S.contains(new MapNode(child)))
					{
						S.add(child);
						links.put(parent, S);
					}
					else 
						throw new Exception("Link Already Exists.");
				} else {
					ArrayList<String> S = new ArrayList<String>();
					S.add(child);
					links.put(parent, S);
				}
			else
				throw new Exception("A Node is missing from Map.");
		} else {
			throw new Exception("A given Node was equal to Null.");
		}
	}
	
	public int[] Statistics()
	{
		int linkCount = 0;
		for (String S : links.keySet())
			linkCount += links.get(S).size();
		
		int[] I = new int[] { 
					nodes.size(), 
					linkCount 
				  };
		return (I);
	}

	@Override
	public boolean equals(Object obj) {
		return false;
	}

	@Override
	public String toString() {
		return Title;
	}

	
}
