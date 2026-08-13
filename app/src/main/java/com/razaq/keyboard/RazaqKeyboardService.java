package com.razaq.keyboard;

import android.inputmethodservice.InputMethodService;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputConnection;
import android.widget.Button;

public class RazaqKeyboardService extends InputMethodService {

    @Override
    public View onCreateInputView() {
        View view = getLayoutInflater().inflate(R.layout.keyboard_view, null);

        setKey(view, R.id.key_zad, "ض");
        setKey(view, R.id.key_sad, "ص");
        setKey(view, R.id.key_sen, "ث");
        setKey(view, R.id.key_ghaf, "ق");
        setKey(view, R.id.key_fa, "ف");
        setKey(view, R.id.key_ghain, "غ");
        setKey(view, R.id.key_ain, "ع");

        setKey(view, R.id.key_he, "ه");
        setKey(view, R.id.key_khe, "خ");
        setKey(view, R.id.key_hah, "ح");
        setKey(view, R.id.key_jim, "ج");
        setKey(view, R.id.key_che, "چ");
        setKey(view, R.id.key_shin, "ش");
        setKey(view, R.id.key_sin, "س");

        setKey(view, R.id.key_ye, "ی");
        setKey(view, R.id.key_be, "ب");
        setKey(view, R.id.key_lam, "ل");
        setKey(view, R.id.key_alef, "ا");
        setKey(view, R.id.key_te, "ت");
        setKey(view, R.id.key_nun, "ن");
        setKey(view, R.id.key_mim, "م");

        setKey(view, R.id.key_kaf, "ک");
        setKey(view, R.id.key_gaf, "گ");
        setKey(view, R.id.key_vav, "و");
        setKey(view, R.id.key_re, "ر");
        setKey(view, R.id.key_dal, "د");
        setKey(view, R.id.key_zal, "ذ");
        setKey(view, R.id.key_ze, "ز");

        setKey(view, R.id.key_zhe, "ژ");
        setKey(view, R.id.key_ta, "ط");
        setKey(view, R.id.key_za, "ظ");
        setKey(view, R.id.key_pe, "پ");
        setKey(view, R.id.key_hamze, "ء");

        Button space = (Button) view.findViewById(R.id.key_space);
        space.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                sendText(" ");
            }
        });

        Button back = (Button) view.findViewById(R.id.key_back);
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                InputConnection ic = getCurrentInputConnection();
                if (ic != null) {
                    ic.deleteSurroundingText(1, 0);
                }
            }
        });

        Button enter = (Button) view.findViewById(R.id.key_enter);
        enter.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                InputConnection ic = getCurrentInputConnection();
                if (ic != null) {
                    ic.sendKeyEvent(new android.view.KeyEvent(
                            android.view.KeyEvent.ACTION_DOWN,
                            android.view.KeyEvent.KEYCODE_ENTER));
                    ic.sendKeyEvent(new android.view.KeyEvent(
                            android.view.KeyEvent.ACTION_UP,
                            android.view.KeyEvent.KEYCODE_ENTER));
                }
            }
        });

        return view;
    }

    private void setKey(View view, int id, final String text) {
        Button button = (Button) view.findViewById(id);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                sendText(text);
            }
        });
    }

    private void sendText(String text) {
        InputConnection ic = getCurrentInputConnection();

        if (ic != null) {
            ic.commitText(text, 1);
        }
    }
}
