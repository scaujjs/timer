package timer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class ChuangTimer extends JFrame{
	private JButton reset;
	private JButton start;
	private DigitTimer dt;
	private JPanel jp12;
	private JPanel jp60;
	private int screenWidth;
	Thread thread;
	public ChuangTimer(){
		
		dt=new DigitTimer();
        screenWidth=((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);   
		
		this.setLayout(null);
		reset=new JButton("R");
		start=new JButton("S");	
		this.add(reset);
		this.add(start);
		
		reset.addActionListener(new TimeReset());
		start.addActionListener(new StartTiming(this));

		reset.setBounds(50,78,45,20);
		start.setBounds(105,78, 45,20);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		drawNumber();
		this.setAlwaysOnTop(true);
		this.setSize(200, 100);
		this.setLocation(screenWidth-200, 0);
		this.setVisible(true);

	}
	
	public void drawNumber(){
		jp12=new JPanel();
		jp60=new JPanel();
		jp12.setBounds(10,2,93,74);
		jp60.setBounds(105,2,93,74);
		JLabel time12;
		if(dt.rest<10){
			time12=new JLabel("0"+dt.rest+"|");
		}
		else{
			time12=new JLabel(""+dt.rest+"|");
		}
		JLabel time60;
		if(dt.miniutes<10){
				time60=new JLabel("0"+dt.miniutes);
		}
		else{
			time60=new JLabel(""+dt.miniutes);
		}
			
		
		
		jp12.add(time12);
		time12.setFont(new java.awt.Font("Dialog",   1,   60));  

		this.add(jp12);
		
		
		jp60.add(time60);
		time60.setFont(new java.awt.Font("Dialog",   1,   60));  
		if(dt.color=='b'){
			time60.setForeground(Color.black);
		}
		else if(dt.color=='r'){
		
			time60.setForeground(Color.red);
		}
		this.add(jp60);
		

		
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



	class OneThread extends Thread{
		public void run(){
			try{
				while(dt.running){
					this.sleep(1000);
					dt.oneSecond();
					System.out.println(dt.rest+":"+dt.miniutes);

					drawNumber();
					validate();
					
				}
				this.stop();
			}
			catch(Exception ex){
				
			}
			
			}
	}
	
	class StartTiming implements ActionListener{
		ChuangTimer ct;

		
		public StartTiming(ChuangTimer ct){
			this.ct=ct;
		}
		

		
		public void actionPerformed(ActionEvent e){

			if(!dt.running){
			//	Thread start=new Thread(new ThreadOfStartTiming());
				ct.thread =new OneThread();
				System.out.println("Thread");
				dt.running=true;
				thread.start();
					
					
					
				}



			}
		}

		
	}


	class DigitTimer{
		int rest=15;
		int miniutes=60;
		boolean running=false;
		char color='b';
		
		public DigitTimer(){
			
		}
		
		public void reset(){
			this.running=false;
			this.rest=15;
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
						rest=15;
						miniutes=60;
						this.color='b';
					}
					
				}
				
				if(miniutes<=5){
					color='r';
					
				}
			}
		}
		
	}
