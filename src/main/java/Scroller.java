import java.awt.*;
import java.awt.event.MouseEvent;

public class Scroller extends Thread {

    private final Robot robot;

    public Scroller(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            try {
                this.robot.mousePress(MouseEvent.BUTTON2_DOWN_MASK);
                for (int i = 0; i < 10; i++) {
                    this.robot.mouseMove(MouseInfo.getPointerInfo().getLocation().x + 5, MouseInfo.getPointerInfo().getLocation().y);
                    sleep(200);
                }
                for (int i = 0; i < 10; i++) {
                    this.robot.mouseMove(MouseInfo.getPointerInfo().getLocation().x - 5, MouseInfo.getPointerInfo().getLocation().y);
                    sleep(200);
                }
                this.robot.mouseRelease(MouseEvent.BUTTON2_DOWN_MASK);
                sleep(2000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
