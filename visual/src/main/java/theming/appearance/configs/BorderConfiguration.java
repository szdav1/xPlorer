package theming.appearance.configs;

import theming.appearance.consts.ScaleType;
import theming.declarations.BorderDeclaration;
import lombok.Data;

@Data
public final class BorderConfiguration implements Configuration {
	private ForegroundConfiguration foregroundConfig;
	private int radius;
	private int size;
	private ScaleType scaling;

	public BorderConfiguration() {
		this.foregroundConfig = new ForegroundConfiguration();
		this.radius = 0;
		this.size = 0;
		this.scaling = ScaleType.ABSOLUTE;
	}

	public BorderConfiguration(final BorderDeclaration declaration) {
		this.foregroundConfig = new ForegroundConfiguration(declaration.getForeground());
		this.radius = declaration.getRadius();
		this.size = declaration.getSize();
		this.scaling = this.parseScaling(declaration.getScaling());
	}
}