package lib.theming.declarations;

import lib.theming.properties.Scalable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public final class BorderDeclaration extends Scalable implements Declaration {
	private PaintDeclaration foreground;
	private int radius;
}