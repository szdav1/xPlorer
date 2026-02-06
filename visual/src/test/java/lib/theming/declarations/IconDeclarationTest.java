package lib.theming.declarations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lib.theming.properties.IconProperty;

class IconDeclarationTest {
	@Test
	@DisplayName("IconDeclaration  should use the values provided via setters")
	void iconDeclarationShouldHaveExpectedValues() {
		IconProperty normal = new IconProperty();
		normal.setSrc("normalIcon.png");
		normal.setSize(new int[] {100, 100});
		normal.setScaling("absolute");

		IconProperty hovered = new IconProperty();
		hovered.setSrc("hoveredIcon.png");
		hovered.setSize(new int[] {500, 100});
		hovered.setScaling("relative");

		IconProperty clicked = new IconProperty();
		clicked.setSrc("clickedIcon.png");
		clicked.setSize(new int[] {100, 500});
		clicked.setScaling("absolute");

		IconDeclaration id = new IconDeclaration();
		id.setNormal(normal);
		id.setHovered(hovered);
		id.setClicked(clicked);

		Assertions.assertAll(() -> {
			Assertions.assertEquals("normalIcon.png", id.getNormal().getSrc());
			Assertions.assertEquals(100, id.getNormal().getSize()[0]);
			Assertions.assertEquals(100, id.getNormal().getSize()[1]);
			Assertions.assertEquals("absolute", id.getNormal().getScaling());
		});

		Assertions.assertAll(() -> {
			Assertions.assertEquals("hoveredIcon.png", id.getHovered().getSrc());
			Assertions.assertEquals(500, id.getHovered().getSize()[0]);
			Assertions.assertEquals(100, id.getHovered().getSize()[1]);
			Assertions.assertEquals("relative", id.getHovered().getScaling());
		});

		Assertions.assertAll(() -> {
			Assertions.assertEquals("clickedIcon.png", id.getClicked().getSrc());
			Assertions.assertEquals(100, id.getClicked().getSize()[0]);
			Assertions.assertEquals(500, id.getClicked().getSize()[1]);
			Assertions.assertEquals("absolute", id.getClicked().getScaling());
		});
	}
}