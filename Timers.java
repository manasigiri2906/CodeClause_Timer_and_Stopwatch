import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Timers {
    private static JLabel countdownLabel;

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        // Create and set up the window
        JFrame frame = new JFrame("Countdown Timer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setLayout(new BorderLayout());

        // Create the countdown label
        countdownLabel = new JLabel();
        countdownLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(countdownLabel, BorderLayout.CENTER);

        // Set the timer
        Timer timer = new Timer();// creating instance
        TimerTask task = new TimerTask() {
            int counter = 10;

            @Override
            public void run() {// anonymous inner class
                if (counter > 0) {
                    SwingUtilities.invokeLater(() -> countdownLabel.setText(counter + " seconds "));
                    counter--;
                } else {
                    SwingUtilities.invokeLater(() -> {
                        countdownLabel.setText("Happiest Birthday Pooja💖");
                        timer.cancel();
                    });
                }
            }
        };
        Calendar date = Calendar.getInstance();// creating the instance of calendar
        date.set(Calendar.YEAR, 2023);
        date.set(Calendar.MONTH, Calendar.JULY);
        date.set(Calendar.DAY_OF_MONTH, 26);
        date.set(Calendar.HOUR_OF_DAY, 20);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);

        timer.scheduleAtFixedRate(task, 0, 1000);

        // Display the window
        frame.setVisible(true);
    }
}
