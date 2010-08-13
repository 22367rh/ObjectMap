package objectmap.tests;

import objectmap.*;
import junit.framework.TestCase;

public class testObjectMap extends TestCase {
	ObjectMap OM1, OM2;
	
	protected void setUp() throws Exception {
		super.setUp();
		OM1 = new ObjectMap("Waikato University");
		OM2 = new ObjectMap("Wintec");
	}

	public void testEquals() {
		if (!OM1.equals(OM1))
			fail("MapNode not equal to itself.");
		if (OM1.equals(OM2))
			fail("MapNode should not equal second node.");
	}

	public void testToString() {
		if (!OM1.toString().equals("Waikato University"))
			fail("toString failed to return map name.");
		if (!OM2.toString().equals("Wintec"))
			fail("toString failed to return map name.");
	}
	
	public void testStatistics()
	{
		try {
			OM1.Add(new MapNode("Comp 103"));
			OM1.Add(new MapNode("Comp 104"));
			OM1.Add(new MapNode("Comp 134"));
		} catch (Exception E) {
			fail("Unexected Error: " + E.getMessage());
		}
		
		try {
			OM1.Link("Comp 103", "Comp 104");
			OM1.Link("Comp 103", "Comp 134");
		} catch (Exception E) {
			fail("Unexected Error: " + E.getMessage());
		}
		
		OM1.Draw();
		
		int[] stats = OM1.Statistics();
		if (stats[0] != 3 || stats[1] != 2)
			fail("Didn't returnt the correct count for node & link counts.");
	}

}
