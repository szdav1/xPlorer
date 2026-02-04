package lib.theming.properties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public final class FontProperty extends Scalable {
	private String family;
	private String ligature;
}