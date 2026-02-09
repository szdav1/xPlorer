package lib.theming.appearance;

import java.awt.Color;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import lib.theming.appearance.configs.BackgroundConfiguration;
import lib.theming.appearance.configs.BorderConfiguration;
import lib.theming.appearance.configs.FontConfiguration;
import lib.theming.appearance.configs.IconConfiguration;
import lib.theming.appearance.consts.PaintDirection;
import lib.theming.declarations.PaintDeclaration;

@DisplayName("Appearance test")
class AppearanceTest {
	BackgroundConfiguration bg;
	BorderConfiguration br;
	FontConfiguration ft;
	IconConfiguration in;

	@BeforeEach
	@DisplayName("Initializing Appearance Test")
	void appearanceTestInit() {
		this.bg = new BackgroundConfiguration();
		this.br = new BorderConfiguration(); // TODO: Write border test
		this.ft = new FontConfiguration(); // TODO: Write font test
		this.in = new IconConfiguration(); // TODO: Write icon test
	}

	@Nested
	@DisplayName("BackgroundConfiguration and ForegroundConfiguration tests")
	class BackgroundConfigurationAndForegroundConfigurationTests {
		final PaintDeclaration declaration = new PaintDeclaration(
				new String[] {"#FFFFFF", "#000000", "#FF0000"},
				new String[] {"#222222", "#00FF00"},
				new String[] {"#0000FF", "#0000FF"},
				"left-right"
		);

		@Test
		@DisplayName("Test the constructor of the BackgroundConfiguration and ForegroundConfiguration for colors")
		void testConstructorForColors() {
			AppearanceTest.this.bg = new BackgroundConfiguration(this.declaration);
			Color[] expected1 = {Color.white, Color.black, Color.red};
			Color[] expected2 = {Color.decode("#222222"), Color.green};
			Color[] expected3 = {Color.blue, Color.blue};

			Assertions.assertAll(() -> {
				Assertions.assertArrayEquals(expected1, bg.getNormalConfig().getColors());
				Assertions.assertArrayEquals(expected2, bg.getHoveredConfig().getColors());
				Assertions.assertArrayEquals(expected3, bg.getClickedConfig().getColors());
			});
		}

		@Test
		@DisplayName("Test the constructor of the BackgroundConfiguration and ForegroundConfiguration for fractions")
		void testConstructorForFractions() {
			AppearanceTest.this.bg = new BackgroundConfiguration(this.declaration);
			float[] expected1 = {0.0F, 1.0F / 3, 1.0F};
			float[] expected2 = {0.0F, 1.0F};

			Assertions.assertAll(() -> {
				Assertions.assertEquals(0.0F, Float.compare(expected1[0], bg.getNormalConfig().getFractions()[0]));
				Assertions.assertEquals(0.0F, Float.compare(expected1[1], bg.getNormalConfig().getFractions()[1]));
				Assertions.assertEquals(0.0F, Float.compare(expected1[2], bg.getNormalConfig().getFractions()[2]));

				Assertions.assertEquals(0.0F, Float.compare(expected2[0], bg.getHoveredConfig().getFractions()[0]));
				Assertions.assertEquals(0.0F, Float.compare(expected2[1], bg.getHoveredConfig().getFractions()[1]));
			});
		}

		@Test
		@DisplayName("The invalid color should be parsed as plain black")
		void testInvalidColorStringHandling() {
			this.declaration.setNormal(new String[] {"YTIK"});
			AppearanceTest.this.bg = new BackgroundConfiguration(this.declaration);
			Assertions.assertEquals(Color.black, bg.getNormalConfig().getColors()[0]);
		}

		@Test
		@DisplayName("Test the paint direction parsing functionality of the BackgroundConfiguration and")
		void testPaintDirectionParsing() {
			AppearanceTest.this.bg = new BackgroundConfiguration(this.declaration);
			Assertions.assertEquals(PaintDirection.LEFT_TO_RIGHT, bg.getDirection());
		}
	}
}