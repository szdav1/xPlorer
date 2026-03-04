package theming.appearance.configs;

import theming.appearance.consts.FontLigature;
import theming.appearance.consts.PaintDirection;
import theming.appearance.consts.ScaleType;

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

	default FontLigature parseLigature(final String ligature) {
		try {
			return FontLigature.valueOf(ligature.toUpperCase());
		}
		catch (Exception exc) {
			return FontLigature.NORMAL;
		}
	}
}