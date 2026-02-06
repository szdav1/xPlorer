package lib.theming.declarations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lib.theming.properties.FontProperty;

class FontDeclarationTest {
	@Test
	@DisplayName("FontDeclaration  should use the values provided via setters")
	void fontDeclarationShouldHaveExpectedValues() {
		FontProperty normal = new FontProperty();
		normal.setFamily("Arial");
		normal.setLigature("bold");
		normal.setSize(34);
		normal.setScaling("absolute");

		FontProperty hovered = new FontProperty();
		hovered.setFamily("Consolas");
		hovered.setLigature("italic");
		hovered.setSize(17);
		hovered.setScaling("absolute");

		FontProperty clicked = new FontProperty();
		clicked.setFamily("Comic Mono");
		clicked.setLigature("normal");
		clicked.setSize(8);
		clicked.setScaling("relative");

		FontDeclaration fd = new FontDeclaration();
		fd.setNormal(normal);
		fd.setHovered(hovered);
		fd.setClicked(clicked);

		Assertions.assertAll(() -> {
			Assertions.assertEquals("Arial", fd.getNormal().getFamily());
			Assertions.assertEquals("bold", fd.getNormal().getLigature());
			Assertions.assertEquals(34, fd.getNormal().getSize());
			Assertions.assertEquals("absolute", fd.getNormal().getScaling());
		});

		Assertions.assertAll(() -> {
			Assertions.assertEquals("Consolas", fd.getHovered().getFamily());
			Assertions.assertEquals("italic", fd.getHovered().getLigature());
			Assertions.assertEquals(17, fd.getHovered().getSize());
			Assertions.assertEquals("absolute", fd.getHovered().getScaling());
		});

		Assertions.assertAll(() -> {
			Assertions.assertEquals("Comic Mono", fd.getClicked().getFamily());
			Assertions.assertEquals("normal", fd.getClicked().getLigature());
			Assertions.assertEquals(8, fd.getClicked().getSize());
			Assertions.assertEquals("relative", fd.getClicked().getScaling());
		});
	}
}