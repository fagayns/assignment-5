import java.util.regex.*;

public class StringProcessor {

    // Method to check if a password is strong
    public boolean isStrongPassword(String password) {
        if (password == null || password.length() < 8) return false;
        
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpperCase = true;
            if (Character.isLowerCase(ch)) hasLowerCase = true;
            if (Character.isDigit(ch)) hasDigit = true;
            if (!Character.isLetterOrDigit(ch)) hasSpecialChar = true;
        }
        
        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
    }

    // Method to calculate the number of digits in a sentence
    public int calculateDigits(String sentence) {
        if (sentence == null) return 0;
        
        int digitCount = 0;
        for (char ch : sentence.toCharArray()) {
            if (Character.isDigit(ch)) digitCount++;
        }
        
        return digitCount;
    }

    // Method to calculate the number of words in a sentence
    public int calculateWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) return 0;
        
        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }

    // Method to calculate the result of a mathematical expression
    public double calculateExpression(String expression) {
        try {
            return evaluate(expression);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid expression", e);
        }
    }

    // Helper method to evaluate mathematical expression
    private double evaluate(String expression) {
        // Using ScriptEngine for evaluating arithmetic expressions
        try {
            javax.script.ScriptEngineManager mgr = new javax.script.ScriptEngineManager();
            javax.script.ScriptEngine engine = mgr.getEngineByName("JavaScript");
            return (double) engine.eval(expression);
        } catch (Exception e) {
            throw new RuntimeException("Evaluation failed", e);
        }
    }
}


public void testIsStrongPassword() {
    StringProcessor processor = new StringProcessor();

    // Test case 1: Strong password
    assert processor.isStrongPassword("Abcdef1!") == true;
    
    // Test case 2: Missing uppercase letter
    assert processor.isStrongPassword("abcdef1!") == false;
    
    // Test case 3: Missing lowercase letter
    assert processor.isStrongPassword("ABCDEF1!") == false;
    
    // Test case 4: Missing digit
    assert processor.isStrongPassword("Abcdefgh!") == false;
    
    // Test case 5: Missing special character
    assert processor.isStrongPassword("Abcdef12") == false;
}

public void testIsStrongPassword() {
    StringProcessor processor = new StringProcessor();

    // Test case 1: Strong password
    assert processor.isStrongPassword("Abcdef1!") == true;
    
    // Test case 2: Missing uppercase letter
    assert processor.isStrongPassword("abcdef1!") == false;
    
    // Test case 3: Missing lowercase letter
    assert processor.isStrongPassword("ABCDEF1!") == false;
    
    // Test case 4: Missing digit
    assert processor.isStrongPassword("Abcdefgh!") == false;
    
    // Test case 5: Missing special character
    assert processor.isStrongPassword("Abcdef12") == false;
}


public void testCalculateDigits() {
    StringProcessor processor = new StringProcessor();

    // Test case 1: Sentence with digits
    assert processor.calculateDigits("The price is 123 dollars") == 3;
    
    // Test case 2: No digits
    assert processor.calculateDigits("No digits here!") == 0;
    
    // Test case 3: Only digits
    assert processor.calculateDigits("1234567890") == 10;
    
    // Test case 4: Empty string
    assert processor.calculateDigits("") == 0;
    
    // Test case 5: Null input
    assert processor.calculateDigits(null) == 0;
}


public void testCalculateWords() {
    StringProcessor processor = new StringProcessor();

    // Test case 1: Normal sentence
    assert processor.calculateWords("This is a test") == 4;
    
    // Test case 2: Sentence with multiple spaces
    assert processor.calculateWords("   This    is  a   test   ") == 4;
    
    // Test case 3: Empty string
    assert processor.calculateWords("") == 0;
    
    // Test case 4: Single word
    assert processor.calculateWords("Hello") == 1;
    
    // Test case 5: Null input
    assert processor.calculateWords(null) == 0;
}


public void testCalculateExpression() {
    StringProcessor processor = new StringProcessor();

    // Test case 1: Simple expression
    assert processor.calculateExpression("2 + 2") == 4.0;
    
    // Test case 2: Complex expression with multiple operations
    assert processor.calculateExpression("(3 + 2) * 2 - 4 / 2") == 8.0;
    
    // Test case 3: Expression with negative numbers
    assert processor.calculateExpression("-5 + 3") == -2.0;
    
    // Test case 4: Expression with decimal numbers
    assert processor.calculateExpression("2.5 * 4") == 10.0;
    
    // Test case 5: Expression with division
    assert processor.calculateExpression("10 / 2") == 5.0;
}
