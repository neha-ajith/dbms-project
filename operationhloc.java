import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
class operationhloc extends JFrame{
		JLabel l1,l2,l3;
		JTextField t1;
		JPasswordField t2;
		JButton b1,b2,b3;
		operationhloc(){
			Font f=new Font("Arial",Font.BOLD,20);
			l1=new JLabel("Welcome!");
            l2 = new JLabel("Choose operation.");
			l1.setFont(f);
            l2.setFont(f);
			b1=new JButton("Add Location");
            b2=new JButton("Delete Location");
            b3=new JButton("Update Location");
			l1.setBounds(110,40,200,40);
            l2.setBounds(80,64,200,40);
			b1.setBounds(100,110,150,30);
            b2.setBounds(100,150,150,30);
            b3.setBounds(100,190,150,30);
			add(l1);
            add(l2);
			add(b1);
            add(b2);
            add(b3);
			setLayout(null);
			setVisible(true);
			setSize(400,400);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					hloc hlo=new hloc();
                	hlo.setVisible(true);
                    dispose();
				}
			});
            b2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					hlocdlt hlodlt=new hlocdlt();
                    hlodlt.setVisible(true);
                    dispose();
				}
			});
            b3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					hlocupd hloupd=new hlocupd();
                    hloupd.setVisible(true);
                    dispose();
				}
			});
		}
	public static void main(String[] args){
		operationhloc op = new operationhloc();
	}
}