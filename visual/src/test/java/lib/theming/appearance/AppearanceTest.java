package lib.theming.appearance;

import java.awt.Color;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import lib.theming.ColorThemeRepositoryTestInstance;
import lib.theming.ResourceManagerTestInstance;
import lib.theming.appearance.configs.BackgroundConfiguration;
import lib.theming.appearance.configs.ForegroundConfiguration;
import lib.theming.appearance.configs.PaintConfiguration.PaintData;
import lib.theming.appearance.consts.PaintDirection;

@DisplayName("Appearance test")
class AppearanceTest {
	static Appearance appearance;

	@BeforeAll
	@DisplayName("Initializing appearance test")
	static void appearanceTestInit() {
		ColorThemeRepositoryTestInstance.loadFromResource(ResourceManagerTestInstance.load("TestTheme.json"));
		appearance = ColorThemeRepositoryTestInstance.get("XButton");
	}

	@Test
	@DisplayName("Appearance background and foreground direction should be left to right and diagonal bottom to left")
	void appearanceTestBackgroundAndForegroundDirectionShouldMatchWithThoseDefinedInTheTestTheme() {
		Assertions.assertAll(() -> {
			Assertions.assertEquals(PaintDirection.LEFT_TO_RIGHT, appearance.getBackground().getDirection());	
			Assertions.assertEquals(PaintDirection.DIAGONAL_BOTTOM_TO_LEFT, appearance.getForeground().getDirection());	
		});
	}

	@Nested
	@DisplayName("BackgroundConfiguration test")
	class BackgroundConfigurationTest {
		BackgroundConfiguration bc;
		PaintData normal;
		PaintData hovered;
		PaintData clicked;

		@BeforeEach
		@DisplayName("Initializing background test")
		void backgroundTestInit() {
			this.bc = appearance.getBackground();
			this.normal = this.bc.getNormalConfig();
			this.hovered = this.bc.getHoveredConfig();
			this.clicked = this.bc.getClickedConfig();
		}

		@Test
		@DisplayName("Background colors should match with the ones defined in the color theme")
		void backgroundTestColorsShouldMatchWithTheOnesInTheColorTheme() {
			Assertions.assertAll(() -> {
				Assertions.assertEquals(Color.red, this.normal.getColors()[0]);
				Assertions.assertEquals(Color.green, this.hovered.getColors()[0]);
				Assertions.assertEquals(Color.blue, this.clicked.getColors()[0]);
			});	
		}
	}

	@Nested
	@DisplayName("ForegroundConfiguration test")
	class ForegroundConfigurationTest {
		ForegroundConfiguration fc;
		PaintData normal;
		PaintData hovered;
		PaintData clicked;

		@BeforeEach
		@DisplayName("Initializing foreground test")
		void foregroundTestInit() {
			this.fc = appearance.getForeground();
			this.normal = this.fc.getNormalConfig();
			this.hovered = this.fc.getHoveredConfig();
			this.clicked = this.fc.getClickedConfig();
		}

		@Test
		@DisplayName("Foreground colors should match with the ones defined in the color theme")
		void foregroundTestColorsShouldMatchWithTheOnesInTheColorTheme() {
			Color expected = Color.decode("#000FFF");
			
			Assertions.assertAll(() -> {
				Assertions.assertEquals(expected, this.normal.getColors()[0]);
				Assertions.assertArrayEquals(new Color[] {expected, Color.black}, this.hovered.getColors());
				Assertions.assertEquals(expected, this.clicked.getColors()[0]);
			});	
		}
	}
}