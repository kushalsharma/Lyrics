package com.flipkart.lyrics.sample.json;

import com.flipkart.lyrics.config.SwiftTuneImpl;
import com.flipkart.lyrics.config.Tune;
import com.flipkart.lyrics.config.JavaTuneImpl;
import com.flipkart.lyrics.json.Lyrics;

import java.io.File;

/**
 * @author shrey.garg on 04/02/17.
 */
public class Generator {

    public static void main(String[] args) {
        Tune javaTune = new JavaTuneImpl();
        Tune swiftTune = new SwiftTuneImpl();

        File target = new File(Generator.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile();
        File generatedSources = new File(target, "generated-sources");

        Lyrics lyricsJava = new Lyrics(javaTune, generatedSources);
        Lyrics lyricsSwift = new Lyrics(swiftTune, generatedSources);

        // The working directory should be lyrics-json-sample
        File source = new File("lyrics-samples/lyrics-json-sample/src/main/resources/com");

        lyricsJava.compose(true, source);
        lyricsSwift.compose(false, source);
    }
}
