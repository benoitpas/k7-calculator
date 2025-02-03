import org.junit.Test
import org.junit.Assert._

class CalculatorTest {
  @Test def rms() : Unit = {
    assertEquals(math.sqrt(2), Calculator.rms(List(1, 2, 3)), 0) 
  }

  @Test def rmsK7() : Unit = {
    assertEquals(1/math.sqrt(72), Calculator.rmsK7(List(1,2,3)), 0) 
  }

  @Test def allCombinations() : Unit = {
    assertEquals(List(List(1, 1, 4), List(1, 2, 3), List(2, 2, 2)), Calculator.allCombinations(1,6,3)) 
    assertEquals(List(List(2, 2, 2)), Calculator.allCombinations(2,6,3)) 
  }

  @Test def toCogs() : Unit = {
    assertEquals(List(12, 13, 14, 18), Calculator.toCogs(12, List(1, 1, 4)))
  }

  @Test def listBestK7() : Unit = {
    assertEquals((0.04212070417570931,List(12, 14, 16, 18, 20, 22, 25, 28)), Calculator.listBestK7(12,28,8).head)
  }
}
