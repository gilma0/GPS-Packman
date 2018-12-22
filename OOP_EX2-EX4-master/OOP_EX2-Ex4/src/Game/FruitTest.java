package Game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Geom.Point3D;

class FruitTest {

	@Test
	void testFruitIntDoubleDoubleDouble() {
		Fruit test = new Fruit (1,2,3,4);
		Point3D test2 = new Point3D(2,3,4);
		if (test.getID() != 1 || !test.getFruit().equals(test2)) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testFruitIntPoint3D() {
		Point3D test2 = new Point3D(2,3,4);
		Fruit test = new Fruit (1,test2);
		if (test.getID() != 1 || !test.getFruit().equals(test2)) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testGetX() {
		Fruit test = new Fruit (1,2,3,4);
		if(test.getX() != -4746465) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testGetY() {
		Fruit test = new Fruit (1,2,3,4);
		if(test.getY() != 5352291) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testGetID() {
		Fruit test = new Fruit (1,2,3,4);
		if(test.getID() != 1) {
			fail("Not yet implemented");
		}
	}

	@Test
	void testGetFruit() {
		Fruit test = new Fruit (1,2,3,4);
		Point3D test2 = new Point3D(2,3,4);
		if(!test.getFruit().equals(test2)) {
			fail("Not yet implemented");
		}
	}

}
