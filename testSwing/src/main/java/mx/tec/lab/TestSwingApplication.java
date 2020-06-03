package mx.tec.lab;

import javax.swing.*;
import java.awt.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SuppressWarnings("serial")
@SpringBootApplication
public class TestSwingApplication extends JFrame {
	protected JLabel numberOneLabel;
    protected JLabel numberTwoLabel;
    protected JLabel resultLabel;
    protected JTextField numberOneTextField;
    protected JTextField numberTwoTextField;
    protected JButton operationButton;
    protected JTextField resultTextField;

	
	public TestSwingApplication() {
		super("Swing Example");
		initUI();
		createLayout();
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder((TestSwingApplication.class))
                .headless(false).run(args);

        EventQueue.invokeLater(() -> {
            TestSwingApplication application = context.getBean(TestSwingApplication.class);
            application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            application.setSize(500, 100);
            application.setVisible(true);
        });
    }

    private void initUI() {
        numberOneLabel = new JLabel("Number 1");
        numberTwoLabel = new JLabel("Number 2");
        resultLabel = new JLabel("Result:", JLabel.CENTER);
        numberOneTextField = new JTextField(5);
        numberTwoTextField = new JTextField(5);

        resultTextField = new JTextField(5);
        resultTextField.setEditable(false);

        operationButton = new JButton("sum");
        operationButton.addActionListener(e -> {
            boolean correct = true;
            int a = 0;
            int b = 0;

            try {
                a = Integer.parseInt(numberOneTextField.getText());
            } catch (Exception ex) {
                correct = false;
                numberOneTextField.setText("");
            }

            try {
                b = Integer.parseInt(numberTwoTextField.getText());
            } catch (Exception ex) {
                correct = false;
                numberTwoTextField.setText("");
            }
            if(correct) {
                int c = a + b;
                resultTextField.setText(String.valueOf(c));
            } else {
                resultTextField.setText("");
            }

        });
    }

    private void createLayout() {
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        container.add(numberOneLabel);
        container.add(numberOneTextField);
        container.add(numberTwoLabel);
        container.add(numberTwoTextField);
        container.add(operationButton);
        container.add(resultLabel);
        container.add(resultTextField);
    }

}
