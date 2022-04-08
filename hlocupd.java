import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
class hlocupd extends JFrame{
		JLabel l1,l2,l3,l4;
		JTextField t1,t2;
		JButton b1;
		hlocupd(){
			Font f=new Font("Arial",Font.BOLD,24);
			l1=new JLabel("HotelLocation");
            l4=new JLabel("Update");
			l1.setFont(f);
            l4.setFont(f);
			l2=new JLabel("Hloc");
			t1=new JTextField();
			l3=new JLabel("HID");
			t2=new JTextField();
			b1=new JButton("OK");
            l1.setBounds(70,20,200,40);
			l4.setBounds(70,40,200,40);
			l2.setBounds(70,100,100,20);//UserName Label
			t1.setBounds(70,120,200,30);//TextField 
			l3.setBounds(70,170,100,20);
			t2.setBounds(70,190,200,30);
			b1.setBounds(170,240,100,30);
			add(l1);
			add(l2);
			add(t1);
			add(l3);
			add(t2);
            add(l4);
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
		hlocupd hlupd=new hlocupd();
	}
}