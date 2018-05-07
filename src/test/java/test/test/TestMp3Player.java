package test.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

  public class TestMp3Player {

    private Mp3Player mp3;
    private ArrayList<String> list = new ArrayList<String>();

    @Before
      public void setUp() {
      mp3 = new MockMp3Player();
      list = new ArrayList<String>();
      list.add("Bill Chase -- Open Up Wide");
      list.add("Jethro Tull -- Locomotive Breath");
      list.add("The Boomtown Rats -- Monday");
      list.add("Carl Orff -- O Fortuna");
    }

    @Test
    public void testPlay() {

      mp3.loadSongs(list);
      	assertEquals(mp3.getList(),list);
      mp3.play();
       assertEquals(mp3.currentSong(),list.get(0));
      mp3.pause();
      	assertFalse(mp3.isPlaying());
      mp3.stop();
      	assertFalse(mp3.isPlaying());
    }

    @Test(expected=NullPointerException.class)
    public void testPlayNoList() {
      // Assercja
      mp3.play();
      	assertEquals(mp3.currentSong(),null);
      mp3.pause();
      	assertFalse(mp3.isPlaying());
      mp3.stop();
      	assertFalse(mp3.isPlaying());	
    
    }

    @Test
    public void testAdvance() {

    mp3.loadSongs(list);
    mp3.play();
    	assertEquals(mp3.currentSong(),list.get(0));
    mp3.prev();
    	assertEquals(mp3.currentSong(),list.get(3));
    mp3.next();
    	assertEquals(mp3.currentSong(),list.get(0));
    mp3.next();
    	assertEquals(mp3.currentSong(),list.get(1));
    mp3.prev();
    	assertEquals(mp3.currentSong(),list.get(0));
    mp3.next();
    	assertEquals(mp3.currentSong(),list.get(1));
    mp3.next();
    	assertEquals(mp3.currentSong(),list.get(2));
    mp3.next();
    	assertEquals(mp3.currentSong(),list.get(3));
    
    }
    @Test
    public void testStop() {
        mp3.loadSongs(list);
        mp3.play();
        mp3.stop();
        assertFalse(mp3.isPlaying());	       
    }
    @Test
    public void testNotNull() {
        mp3.loadSongs(list);
        mp3.play();
        assertNotNull(mp3.currentSong());	       
    }
    
    @After
    public void teardown(){
      mp3=null;
      list=null;
    }
}