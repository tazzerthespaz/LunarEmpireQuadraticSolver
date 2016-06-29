package lunarempire.quadraticapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import java.io.IOException;

public class QuadraticActivity extends AppCompatActivity {
    private WebView previewContent;
    private WebView answerContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadratic);

        previewContent = (WebView) findViewById(R.id.previewFormulaPage);
        previewContent.getSettings().setJavaScriptEnabled(true);
        previewContent.getSettings().setBuiltInZoomControls(false);
        try {
            previewContent.loadUrl("file:///android_asset/previewPage.html");
        } catch (Exception e) {
            e.printStackTrace();
        }

        answerContent = (WebView) findViewById(R.id.rootsFormulaPage);
        answerContent.getSettings().setJavaScriptEnabled(true);
        answerContent.getSettings().setBuiltInZoomControls(false);
        try {
            answerContent.loadUrl("file:///android_asset/answerPage.html");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
