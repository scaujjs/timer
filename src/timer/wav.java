package timer;

import java.io.FileInputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class wav{
	public static void main(String[] args){
   	try{
		FileInputStream file=new FileInputStream("8615.wav");
		AudioStream as=new AudioStream(file);
        AudioPlayer.player.start(as);  

		
	}
	catch(Exception e){
		System.err.print(e);
		e.printStackTrace();		
	}

}
	}