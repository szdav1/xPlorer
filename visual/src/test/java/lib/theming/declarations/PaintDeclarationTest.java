package lib.theming.declarations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PaintDeclarationTest {
	@Test
	@DisplayName("PaintDeclaration  should use the values provided via setters")
	void paintDeclarationShouldHaveExpectedValues() {
		String[] normal = {"#FFF000", "#000FFF"};
		String[] hovered = {"#FAB92E", "#EFC568"};
		String[] clicked = {"#E29BAF", "#856CFE"};

		PaintDeclaration pd = new PaintDeclaration();
		pd.setNormal(normal);
		pd.setHovered(hovered);
		pd.setClicked(clicked);
		pd.setDirection("right-left");

		Assertions.assertAll(() -> {
			Assertions.assertArrayEquals(new String[] {"#FFF000", "#000FFF"}, pd.getNormal());
			Assertions.assertArrayEquals(new String[] {"#FAB92E", "#EFC568"}, pd.getHovered());
			Assertions.assertArrayEquals(new String[] {"#E29BAF", "#856CFE"}, pd.getClicked());
			Assertions.assertEquals("right-left", pd.getDirection());
		});
	}
}