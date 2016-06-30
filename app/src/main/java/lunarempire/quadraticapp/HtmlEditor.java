package lunarempire.quadraticapp;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import lunarEmpire.math.Quadratic;

/**
 * Created by malcolm on 6/29/16.
 * TODO: Document all of this
 */ public class HtmlEditor {
    Quadratic quad;

    public Quadratic getQuad() {
        return quad;
    }

    public void setQuad(Quadratic quad) {
        this.quad = quad;
    }


    //TODO: Add a quadratic class here
    public HtmlEditor(Quadratic quad) {
        this.quad = quad;
    }

    //Takes the Quadratic class, and writes the mathematic expression for the website
    public String formatAnswer() {
        String equationString = "$$" + quad.getRoots().getSimpOffset().getNumerator() +
                "/" + quad.getRoots().getSimpOffset().getDenominator() +
                "±" + quad.getRoots().getSimpOutNum().getNumerator() + "/" +
                quad.getRoots().getSimpOutNum().getDenominator()+ "√{" +
                quad.getRoots().getRadical().getSimpInNum() + "$$";
        String htmlLine = equationString;
        return htmlLine;

    }
}
