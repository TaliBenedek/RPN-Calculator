import org.junit.Assert;
import org.junit.Test;

public class RPNTest {
    @Test
    public void testLogicalExpression()
    {
        Assert.assertEquals("5.0",RPNEvaluator.evaluate("2 3 +"));
    }

    @Test
    public void testTooFewOperands()
    {
        Assert.assertEquals("Not enough operands",RPNEvaluator.evaluate("2 3 + +"));
    }

    @Test
    public void testIllegalSymbol()
    {
        Assert.assertEquals("Illegal symbol(s)",RPNEvaluator.evaluate("jbkjb"));
    }

    @Test
    public void testTooManyOperands()
    {
        Assert.assertEquals("Too many operands or not enough operators",RPNEvaluator.evaluate("2 3 4 +"));
    }
}
