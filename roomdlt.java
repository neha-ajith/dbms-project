import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
class roomdlt extends JFrame{
		JLabel l1,l2;
		JTextField t1;
		JButton b1;
		roomdlt(){
			Font f=new Font("Arial",Font.BOLD,24);
			l1=new JLabel("Room");
			l1.setFont(f);
			l2=new JLabel("RCID");
			t1=new JTextField();
			b1=new JButton("Delete");
			l1.setBounds(70,40,200,40);
			l2.setBounds(70,100,100,20);//UserName Label
			t1.setBounds(70,120,200,30);//TextField 
			b1.setBounds(170,170,100,30);
			add(l1);
			add(l2);
			add(t1);
			add(b1);
			setLayout(null);
			setVisible(true);
			setSize(400,400);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					System.out.println(t1.getText());
				}
			});
		}
	public static void main(String[] args){
	    roomdlt rdlt=new roomdlt();
	}
}