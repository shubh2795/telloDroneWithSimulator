import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.jfree.chart.*;

public class TelloGUI {
    private JPanel TelloDroneGUI;
    private JTextField DroneStatusText;
    private JTextField BatteryStatusText;
    private JTextField DroneSpeedText;
    private JTextField FlightTimeText;
    private JTextField EnterCommandText;
    private JButton sendButton;


    public TelloGUI() {

        DroneStatusText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        FlightTimeText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        BatteryStatusText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        DroneSpeedText.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {

            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("TelloGUI");
        frame.setContentPane(new TelloGUI().TelloDroneGUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
