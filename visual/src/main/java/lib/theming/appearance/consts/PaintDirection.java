package lib.theming.appearance.consts;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaintDirection {
	LEFT_TO_RIGHT("left-to-right"),
	RIGHT_TO_LEFT("right-to-left"),
	TOP_TO_BOTTOM("top-to-bottom"),
	BOTTOM_TO_TOP("bottom-to-top"),

	DIAGONAL_TOP_TO_RIGHT("diagonaltop-to-right"),
	DIAGONAL_TOP_TO_LEFT("diagonal-top-to-left"),
	DIAGONAL_BOTTOM_TO_RIGHT("diagonal-bottom-to-right"),
	DIAGONAL_BOTTOM_TO_LEFT("diagonal-bottom-to-left");

	private final String value;
}