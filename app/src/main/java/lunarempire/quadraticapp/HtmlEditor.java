package lunarempire.quadraticapp;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import lunarEmpire.math.Quadratic;

/**
 * Created by malcolm on 6/29/16.
 * TODO: Document all of this
 */
public class HtmlEditor {
    Context context;
    AssetManager assetMan;
    BufferedReader br;

    public Quadratic getQuad() {
        return quad;
    }

    public void setQuad(Quadratic quad) {
        this.quad = quad;
    }

    Quadratic quad;

    //TODO: Add a quadratic class here
    public HtmlEditor(Context context, String htmlFileName, Quadratic quad) throws IOException {
        this.quad = quad;
        this.context = context;
        this.assetMan = context.getAssets();
        openFile(htmlFileName);
    }

    public void openFile(String fileName) throws IOException {
        try {
            br = new BufferedReader(new InputStreamReader(assetMan.open(fileName), "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Takes the Quadratic class, and writes the mathematic expression for the website
    public String formatAnswer() {
        String equationString = "$$" + quad.getRoots().getSimpOffset().getNumerator() +
                "/" + quad.getRoots().getSimpOffset().getDenominator() +
                "±" + quad.getRoots().getSimpOutNum().getNumerator() + "/" +
                quad.getRoots().getSimpOutNum().getDenominator()+ "√{" +
                quad.getRoots().getRadical().getSimpInNum() + "$$";
        String htmlLine = "<p>" + equationString + "</p>";
        return htmlLine;

    }

    public void update(String equation) {
        String line;
        try {
            while ((line = br.readLine()) != null) {
                if (line.startsWith("<p>")) {
                    line = formatAnswer();
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
