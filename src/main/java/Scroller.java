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
            this.robot.mousePress(MouseEvent.BUTTON2_DOWN_MASK);
            this.robot.mouseMove(MouseInfo.getPointerInfo().getLocation().x + 100, MouseInfo.getPointerInfo().getLocation().y);
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                break;
            }
            this.robot.mouseMove(MouseInfo.getPointerInfo().getLocation().x - 100, MouseInfo.getPointerInfo().getLocation().y);
            this.robot.mouseRelease(MouseEvent.BUTTON2_DOWN_MASK);
        }
    }

}
