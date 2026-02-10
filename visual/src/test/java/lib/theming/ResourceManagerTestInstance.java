package lib.theming;

import java.net.URL;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.NONE)
public class ResourceManagerTestInstance {
	public static String load(final String path) {
		URL pathURL = ResourceManagerTestInstance.class.getResource("/" + path);

		if (pathURL == null) 
			return "";

		return pathURL.getFile();
	}
}