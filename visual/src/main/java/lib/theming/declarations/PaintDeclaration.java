package lib.theming.declarations;

import lombok.Data;

@Data
public final class PaintDeclaration implements Declaration {
	private String[] normal;
	private String[] hovered;
	private String[] clicked;
	private String direction;
}