package test.test;

import java.util.ArrayList;
import java.util.Date;

public class MockMp3Player implements Mp3Player {
	private ArrayList<String> list = new ArrayList<String>();
	private Date startTimer;
	private Date endTimer;
	private int seconds=0;
	private String currentSong;
	private int iterator=0;
	private boolean playing=true;
	
    public void play(){
    	if(list.size()>0){
    	startTimer= new Date();
    	playing=true;
    	iterator=0;
    	currentSong=list.get(0);
    	}
    	else{
    		throw new NullPointerException();
    	}
    }
    
    /** 
    * Wstrzymaj odtwarzanie. Odtwarzanie bedzie 
    * pozniej wznowione od tego miejsca.
    */
    public void pause(){
    	if(list.size()>0){
    	endTimer = new Date();
    	playing=false;
    	seconds = seconds + (int)((endTimer.getTime() - startTimer.getTime()) / 1000);
    	}
    	else{
    		throw new NullPointerException();
    	}
    }
    
    /** 
    * Zatrzymaj odtwarzanie. Biezacy utwor pozostaje
    * na szczycie listy, ale odtwarzanie zostanie
    * wznowione od jego poczatku.
    */
    public void stop(){
    	if(list.size()>0){
	    	playing=false;
	    	seconds =0;
    	}
    	else throw new NullPointerException();
    	
    }
    
    /** Zwraca liczbe sekund od poczatku 
    * biezacego utworu.
    */
    public double currentPosition(){
    	endTimer = new Date();
    	seconds = seconds + (int)((endTimer.getTime() - startTimer.getTime()) / 1000);
    	return seconds;
    	
    }
    
    /**
    * Zwraca nazwe odtwarzanego pliku.
    */
    public String currentSong(){
    	return currentSong;
    	
    }
    
    /** 
    * Przechodzi do nastepnego utworu na liscie 
    * i rozpoczyna jego odtwarzanie.
    */
    public void next(){
    	startTimer= new Date(); 
    	playing=true;
    	seconds=0;
    	iterator++;
    	if(iterator>list.size()-1) iterator=0;
    	currentSong=list.get(iterator);
    	
    }
    
    /**
    * Wraca do poprzedniego utworu na liscie 
    * i rozpoczyna jego odtwarzanie.
    */
    public void prev(){
    	startTimer= new Date();  
    	playing=true;
    	seconds=0;
    	iterator--;
    	if(iterator<0) iterator=list.size()-1;
    	currentSong=list.get(iterator);
    }
    
    /** 
    * Zwraca true gdy odtwarzany jest utwor. 
    */
    public boolean isPlaying(){
    	return playing;
    }
    
    /**
    * Laduje pliki na liste utworow.
    */
    public void loadSongs(ArrayList<String> names){
    	list=names;  	
    }
    public ArrayList<String> getList(){
    	return list;
    }

}
