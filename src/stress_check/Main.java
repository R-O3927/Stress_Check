package stress_check;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//継承かつ実装
class Main extends JFrame implements ActionListener{
	
	JCheckBox[] check;
	
	public static void main(String[] args) {
		
		//インスタンスの作成（実体を持たせる）
		Main frame = new Main("Strees Check β版");
		frame.setVisible(true);
	}
	
	Main(String title){
		setTitle(title);
		setBounds(100, 100, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		check = new JCheckBox[3];
		check[0] = new JCheckBox("憂鬱");
		check[1] = new JCheckBox("気分が沈む");
		check[2] = new JCheckBox("訳もなく泣いてしまう");
		
		JPanel p = new JPanel();
		p.add(check[0]);
		p.add(check[1]);
		p.add(check[2]);
		
		JButton button = new JButton("ストレスチェック");
		button.addActionListener(this);
		
		JPanel button_panel = new JPanel();
		button_panel.add(button);
		
		Container contentPane = getContentPane();
		contentPane.add(p, BorderLayout.CENTER);
		contentPane.add(button_panel, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e) {
		StringBuilder sb = new StringBuilder();
		int stress_point = 0;
		
		for(int i = 0; i< check.length; i++) {
			sb.append(check[i].getText());
			
			if(check[i].isSelected()) {
				stress_point++;
			}
		}
		
		JOptionPane.showMessageDialog(this, "貴方のストレス度合は" + stress_point + "点です。", "チェック結果", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
	
	

	
	
	
	
	

