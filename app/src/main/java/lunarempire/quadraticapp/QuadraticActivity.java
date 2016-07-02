//TODO: Need to sanitize input, watch out for empy editText's, a = 0
//TODO: Make sure that you check for too large of numbers
package lunarempire.quadraticapp;

import android.content.res.AssetManager;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import lunarEmpire.math.Quadratic;

public class QuadraticActivity extends AppCompatActivity {
    private WebView previewContent;
    private WebView answerContent;
    private EditText a;
    private EditText b;
    private EditText c;
    private HtmlEditor htmlEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadratic);

        //Preview WebView
        previewContent = (WebView) findViewById(R.id.previewFormulaPage);
        previewContent.getSettings().setJavaScriptEnabled(true);
        previewContent.getSettings().setBuiltInZoomControls(false);
        previewContent.setBackgroundColor(Color.TRANSPARENT);
        try {
            previewContent.loadUrl("file:///android_asset/previewPage.html");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Answer WebView
        answerContent = (WebView) findViewById(R.id.rootsFormulaPage);
        answerContent.getSettings().setJavaScriptEnabled(true);
        answerContent.getSettings().setBuiltInZoomControls(false);
        answerContent.setBackgroundColor(Color.TRANSPARENT);
        try {
            answerContent.loadUrl("file:///android_asset/answerPage.html");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //EditText
        this.a = (EditText) findViewById(R.id.editA);
        this.b = (EditText) findViewById(R.id.editB);
        this.c = (EditText) findViewById(R.id.editC);

        htmlEditor = new HtmlEditor(null);

    }

    public void onClickClear(View view) {
        a.setText("");
        b.setText("");
        c.setText("");
        try {
            answerContent.loadUrl("javascript:changeEquation('$$x={-b±√{b^2-4ac}}/{2a}$$')");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void onClickCalculate(View view) {
        //Do shit like get a,b,c get the roots and follow with updating the answers
        Quadratic quad = new Quadratic(Double.parseDouble(a.getText().toString()),
                Double.parseDouble(b.getText().toString()),
                Double.parseDouble(c.getText().toString()));
        quad.calcRoots();
        htmlEditor.setQuad(quad);
        String equationString = htmlEditor.formatAnswer();
        try {
            answerContent.loadUrl("javascript:changeEquation('" + equationString + " ')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
