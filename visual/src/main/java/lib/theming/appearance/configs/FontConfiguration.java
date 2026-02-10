package lib.theming.appearance.configs;

import java.awt.Font;

import lib.theming.appearance.consts.ScaleType;
import lib.theming.declarations.FontDeclaration;
import lib.theming.properties.FontProperty;
import lombok.Data;

@Data
public final class FontConfiguration implements Configuration {
	@Data
	public final class FontData {
		private String family;
		private String ligature;
		private int size;
		private ScaleType scaling;

		public FontData() {
			this.family = Font.MONOSPACED;
			this.ligature = "normal";
			this.size = 2;
			this.scaling = ScaleType.ABSOLUTE;
		}

		public FontData(final FontProperty property) {
			this.family = property.getFamily();
			this.ligature = property.getLigature();
			this.size = property.getSize();
			this.scaling = FontConfiguration.this.parseScaling(property.getScaling());
		}
	}

	private FontData normalConfig;
	private FontData hoveredConfig;
	private FontData clickedConfig;

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
}