package objectmap.tests;

import junit.framework.TestCase;
import objectmap.*;

public class testMapNode extends TestCase {
	MapNode MN1, MN2;
	
	protected void setUp() throws Exception 
	{
		super.setUp();
		MN1 = new MapNode("Comp 103");
		MN2 = new MapNode("Comp 104");
	}

	public void testEquals() 
	{
		if (!MN1.equals(MN1))
			fail("MapNode not equal to itself.");
		if (MN1.equals(MN2))
			fail("MapNode should not equal second node.");
	}

	public void testToString() 
	{
		if (!MN1.toString().equals("Comp 103"))
			fail("toString failed to return node name.");
		if (!MN2.toString().equals("Comp 104"))
			fail("toString failed to return node name.");
	}

}
