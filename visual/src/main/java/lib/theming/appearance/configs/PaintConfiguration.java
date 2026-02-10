package lib.theming.appearance.configs;

import java.awt.Color;

import lib.theming.appearance.consts.PaintDirection;
import lib.theming.declarations.PaintDeclaration;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
public abstract class PaintConfiguration implements Configuration {
	@Data
	public final static class PaintData {
		@Setter(AccessLevel.NONE)
		private Color[] colors;

		@Setter(AccessLevel.NONE)
		private float[] fractions;

		public PaintData(final String[] colorStrs) {
			this.colors = this.parseColors(colorStrs);
			this.fractions = this.parseFractions(colorStrs);
		}

		private Color advancedColorDecode(final String colorStr) {
			try {
				return Color.decode(colorStr);
			}
			catch (Exception exc) {
				return Color.black;
			}
		}

		private Color[] parseColors(final String[] colorStrs) {
			if (colorStrs == null || colorStrs.length == 0)
				return new Color[] {Color.black, Color.black};

			else if (colorStrs.length == 1)
				return new Color[] {this.advancedColorDecode(colorStrs[0]), this.advancedColorDecode(colorStrs[0])};

			Color[] colors = new Color[colorStrs.length];

			for (int i = 0; i < colorStrs.length; i++)
				colors[i] = this.advancedColorDecode(colorStrs[i]);

			return colors;
		}

		private float[] parseFractions(final String[] colorStrs) {
			if (colorStrs == null || colorStrs.length == 0 || colorStrs.length == 1)
				return new float[] {0.0F, 1.0F};

			float[] fractions = new float[colorStrs.length];
			float step = 1.0F / fractions.length;
			int iterator = 0;

			for (float i = 0.0F; i < 1.0F; i += step) {
				fractions[iterator] = i;
				iterator++;
			}

			fractions[fractions.length - 1] = 1.0F;

			return fractions;
		}
	}

	private PaintData normalConfig;
	private PaintData hoveredConfig;
	private PaintData clickedConfig;
	private PaintDirection direction;

	public PaintConfiguration() {
		this.normalConfig = new PaintData(new String[] {"#000000", "#000000"});
		this.hoveredConfig = new PaintData(new String[] {"#000000", "#000000"});
		this.clickedConfig = new PaintData(new String[] {"#000000", "#000000"});
		this.direction = PaintDirection.LEFT_TO_RIGHT;
	}

	public PaintConfiguration(final PaintDeclaration declaration) {
		this.normalConfig = new PaintData(declaration.getNormal());
		this.hoveredConfig = new PaintData(declaration.getHovered());
		this.clickedConfig = new PaintData(declaration.getClicked());
		this.direction = this.parseDirection(declaration.getDirection());
	}
}