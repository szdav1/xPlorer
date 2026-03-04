package theming.declarations;

import lombok.Data;
import lombok.EqualsAndHashCode;
import theming.absproperties.Scalable;

@Data
@EqualsAndHashCode(callSuper = false)
public final class BorderDeclaration extends Scalable implements Declaration {
	private PaintDeclaration foreground;
	private int radius;
}