package com.example.doris;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RearLeftDoorOpen extends AppCompatDialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        Context context;
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Rear Left door is left open!")
                .setMessage("Please close your car door properly")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        resetdata();
                    }
                });
        return builder.create();
    }

    private void resetdata() {
        DatabaseReference databaseReference2 = FirebaseDatabase.getInstance().getReference().child("Special_rldw");
        HashMap<String,Object> voice = new HashMap<>();
        voice.put("rearleftdoorwarning","0");
        databaseReference2.updateChildren(voice);

    }
}

