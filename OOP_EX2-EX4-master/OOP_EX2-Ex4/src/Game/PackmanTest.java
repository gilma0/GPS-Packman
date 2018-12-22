package Game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Geom.Point3D;

class PackmanTest {

	@Test
	void testPackmanIntDoubleDoubleDoubleIntInt() {
		Packman test = new Packman(1,2,3,4,5,6);
		Point3D test2 = new Point3D(2,3,4);
		if(test.getID() != 1 || !test.getPackman().equals(test2) || test.getSpeed() != 5 || test.getRadius() != 6) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testPackmanIntPoint3D() {
		Point3D test2 = new Point3D(2,3,4);
		Packman test = new Packman (1, test2);
		if(test.getID() != 1 || !test.getPackman().equals(test2)) {
			fail("Not yet implemented");
		}
	}

}
