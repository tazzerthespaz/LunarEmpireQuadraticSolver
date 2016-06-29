package lunarempire.quadraticapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

import java.io.IOException;

public class QuadraticActivity extends AppCompatActivity {
    private WebView previewContent;
    private WebView answerContent;
    private EditText a;
    private EditText b;
    private EditText c;


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

    }

    public void onClickClear(View view) {
        a.setText("");
        b.setText("");
        c.setText("");
    }

    public void onClickCalculate(View view) {
        //Do shit like get a,b,c get the roots and follow with updating the answers
    }
}
