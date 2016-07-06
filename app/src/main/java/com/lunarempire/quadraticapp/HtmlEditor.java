package com.lunarempire.quadraticapp;

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

    public HtmlEditor(Quadratic quad) {
        this.quad = quad;
    }

    //Takes the Quadratic class, and writes the mathematic expression for the website
    public String formatAnswer() {
        String equationString = "$${" + quad.getRoots().getSimpOffset().getNumerator() +
                "}/{" + quad.getRoots().getSimpOffset().getDenominator() +
                "}±{" + quad.getRoots().getSimpOutNum().getNumerator() + "}/{" +
                quad.getRoots().getSimpOutNum().getDenominator()+ "}";
        if(quad.getRoots().getImaginary()) {
            equationString += "i";
        }
        equationString += "√{" + quad.getRoots().getRadical().getSimpInNum() + "}$$";
        String htmlLine = equationString;
        return htmlLine;

    }
}
