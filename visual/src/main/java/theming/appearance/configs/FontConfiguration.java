package theming.appearance.configs;

import java.awt.Font;

import lombok.Data;
import theming.appearance.consts.FontLigature;
import theming.appearance.consts.ScaleType;
import theming.declarations.FontDeclaration;
import theming.declarations.FontDeclaration.FontProperty;

@Data
public final class FontConfiguration implements Configuration {
	@Data
	public final class FontData {
		private String family;
		private FontLigature ligature;
		private int size;
		private ScaleType scaling;

		public FontData() {
			this.family = Font.MONOSPACED;
			this.ligature = FontLigature.NORMAL;
			this.size = 2;
			this.scaling = ScaleType.ABSOLUTE;
		}

		public FontData(final FontProperty property) {
			this.family = property.getFamily();
			this.ligature = FontConfiguration.this.parseLigature(property.getLigature());
			this.size = property.getSize();
			this.scaling = FontConfiguration.this.parseScaling(property.getScaling());
		}
	}

	private FontData normalConfig;
	private FontData hoveredConfig;
	private FontData clickedConfig;

	private Font normalFont;
	private Font hoveredFont;
	private Font clickedFont;

	public FontConfiguration() {
		this.normalConfig = new FontData();
		this.hoveredConfig = new FontData();
		this.clickedConfig = new FontData();
	}

	public FontConfiguration(final FontDeclaration declaration) {
		this.normalConfig = new FontData(declaration.getNormal());
		this.hoveredConfig = new FontData(declaration.getHovered());
		this.clickedConfig = new FontData(declaration.getClicked());
	}

	private int parseLigature(final FontData fontData) {
		return switch (fontData.getLigature()) {
			case BOLD -> Font.BOLD;
			case ITALIC -> Font.ITALIC;
			case BOLD_AND_ITALIC -> Font.BOLD | Font.ITALIC;
			default -> Font.PLAIN;
		};
	}

	private int determineSize(final FontData fontData, final int reference) {
		if (fontData.getScaling() == ScaleType.ABSOLUTE)
			return fontData.getSize();

		return reference * fontData.getSize() / 100;
	}

	public void initFonts(final int reference) {
		this.normalFont = new Font(
			this.normalConfig.getFamily(),
			this.parseLigature(this.normalConfig),
			this.determineSize(this.normalConfig, reference)
		);

		this.hoveredFont = new Font(
			this.hoveredConfig.getFamily(),
			this.parseLigature(this.hoveredConfig),
			this.determineSize(this.hoveredConfig, reference)
		);

		this.clickedFont = new Font(
			this.clickedConfig.getFamily(),
			this.parseLigature(this.clickedConfig),
			this.determineSize(this.clickedConfig, reference)
		);
	}
}