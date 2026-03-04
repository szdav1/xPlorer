package theming.declarations;

import lombok.Data;
import lombok.EqualsAndHashCode;
import theming.absproperties.Scalable2D;

@Data
public final class IconDeclaration implements Declaration {
	@Data
	@EqualsAndHashCode(callSuper = false)
	public final class IconProperty extends Scalable2D {
		private String src;
	}

	private IconProperty normal;
	private IconProperty hovered;
	private IconProperty clicked;
}