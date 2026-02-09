package validation;

import java.util.HashSet;
import java.util.List;

public class DropdownValidator {
	
	// DropdownValidator.java
		public static boolean hasDuplicateValues(List<String> values) {
		    return values.size() != new HashSet<>(values).size();
		}
}
