package lib.theming.declarations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

// TODO: Make declaration tests one nested unit test like appearance test
// for consistency and sake of logic
class BorderDeclarationTest {
	@ParameterizedTest
	@ValueSource(ints = {10, 6, -8})
	@DisplayName("BorderDeclaration should use the values provided via setters")
	void borderDeclarationShouldUseGivenData(int intValue) {
		BorderDeclaration bd = new BorderDeclaration();
		bd.setRadius(intValue);
		bd.setSize(intValue);
		bd.setScaling("absolute");

		Assertions.assertAll(() -> {
			Assertions.assertEquals(intValue, bd.getRadius());
			Assertions.assertEquals(intValue, bd.getSize());
			Assertions.assertEquals("absolute", bd.getScaling());
		});
	}
}