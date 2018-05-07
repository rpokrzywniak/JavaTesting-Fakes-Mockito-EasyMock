package test.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import static org.assertj.core.api.Assertions.assertThat;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
  public class TestMp3PlayerMockito {

	@Mock
	MockMp3Player mp3;
	
    private ArrayList<String> list = new ArrayList<String>();

    @Before
      public void setUp() {
      list = new ArrayList<String>();
      list.add("Bill Chase -- Open Up Wide");
      list.add("Jethro Tull -- Locomotive Breath");
      list.add("The Boomtown Rats -- Monday");
      list.add("Carl Orff -- O Fortuna");
    }

    @Test
    public void testList() {
      doReturn(list).when(mp3).getList();
      assertThat(mp3.getList()).isEqualTo(list);
    }
    
    @Test
    public void testListSize() {
      doReturn(list).when(mp3).getList();
      assertThat(mp3.getList()).hasSize(4);
    }
    
    @Test
    public void testStop() {
      doReturn(false).when(mp3).isPlaying();
      assertThat(mp3.isPlaying()).isFalse();
    }
    
    @Test
    public void testPlays() {
      doReturn(true).when(mp3).isPlaying();
      assertThat(mp3.isPlaying()).isTrue();
    }
    
    @Test
    public void testTime(){
    	double time =  21;
    	doReturn(time).when(mp3).currentPosition();
    	assertThat(mp3.currentPosition()).isEqualTo(time);
    }


    
    @After
    public void teardown(){
      mp3=null;
      list=null;
    }
}