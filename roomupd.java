import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
class roomupd extends JFrame{
		JLabel l1,l2,l3,l4,l5,l6,l7,l8;
		JTextField t1,t2,t3,t4,t5,t6,t7;
		JButton b1;
		roomupd(){
			Font f=new Font("Arial",Font.BOLD,24);
			l1=new JLabel("Roomupdate");
			l1.setFont(f);
			l2=new JLabel("Roomno");
			t1=new JTextField();
			l3=new JLabel("Rent");
			t2=new JTextField();
			l4=new JLabel("RCID");
			t3=new JTextField();
			l5=new JLabel("RHID");
			t4=new JTextField();
			l6=new JLabel("PID");
			t5=new JTextField();
            l7=new JLabel("PAmount");
			t6=new JTextField();
            l8=new JLabel("BID");
			t7=new JTextField();
			b1=new JButton("OK");
			l1.setBounds(70,40,200,40);
			l2.setBounds(70,100,100,20);//UserName Label
			t1.setBounds(70,120,200,30);//TextField 
			l3.setBounds(70,170,100,20);
			t2.setBounds(70,190,200,30);
			l4.setBounds(70,240,100,20);
			t3.setBounds(70,260,200,30);
			l5.setBounds(70,310,100,20);
			t4.setBounds(70,330,200,30);
			l6.setBounds(70,380,100,20);
			t5.setBounds(70,400,200,30);
            l7.setBounds(70,450,100,20);
			t6.setBounds(70,470,200,30);
            l8.setBounds(70,520,100,20);
			t7.setBounds(70,540,200,30);
			b1.setBounds(170,590,100,30);
			add(l1);
			add(l2);
			add(t1);
			add(l3);
			add(t2);
			add(l4);
			add(t3);
            add(l5);
			add(t4);
			add(l6);
			add(t5);
            add(l7);
			add(t6);
            add(l8);
			add(t7);
			add(b1);
			setLayout(null);
			setVisible(true);
			setSize(400,700);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					JOptionPane.showMessageDialog(t4, "The updated row is \nRoomNo = "+t1.getText()+"\nRent = "+t2.getText()+
													"\nRCID = "+t3.getText()+"\nRHID = "+t4.getText()+"\nPID = "+t5.getText()
													+"\nPAmount = "+t6.getText()+"\nBID = "+t7.getText());
				}
			});
		}
	public static void main(String[] args){
		roomupd rupd=new roomupd();
	}
}