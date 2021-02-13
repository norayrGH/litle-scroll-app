import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.simplenativehooks.NativeHookInitializer;
import org.simplenativehooks.NativeKeyHook;
import org.simplenativehooks.events.NativeKeyEvent;
import staticResources.BootStrapResources;
import utilities.Function;

public class KeyListener {

private static Thread scroll;
  public static void main(String[] args) {
    try {
      BootStrapResources.extractResources();

      NativeHookInitializer.of().start();
      Robot robot = new Robot();
      NativeKeyHook key = NativeKeyHook.of();
      key.setKeyPressed(new Function<>() {
        @Override
        public Boolean apply(NativeKeyEvent d) {

          if (d.getKey() == KeyEvent.VK_F7) {
            System.out.println("F7");
            scroll = new Scroller(robot);
            scroll.start();
          }
          if (d.getKey() == KeyEvent.VK_F8) {
            System.out.println("F8");
            scroll.interrupt();
          }
          return true;
        }
      });
      key.startListening();
    } catch (AWTException | IOException e) {
      e.printStackTrace();
    }

  }
}

