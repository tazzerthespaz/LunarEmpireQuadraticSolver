package lunarempire.quadraticapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import java.io.IOException;

public class QuadraticActivity extends AppCompatActivity {
    private WebView articleContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadratic);

        articleContent = (WebView) findViewById(R.id.formula_page);
        articleContent.getSettings().setJavaScriptEnabled(true);
        articleContent.getSettings().setBuiltInZoomControls(false);

        try {
            articleContent.loadUrl("file:///android_asset/mathFile.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
