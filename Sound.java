package geniusGame;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;


public class Sound {

    public void play(String audioName) {
        // if (!audioName.equals("")) {
            URL url = TelaJogo.class.getResource(audioName + ".wav");
            AudioClip audio = Applet.newAudioClip(url);
            audio.play();
        // }
    }

}
