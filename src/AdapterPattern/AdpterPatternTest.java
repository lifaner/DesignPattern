package AdapterPattern;

public class AdpterPatternTest {

    public static void main(String[] args) {
        AudioPlayer ap = new AudioPlayer();

        ap.play("mp4","111.mp4");
        ap.play("mp3","222.mp3");
        ap.play("vlc","333.vlc");
        ap.play("doc","444.doc");
    }
}
