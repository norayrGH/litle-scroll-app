import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Scroller extends Thread {

  private final Robot robot;

  public Scroller(Robot robot) {
    this.robot = robot;
  }

  @Override
  public void run() {
    while (!this.isInterrupted()) {
      this.robot.keyPress(KeyEvent.VK_SPACE);
      this.robot.mousePress(MouseEvent.BUTTON1);
      this.robot.mouseMove(MouseInfo.getPointerInfo().getLocation().x+100, MouseInfo.getPointerInfo().getLocation().y);
      try {
        sleep(2000);
      } catch (InterruptedException e) {
        break;
      }
      this.robot.mouseMove(MouseInfo.getPointerInfo().getLocation().x-50, MouseInfo.getPointerInfo().getLocation().y);
      this.robot.mouseRelease(MouseEvent.BUTTON1);
      this.robot.keyRelease(KeyEvent.VK_SPACE);
    }
  }

}
