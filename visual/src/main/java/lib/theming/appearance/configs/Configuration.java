package lib.theming.appearance.configs;

import lib.theming.appearance.consts.ScaleType;

public interface Configuration {
	default ScaleType parseScaling(final String scaling) {
		return switch (scaling.toUpperCase()) {
			case "ABSOLUTE" -> ScaleType.ABSOLUTE;
			default -> ScaleType.RELATIVE;
		};
	}
}