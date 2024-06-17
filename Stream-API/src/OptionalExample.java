
import java.util.Optional;
public class OptionalExample {
    public static void main(String[] args) {
        // Creating an Optional with a null value
       Optional<String> optionalValue = Optional.ofNullable(null);

        // Using orElse to provide a default value if optionalValue is empty
        String result = optionalValue.orElse("Default");

        // Printing the result
        System.out.println(result); // Output: Default
    }
}
