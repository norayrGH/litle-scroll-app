import java.awt.Robot;

public class Scroller extends Thread {

  private final Robot robot;

  public Scroller(Robot robot) {
    this.robot = robot;
  }

  @Override
  public void run() {
    while (!this.isInterrupted()) {
      this.robot.mouseWheel(100);
      try {
        sleep(3000);
      } catch (InterruptedException e) {
        break;
      }
      this.robot.mouseWheel(-200);
    }
  }

}
