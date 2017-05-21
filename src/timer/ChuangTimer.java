package timer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class ChuangTimer extends JFrame{
	private JButton reset;
	private JButton start;
	private Timer timer;
	private DigitTimer dt;

	public ChuangTimer(){
		
		dt=new DigitTimer();
        int screenWidth=((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);   
		timer=new Timer();
		
		this.setLayout(null);
		reset=new JButton("R");
		start=new JButton("S");	
		this.add(reset);
		this.add(start);
		
		reset.addActionListener(new TimeReset());
		start.addActionListener(new StartTiming(this));

		reset.setBounds(50,78,45,20);
		start.setBounds(105,78, 45,20);
		JPanel jp12=new JPanel();
		JPanel jp60=new JPanel();
		JLabel time12=new JLabel(""+dt.rest+"|");
		JLabel time60=new JLabel(""+dt.miniutes);
		
		jp12.setBounds(10,2,93,74);
		jp12.add(time12);
		time12.setFont(new java.awt.Font("Dialog",   1,   60));  

		this.add(jp12);
		
		jp60.setBounds(105,2,93,74);
		jp60.add(time60);
		time60.setFont(new java.awt.Font("Dialog",   1,   60));  
		if(dt.color=='b'){
			time60.setForeground(Color.black);
		}
		else if(dt.color=='r'){
		
			time60.setForeground(Color.red);
		}
		this.add(jp60);
		
		
		this.setSize(200, 100);
		this.setLocation(screenWidth-200, 0);
		this.setVisible(true);
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChuangTimer();
		
	}
	
	class TimeReset implements ActionListener{

		
		public TimeReset(){

		}
		public void actionPerformed(ActionEvent e){
			dt.reset();
		}
		
	}

	class OneSecondTask extends TimerTask{
		private ChuangTimer ct;
		
		public OneSecondTask(ChuangTimer ct){
			this.ct=ct;
		}
		public void run(){
			dt.oneSecond();
			ct.repaint();
			System.out.println("Point1");
			System.out.print
		}
	}
	
	
	class StartTiming implements ActionListener{
		ChuangTimer ct;

		
		public StartTiming(ChuangTimer ct){
			this.ct=ct;
		}
		
		public void actionPerformed(ActionEvent e){
			System.out.println("Point1");
			dt.running=true;
			while(dt.running){
				timer.schedule(new OneSecondTask(ct), 1000);
			}
		}

		
	}
} 

	class DigitTimer{
		int rest=12;
		int miniutes=60;
		boolean running=false;
		char color='b';
		
		public DigitTimer(){
			
		}
		
		public void reset(){
			this.running=false;
			this.rest=12;
			this.miniutes=60;
			this.color='b';
			
		}
		
		public void oneSecond(){
			if(running){
				if(rest>0){
					rest--;
				}
				else{
					if(miniutes>0){
						miniutes--;
					}
					else{
						rest=12;
						miniutes=60;
					}
					
				}
				
				if(miniutes<=5){
					color='r';
					
				}
			}
		}
		
	}


class Windows{
	private Point x1,x2,x3,x4; 
	int number;
	int color;
	
	public Windows(int upperY,int lowwerY,int leftX, int rightX){
		x1=new Point(leftX,upperY);
		x2=new Point(rightX,upperY);
		x3=new Point(leftX,lowwerY);
		x4=new Point(rightX,lowwerY);
		
		
	}
	
}