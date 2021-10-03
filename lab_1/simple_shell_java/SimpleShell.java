import java.io.InputStreamReader;
import java.util.Scanner;


public class SimpleShell {
    private static Runtime r = Runtime.getRuntime();
    private static final String shellName = "simpleJsh 😆 ➜ ";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        var currentPathArr = System.getProperty("user.dir").split("\\/");
        var currentDir = currentPathArr[currentPathArr.length - 1];
        var shell = String.format("%s%s%s%s%s%s ", ANSI_CYAN, shellName, ANSI_RESET, ANSI_RED, currentDir, ANSI_RESET);
        System.out.print(shell);

        startShell(shell);
    }

    private static void startShell(String shell) {
        try (Scanner keyboard = new Scanner(System.in);) {
            while (keyboard.hasNext()) {
                var cmd = "";
                cmd += String.format("%s", keyboard.nextLine());
                System.out.printf("⛏️  Executing cmd: %s%s%s... ⛏️ \n\n", ANSI_GREEN, cmd, ANSI_RESET);
                if (cmd.trim().toUpperCase().equals("EXIT")) {
                    r.exit(0);
                }
                try {
                    Process childP = r.exec(cmd);
                    printChildProcessOutput(childP);
                    childP.waitFor();
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
                System.out.print(shell);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private static void printChildProcessOutput(Process childP) {
        var errorInputStream = new InputStreamReader(childP.getErrorStream());
        try (var errorScanner = new Scanner(errorInputStream);) {
            while(errorScanner.hasNext()) {
                System.out.printf("%s \n", errorScanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        var sussessInputStream = new InputStreamReader(childP.getInputStream());
        try (var sussessScanner = new Scanner(sussessInputStream);) {
            while(sussessScanner.hasNext()) {
                System.out.printf("%s \n", sussessScanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}