package lunarempire.quadraticapp;

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
        //TODO: Make it so that you add an "i" if needed
        String equationString = "$${" + quad.getRoots().getSimpOffset().getNumerator() +
                "}/{" + quad.getRoots().getSimpOffset().getDenominator() +
                "}±{" + quad.getRoots().getSimpOutNum().getNumerator() + "}/{" +
                quad.getRoots().getSimpOutNum().getDenominator()+ "}√{" +
                quad.getRoots().getRadical().getSimpInNum() + "}$$";
        String htmlLine = equationString;
        return htmlLine;

    }
}
