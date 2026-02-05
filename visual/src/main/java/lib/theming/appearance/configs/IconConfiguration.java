package lib.theming.appearance.configs;

import lib.theming.appearance.consts.ScaleType;
import lib.theming.declarations.IconDeclaration;
import lib.theming.properties.IconProperty;
import lombok.Data;

@Data
public final class IconConfiguration implements Configuration {

	@Data
	public final class IconData {
		private String src;
		private int[] size;
		private ScaleType scaling;

		public IconData() {
			this.src = "";
			this.size = new int[] {0, 0};
			this.scaling = ScaleType.ABSOLUTE;
		}

		public IconData(final IconProperty property) {
			this.src = property.getSrc();
			this.size = property.getSize();
			this.scaling = IconConfiguration.this.parseScaling(property.getScaling());
		}
	}

	private IconData normalConfig;
	private IconData hoveredConfig;
	private IconData clickedConfig;

	public IconConfiguration() {
		this.normalConfig = new IconData();
		this.hoveredConfig = new IconData();
		this.clickedConfig = new IconData();
	}

	public IconConfiguration(final IconDeclaration declaration) {
		this.normalConfig = new IconData(declaration.getNormal());
		this.hoveredConfig = new IconData(declaration.getHovered());
		this.clickedConfig = new IconData(declaration.getClicked());
	}
}