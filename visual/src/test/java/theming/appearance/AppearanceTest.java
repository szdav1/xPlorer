package theming.appearance;

import java.awt.Color;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import theming.ColorThemeRepositoryTestInstance;
import theming.ResourceManagerTestInstance;
import theming.appearance.configs.BackgroundConfiguration;
import theming.appearance.configs.BorderConfiguration;
import theming.appearance.configs.FontConfiguration;
import theming.appearance.configs.FontConfiguration.FontData;
import theming.appearance.configs.ForegroundConfiguration;
import theming.appearance.configs.IconConfiguration;
import theming.appearance.configs.IconConfiguration.IconData;
import theming.appearance.configs.PaintConfiguration.PaintData;
import theming.appearance.consts.PaintDirection;
import theming.appearance.consts.ScaleType;

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

	@Nested
	@DisplayName("BorderConfiguration test")
	class BorderConfigurationTest {
		BorderConfiguration bc;

		@BeforeEach
		@DisplayName("Initializing border test")
		void borderConfigTestInit() {
			this.bc = appearance.getBorder();
		}

		@Test
		@DisplayName("Border values should match with the ones defined in the color theme file")
		void borderTestValuesShouldMatchWithTheOnesDefinedInTheColorThemeFile() {
			Assertions.assertAll(() -> {
				Assertions.assertEquals(5, this.bc.getSize());
				Assertions.assertEquals(10, this.bc.getRadius());
				Assertions.assertEquals(ScaleType.ABSOLUTE, this.bc.getScaling());
			});
		}
	}

	@Nested
	@DisplayName("FontConfiguration test")
	class FontConfigurationTest {
		FontConfiguration fc;
		FontData normal;
		FontData hovered;
		FontData clicked;

		@BeforeEach
		@DisplayName("Initializing font test")
		void fontConfigTestInit() {
			this.fc = appearance.getFont();
			this.normal = this.fc.getNormalConfig();
			this.hovered = this.fc.getHoveredConfig();
			this.clicked = this.fc.getClickedConfig();
		}

		@Test
		@DisplayName("Font normal values should match with the ones in the color theme file")
		void fontTestNormalValues() {
			Assertions.assertAll(() -> {
				Assertions.assertEquals("Comic Sans", this.normal.getFamily());
				Assertions.assertEquals("normal", this.normal.getLigature());
				Assertions.assertEquals(5, this.normal.getSize());
				Assertions.assertEquals(ScaleType.RELATIVE, this.normal.getScaling());
			});
		}

		@Test
		@DisplayName("Font hovered values should match with the ones in the color theme file")
		void fontTestHoveredlValues() {
			Assertions.assertAll(() -> {
				Assertions.assertEquals("Comic Sans", this.hovered.getFamily());
				Assertions.assertEquals("bold", this.hovered.getLigature());
				Assertions.assertEquals(5, this.hovered.getSize());
				Assertions.assertEquals(ScaleType.ABSOLUTE, this.hovered.getScaling());
			});
		}

		@Test
		@DisplayName("Font clicked values should match with the ones in the color theme file")
		void fontTestClickedlValues() {
			Assertions.assertAll(() -> {
				Assertions.assertEquals("Comic Sans", this.clicked.getFamily());
				Assertions.assertEquals("italic", this.clicked.getLigature());
				Assertions.assertEquals(15, this.clicked.getSize());
				Assertions.assertEquals(ScaleType.RELATIVE, this.clicked.getScaling());
			});
		}
	}

	@Nested
	@DisplayName("IconConfiguration test")
	class IconConfigurationTest {
		IconConfiguration ic;
		IconData normal;
		IconData hovered;
		IconData clicked;

		@BeforeEach
		@DisplayName("Initializing icon test")
		void iconConfigTestInit() {
			this.ic = appearance.getIcon();
			this.normal = this.ic.getNormalConfig();
			this.hovered = this.ic.getHoveredConfig();
			this.clicked = this.ic.getClickedConfig();
		}

		@Test
		@DisplayName("Icon normal values should match with the ones in the color theme file")
		void iconTestNormalValues() {
			int[] expected = new int[] {500, 500};

			Assertions.assertAll(() -> {
				Assertions.assertEquals("icons/normal.png", this.normal.getSrc());
				Assertions.assertArrayEquals(expected, this.normal.getSize());
				Assertions.assertEquals(ScaleType.ABSOLUTE, this.normal.getScaling());
			});
		}

		@Test
		@DisplayName("Icon hovered values should match with the ones in the color theme file")
		void iconTestHoveredlValues() {
			int[] expected = new int[] {200, 500};

			Assertions.assertAll(() -> {
				Assertions.assertEquals("icons/hovered.png", this.hovered.getSrc());
				Assertions.assertArrayEquals(expected, this.hovered.getSize());
				Assertions.assertEquals(ScaleType.RELATIVE, this.hovered.getScaling());
			});
		}

		@Test
		@DisplayName("Icon clicked values should match with the ones in the color theme file")
		void iconTestClickedlValues() {
			int[] expected = new int[] {500, 300};

			Assertions.assertAll(() -> {
				Assertions.assertEquals("icons/clicked.png", this.clicked.getSrc());
				Assertions.assertArrayEquals(expected, this.clicked.getSize());
				Assertions.assertEquals(ScaleType.ABSOLUTE, this.clicked.getScaling());
			});
		}
	}
}