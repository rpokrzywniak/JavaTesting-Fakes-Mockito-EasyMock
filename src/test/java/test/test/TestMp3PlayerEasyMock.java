package test.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import static org.assertj.core.api.Assertions.assertThat;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.MockType;
import static org.easymock.EasyMock.*;
import org.easymock.TestSubject;

import java.util.ArrayList;

@RunWith(EasyMockRunner.class)
  public class TestMp3PlayerEasyMock {

	@Mock(type = MockType.NICE)
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
      expect(mp3.getList()).andReturn(list);
      replay(mp3);
      assertThat(mp3.getList()).isEqualTo(list);
    }
    
    @Test
    public void testListSize() {
      expect(mp3.getList()).andReturn(list);
      replay(mp3);
      assertThat(mp3.getList()).hasSize(4);
    }
    
    @Test
    public void testStop() {
        expect(mp3.isPlaying()).andReturn(false);
        replay(mp3);
      assertThat(mp3.isPlaying()).isFalse();
    }
    
    @Test
    public void testPlays() {
        expect(mp3.isPlaying()).andReturn(true);
        replay(mp3);
      assertThat(mp3.isPlaying()).isTrue();
    }
    
    @Test
    public void testTime(){
    	double time =  21;
    	expect(mp3.currentPosition()).andReturn(time);
    	replay(mp3);
    	assertThat(mp3.currentPosition()).isEqualTo(time);
    }


    
    @After
    public void teardown(){
      mp3=null;
      list=null;
    }
}