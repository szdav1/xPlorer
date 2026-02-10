package lib.theming.selector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import lib.theming.ResourceManagerTestInstance;
import lib.theming.declarations.BorderDeclaration;
import lib.theming.declarations.FontDeclaration;
import lib.theming.declarations.IconDeclaration;
import lib.theming.declarations.PaintDeclaration;
import lib.theming.parser.ColorThemeParser;
import lib.theming.properties.FontProperty;
import lib.theming.properties.IconProperty;

@DisplayName("Selector test")
class SelectorTest {
	static Selector selector;

	@BeforeAll
	@DisplayName("Initializing Selector test")
	static void selectorTestInit() {
		selector = ColorThemeParser.parseJson(ResourceManagerTestInstance.load("TestTheme.json")).get("XButton");
	}

	@Nested
	@DisplayName("PaintDeclarationTest (Background and Foreground paint)")
	class PaintDeclarationTest {
		PaintDeclaration pd;

		@BeforeEach
		@DisplayName("Initializing paint test")
		void paintTestInit() {
			this.pd = selector.getBackground();
		}

		@Test
		@DisplayName("PaintDeclaration values should be red, green and blue for normal, hovered, clicked")
		void paintDeclarationTestShouldHaveRedGreenBlueValues() {
			Assertions.assertAll(() -> {
				Assertions.assertEquals("#FF0000", this.pd.getNormal()[0]);
				Assertions.assertEquals("#00FF00", this.pd.getHovered()[0]);
				Assertions.assertEquals("#0000FF", this.pd.getClicked()[0]);
			});
		}

		@Test
		@DisplayName("PaintDeclaration's direction should be left-to-right")
		void paintDeclarationTestShouldHavePaintDirectionOfLeftToRight() {
			Assertions.assertEquals("left_to_right", this.pd.getDirection());
		}
	}

	@Nested
	@DisplayName("BorderDeclaration test")
	class BorderDeclarationTest {
		BorderDeclaration bd; 
		PaintDeclaration fg;

		@BeforeEach
		@DisplayName("Initializing border test")
		void borderTestInit() {
			this.bd = selector.getBorder();
			this.fg = this.bd.getForeground();
		}

		@Test
		@DisplayName("BorderDeclaration foreground values should be blue, green and red")
		void borderTestShouldHaveBlueGreenRedForegroundValues() {
			Assertions.assertAll(() -> {
				Assertions.assertEquals("#0000FF", this.fg.getNormal()[0]);
				Assertions.assertEquals("#00FF00", this.fg.getHovered()[0]);
				Assertions.assertEquals("#FF0000", this.fg.getClicked()[0]);
			});
		}

		@Test
		@DisplayName("BorderDeclaration foreground paint direction should be diagonal bottom to left")
		void borderTestForegroundShouldHavePaintDirectionOfDiagonalBottomToLeft() {
			Assertions.assertEquals("diagonal_bottom_to_left", this.fg.getDirection());
		}

		@Test
		@DisplayName("BorderDeclaration should have a size of 5, radius of 10 and absolute scaling")
		void borderTestValuesOfTheBorderShouldMatchThoseInTheTestTheme() {
			Assertions.assertAll(() -> {
				Assertions.assertEquals(5, this.bd.getSize());
				Assertions.assertEquals(10, this.bd.getRadius());
				Assertions.assertEquals("absolute", this.bd.getScaling());
			});
		}
	}

	@Nested
	@DisplayName("FontDeclaration test")
	class FontDeclarationTest {
		FontDeclaration fd;
		FontProperty normal;
		FontProperty hovered;
		FontProperty clicked;

		@BeforeEach
		@DisplayName("Initializing font test")
		void fontTestInit() {
			this.fd = selector.getFont();
			this.normal = this.fd.getNormal();
			this.hovered = this.fd.getHovered();
			this.clicked = this.fd.getClicked();
		}

		@Test
		@DisplayName("FontDeclaration normal properties should be Comic Sans, normal, 5 and relative")
		void fontTestNormalPropertiesShouldMatchWithTheOnesDefinedInTheTestTheme() {
			Assertions.assertAll(() -> {
				Assertions.assertEquals("Comic Sans", this.normal.getFamily());
				Assertions.assertEquals("normal", this.normal.getLigature());
				Assertions.assertEquals(5, this.normal.getSize());
				Assertions.assertEquals("relative", this.normal.getScaling());
			});
		}

		@Test
		@DisplayName("FontDeclaration hovered properties should be Comic Sans, normal, 5 and absolute")
		void fontTestHoveredPropertiesShouldMatchWithTheOnesDefinedInTheTestTheme() {
			Assertions.assertAll(() -> {
				Assertions.assertEquals("Comic Sans", this.hovered.getFamily());
				Assertions.assertEquals("bold", this.hovered.getLigature());
				Assertions.assertEquals(5, this.hovered.getSize());
				Assertions.assertEquals("absolute", this.hovered.getScaling());
			});
		}

		@Test
		@DisplayName("FontDeclaration clicked properties should be Comic Sans, italic, 15 and relative")
		void fontTestClickedPropertiesShouldMatchWithTheOnesDefinedInTheTestTheme() {
			Assertions.assertAll(() -> {
				Assertions.assertEquals("Comic Sans", this.clicked.getFamily());
				Assertions.assertEquals("italic", this.clicked.getLigature());
				Assertions.assertEquals(15, this.clicked.getSize());
				Assertions.assertEquals("relative", this.clicked.getScaling());
			});
		}
	}

	@Nested
	@DisplayName("IconDeclaration test")
	class IconDeclarationTest {
		IconDeclaration id;
		IconProperty normal;
		IconProperty hovered;
		IconProperty clicked;

		@BeforeEach
		@DisplayName("Initializing icon test")
		void iconTestInit() {
			this.id = selector.getIcon();
			this.normal = this.id.getNormal();
			this.hovered = this.id.getHovered();
			this.clicked = this.id.getClicked();
		}

		@Test
		@DisplayName("IconDeclaration normal properties should be Comic Sans, normal, 5 and relative")
		void iconTestNormalPropertiesShouldMatchWithTheOnesDefinedInTheTestTheme() {
			Assertions.assertAll(() -> {
				Assertions.assertEquals("/icons/normal.png", this.normal.getSrc());
				Assertions.assertArrayEquals(new int[] {500, 500}, this.normal.getSize());
				Assertions.assertEquals("absolute", this.normal.getScaling());
			});
		}

		@Test
		@DisplayName("IconDeclaration hovered properties should be Comic Sans, normal, 5 and absolute")
		void iconTestHoveredPropertiesShouldMatchWithTheOnesDefinedInTheTestTheme() {
			Assertions.assertAll(() -> {
				Assertions.assertEquals("/icons/hovered.png", this.hovered.getSrc());
				Assertions.assertArrayEquals(new int[] {200, 500}, this.hovered.getSize());
				Assertions.assertEquals("relative", this.hovered.getScaling());
			});
		}

		@Test
		@DisplayName("IconDeclaration clicked properties should be Comic Sans, italic, 15 and relative")
		void iconTestClickedPropertiesShouldMatchWithTheOnesDefinedInTheTestTheme() {
			Assertions.assertAll(() -> {
				Assertions.assertEquals("/icons/clicked.png", this.clicked.getSrc());
				Assertions.assertArrayEquals(new int[] {500, 300}, this.clicked.getSize());
				Assertions.assertEquals("absolute", this.clicked.getScaling());
			});
		}
	}
}