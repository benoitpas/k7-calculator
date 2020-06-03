import org.junit.Test
import org.junit.Assert._

class CalculatorTest {
  @Test def rms(): Unit = {
    assertEquals(Calculator.rms(List(1,2,3)),math.sqrt(2),0) 
    assertEquals("I was compiled by dotty :)", Main.msg)
  }
}