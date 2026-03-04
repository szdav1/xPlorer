package theming.appearance.configs;

import theming.appearance.consts.ScaleType;
import theming.declarations.IconDeclaration;
import theming.declarations.IconDeclaration.IconProperty;

import java.awt.Image;

import javax.swing.ImageIcon;

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

	private ImageIcon normalIcon;
	private ImageIcon hoveredIcon;
	private ImageIcon clickedIcon;

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

	private static ImageIcon loadIcon(final String src, final int width, final int height) {
		return new ImageIcon(new ImageIcon(src).getImage()
			.getScaledInstance(width, height, Image.SCALE_SMOOTH));
	}

	private int determineWidth(final IconData iconData, final int reference) {
		if (iconData.getScaling() == ScaleType.ABSOLUTE)
			return iconData.getSize()[0];

		return reference * iconData.getSize()[0] / 100;
	}

	private int determineHeight(final IconData iconData, final int reference) {
		if (iconData.getScaling() == ScaleType.ABSOLUTE)
			return iconData.getSize()[1];

		return reference * iconData.getSize()[1] / 100;
	}

	public void initIcons(final int wReference, final int hReference) {
		this.normalIcon = loadIcon(
			this.normalConfig.getSrc(),
			this.determineWidth(this.normalConfig, wReference),
			this.determineHeight(this.normalConfig, hReference)
		);

		this.hoveredIcon = loadIcon(
			this.hoveredConfig.getSrc(),
			this.determineWidth(this.hoveredConfig, wReference),
			this.determineHeight(this.hoveredConfig, hReference)
		);

		this.clickedIcon = loadIcon(
			this.clickedConfig.getSrc(),
			this.determineWidth(this.clickedConfig, wReference),
			this.determineHeight(this.clickedConfig, hReference)
		);
	}
}