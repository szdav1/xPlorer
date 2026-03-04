package theming.declarations;

import lombok.Data;
import lombok.EqualsAndHashCode;
import theming.absproperties.Scalable;

@Data
public final class FontDeclaration implements Declaration {
	@Data
	@EqualsAndHashCode(callSuper = false)
	public final class FontProperty extends Scalable {
		private String family;
		private String ligature;
	}
	
	private FontProperty normal;
	private FontProperty hovered;
	private FontProperty clicked;
}