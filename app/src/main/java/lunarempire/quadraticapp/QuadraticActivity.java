package lunarempire.quadraticapp;

import android.graphics.Color;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import lunarEmpire.math.AIsZeroException;
import lunarEmpire.math.Quadratic;
import lunarEmpire.math.DecimalRootDisplay;

public class QuadraticActivity extends AppCompatActivity {
    private WebView previewContent;
    private WebView answerContent;
    private EditText a;
    private EditText b;
    private EditText c;
    private HtmlEditor htmlEditor;
    private TextView decimalAnswer;
    private DialogFragment aIsZeroDialog;
    private DialogFragment emptyFieldDialog;

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


        //Decimal answer
        this.decimalAnswer = (TextView) findViewById(R.id.decimalTextView);


        //Setup the dialogs
        this.aIsZeroDialog = new AIsZeroDialogFragment();
        this.emptyFieldDialog = new EmptyFieldDialogFragment();

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
        decimalAnswer.setText(R.string.defaultDecimal);

    }

    public void onClickCalculate(View view) {
        //Do shit like get a,b,c get the roots and follow with updating the answers
        try {
            double aNum = Double.parseDouble(a.getText().toString());
            double bNum = Double.parseDouble(b.getText().toString());
            double cNum = Double.parseDouble(c.getText().toString());

            try {
                Quadratic quad = new Quadratic(aNum, bNum, cNum);
                htmlEditor.setQuad(quad);
                String equationString = htmlEditor.formatAnswer();

                //Update the roots answers
                try {
                    answerContent.loadUrl("javascript:changeEquation('" + equationString + " ')");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //TODO: Some day, make it possible to set the length of how many decimal places.
                DecimalRootDisplay drdPos = new DecimalRootDisplay(quad.getRoots().getPositiveDecimal());
                DecimalRootDisplay drdNeg = new DecimalRootDisplay(quad.getRoots().getNegativeDecimal());

                decimalAnswer.setText(drdPos.getRounded(5) + " , "  +
                        drdNeg.getRounded(5));

            }catch (AIsZeroException e) {
                aIsZeroDialog.show(getSupportFragmentManager(), "IDK what this message is");
            }

        } catch (Exception e) {
            emptyFieldDialog.show(getSupportFragmentManager(), "still idk");
        }
    }
}
