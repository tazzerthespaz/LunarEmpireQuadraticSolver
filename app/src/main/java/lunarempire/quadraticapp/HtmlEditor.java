package lunarempire.quadraticapp;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by malcolm on 6/29/16.
 * TODO: Document all of this
 */
public class HtmlEditor {
    Context context;
    AssetManager assetMan;
    BufferedReader br;
    //Quadratic quad;

    //TODO: Add a quadratic class here
    public HtmlEditor(Context context, String htmlFileName) throws IOException {
            this.context = context;
            this.assetMan = context.getAssets();
            openFile(htmlFileName);
    }

    public void openFile(String fileName) throws IOException {
        try {
            br = new BufferedReader(am.open(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Takes the Quadratic class, and writes the mathematic expression for the website
    public String formatAnswer() {

    }

    public void update(String equation) {
        //Write this
    }
}
