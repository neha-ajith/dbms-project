import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
class welcome extends JFrame{
		JLabel l1,l2,l3;
		JTextField t1;
		JPasswordField t2;
		JButton b1,b2,b3,b4;
		welcome(){
			Font f=new Font("Arial",Font.BOLD,20);
			l1=new JLabel("Welcome!");
            l2 = new JLabel("Choose Table.");
			l1.setFont(f);
            l2.setFont(f);
			b1=new JButton("Customer");
            b2=new JButton("Room");
            b3=new JButton("Hotel");
            b4=new JButton("Hotel Location");
			l1.setBounds(110,40,200,40);
            l2.setBounds(80,64,200,40);
			b1.setBounds(100,110,150,30);
            b2.setBounds(100,150,150,30);
            b3.setBounds(100,190,150,30);
            b4.setBounds(100,230,150,30);
			add(l1);
            add(l2);
			add(b1);
            add(b2);
            add(b3);
            add(b4);
			setLayout(null);
			setVisible(true);
			setSize(400,400);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					operationcus opc=new operationcus();
                    opc.setVisible(true);
                    dispose();
				}
			});
            b2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					System.out.println("Button clicked.");
					operationroom opr=new operationroom();
                    opr.setVisible(true);
                    dispose();
				}
			});
            b3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					System.out.println("Button clicked.");
					operationhotel oph=new operationhotel();
                    oph.setVisible(true);
                    dispose();
				}
			});
            b4.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					System.out.println("Button clicked.");
					operationhloc ophl=new operationhloc();
                    ophl.setVisible(true);
                    dispose();
				}
			});
		}
	public static void main(String[] args){
		welcome we = new welcome();
	}
}