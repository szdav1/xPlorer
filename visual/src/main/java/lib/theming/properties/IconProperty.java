package lib.theming.properties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public final class IconProperty extends Scalable2D {
	private String src;
}