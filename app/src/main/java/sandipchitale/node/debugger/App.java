/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package sandipchitale.node.debugger;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;

public class App {

    public static void main(String[] args) {
       new App().run(args);
    }

    private void run(String[] args) {
        try {
            Process chrome = new ProcessBuilder()
                    .command(
                            "google-chrome",
                            "--incognito",
                            "--new-window",
                            "-no-first-run",
                            "--window-size=700,450",
                            "--user-data-dir=" + Files.createTempDirectory("chrome-user-data-dir").toFile().getAbsolutePath()
                    )
                    .start();
            Robot robot = new Robot();
            robot.delay(1000);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            type(robot, "chrome");
            robot.keyPress(KeyEvent.VK_COLON);
            robot.keyRelease(KeyEvent.VK_COLON);
            type(robot, "//inspect");

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            robot.delay(500);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_F);
            robot.keyRelease(KeyEvent.VK_F);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            type(robot, "Open");
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_SPACE);
            type(robot, "dedicated");

            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            robot.delay(20);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_W);
            robot.keyRelease(KeyEvent.VK_W);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        } catch (IOException | AWTException e) {
            throw new RuntimeException(e);
        }
    }

    private static void type(Robot robot, String s)
    {
        byte[] bytes = s.getBytes();
        for (byte b : bytes)
        {
            int code = b;
            // keycode only handles [A-Z] (which is ASCII decimal [65-90])
            if (code > 96 && code < 123) code = code - 32;
            robot.delay(40);
            robot.keyPress(code);
            robot.keyRelease(code);
        }
    }
}
