package lib.theming.declarations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class PaintDeclaration implements Declaration {
	private String[] normal;
	private String[] hovered;
	private String[] clicked;
	private String direction;
}