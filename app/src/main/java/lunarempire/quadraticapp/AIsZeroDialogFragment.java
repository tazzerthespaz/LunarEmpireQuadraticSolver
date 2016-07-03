package lunarempire.quadraticapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by malcolm on 7/3/16.
 */
public class AIsZeroDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.aIsZerodDialogeMessage).setTitle(R.string.invalidInput);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener(){
           public void onClick(DialogInterface dialog, int id) {
               //Something?
           }
        });

        return builder.create();
    }

}
