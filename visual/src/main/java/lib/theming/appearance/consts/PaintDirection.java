package lib.theming.appearance.consts;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaintDirection {
	LEFT_TO_RIGHT("left_to_right"),
	RIGHT_TO_LEFT("right_to_left"),
	TOP_TO_BOTTOM("top_to_bottom"),
	BOTTOM_TO_TOP("bottom_to_top"),

	DIAGONAL_TOP_TO_RIGHT("diagonal_top_to_right"),
	DIAGONAL_TOP_TO_LEFT("diagonal_top_to_left"),
	DIAGONAL_BOTTOM_TO_RIGHT("diagonal_bottom_to_right"),
	DIAGONAL_BOTTOM_TO_LEFT("diagonal_bottom_to_left");

	private final String value;
}