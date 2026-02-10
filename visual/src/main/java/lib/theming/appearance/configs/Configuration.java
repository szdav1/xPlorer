package lib.theming.appearance.configs;

import lib.theming.appearance.consts.PaintDirection;
import lib.theming.appearance.consts.ScaleType;

public interface Configuration {
	default ScaleType parseScaling(final String scaling) {
		try {
			return ScaleType.valueOf(scaling.toUpperCase());
		}
		catch (Exception exc) {
			return ScaleType.RELATIVE;
		}
	}

	default PaintDirection parseDirection(final String direction) {
		try {
			return PaintDirection.valueOf(direction.toUpperCase());
		}
		catch (Exception exc) {
			return PaintDirection.LEFT_TO_RIGHT;
		}
	}
}