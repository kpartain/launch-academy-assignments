import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RectangleTest {
  @Test
  public void JUnit_Works_True() {
    assert(true);
  }
  @Test
  public void calculateArea_2x2_equals4() {
    assertEquals(4, Rectangle.calculateArea(2,2));
  }
  @Test
  public void calculateArea_4x3_equals12() {
    assertEquals(12, Rectangle.calculateArea(4,3));
  }
  @Test
  @DisplayName("2x2=4")
  public void calculateArea_2x2_equals4() {
    assertEquals(4, Rectangle.calculateArea(2,2));
  }
}