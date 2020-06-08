package media_pack;

	import java.awt.event.ActionEvent;

	import java.awt.event.ActionListener;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JTextField;
	
class ExchangeFrame extends JFrame{
	    private JTextField textfield;
	    private JButton btn;
	    private JLabel resultLabel;
	    private double won=1207;
	    private ExchangeFrame() {
	        JPanel panel = new JPanel();
	        
	        textfield = new JTextField(10);
	        btn = new JButton("변환");
	        btn.addActionListener(new ExchangeAction());
	        resultLabel = new JLabel("?");
	        
	        panel.add(textfield);
	        panel.add(btn);
	        panel.add(resultLabel);
	        
	        setTitle("title");
	        setSize(500,500);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setVisible(true);
	        
	        this.add(panel);
	    }
	    class ExchangeAction implements ActionListener {
	 
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            double num = Double.parseDouble(textfield.getText()); 
	            resultLabel.setText(""+num*won);
	        }
	    }
	    public static void main(String[] args) {
	        new ExchangeFrame();
	    }
	}
