package lib.theming.appearance.configs;

import lib.theming.appearance.consts.ScaleType;
import lib.theming.declarations.BorderDeclaration;
import lombok.Data;

@Data
public final class BorderConfiguration implements Configuration {
	private ForegroundConfiguration foregroundConfig;
	private int radius;
	private int size;
	private ScaleType scaling;

	public BorderConfiguration(final BorderDeclaration declaration) {
		this.foregroundConfig = new ForegroundConfiguration(declaration.getForeground());
		this.radius = declaration.getRadius();
		this.size = declaration.getSize();
		this.scaling = this.parseScaling(declaration.getScaling());
	}
}