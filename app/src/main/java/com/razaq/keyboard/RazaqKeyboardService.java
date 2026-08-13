package com.razaq.keyboard;

import android.inputmethodservice.InputMethodService;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputConnection;
import android.widget.Button;

public class RazaqKeyboardService extends InputMethodService {

    private boolean english = false;
    private View keyboardView;

    @Override
    public View onCreateInputView() {

        keyboardView = getLayoutInflater().inflate(
                R.layout.keyboard_view, null);

        setupKeys(keyboardView);
        setPersian();

        Button globe = (Button) keyboardView.findViewById(R.id.key_globe);

        globe.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                english = !english;

                if (english) {
                    setEnglish();
                } else {
                    setPersian();
                }
            }
        });

        Button space = (Button) keyboardView.findViewById(R.id.key_space);

        space.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                sendText(" ");
            }
        });

        Button back = (Button) keyboardView.findViewById(R.id.key_back);

        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                InputConnection ic = getCurrentInputConnection();

                if (ic != null) {
                    ic.deleteSurroundingText(1, 0);
                }
            }
        });

        Button enter = (Button) keyboardView.findViewById(R.id.key_enter);

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

        return keyboardView;
    }

    private void setupKeys(View view) {

        setKey(view, R.id.key_zad);
        setKey(view, R.id.key_sad);
        setKey(view, R.id.key_sen);
        setKey(view, R.id.key_ghaf);
        setKey(view, R.id.key_fa);
        setKey(view, R.id.key_ghain);
        setKey(view, R.id.key_ain);

        setKey(view, R.id.key_he);
        setKey(view, R.id.key_khe);
        setKey(view, R.id.key_hah);
        setKey(view, R.id.key_jim);
        setKey(view, R.id.key_che);
        setKey(view, R.id.key_shin);
        setKey(view, R.id.key_sin);

        setKey(view, R.id.key_ye);
        setKey(view, R.id.key_be);
        setKey(view, R.id.key_lam);
        setKey(view, R.id.key_alef);
        setKey(view, R.id.key_te);
        setKey(view, R.id.key_nun);
        setKey(view, R.id.key_mim);

        setKey(view, R.id.key_kaf);
        setKey(view, R.id.key_gaf);
        setKey(view, R.id.key_vav);
        setKey(view, R.id.key_re);
        setKey(view, R.id.key_dal);
        setKey(view, R.id.key_zal);
        setKey(view, R.id.key_ze);

        setKey(view, R.id.key_zhe);
        setKey(view, R.id.key_ta);
        setKey(view, R.id.key_za);
        setKey(view, R.id.key_pe);
        setKey(view, R.id.key_hamze);
    }

    private void setKey(View view, int id) {

        final Button button = (Button) view.findViewById(id);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                sendText(button.getText().toString());
            }
        });
    }

    private void setPersian() {

        setText(R.id.key_zad, "ض");
        setText(R.id.key_sad, "ص");
        setText(R.id.key_sen, "ث");
        setText(R.id.key_ghaf, "ق");
        setText(R.id.key_fa, "ف");
        setText(R.id.key_ghain, "غ");
        setText(R.id.key_ain, "ع");

        setText(R.id.key_he, "ه");
        setText(R.id.key_khe, "خ");
        setText(R.id.key_hah, "ح");
        setText(R.id.key_jim, "ج");
        setText(R.id.key_che, "چ");
        setText(R.id.key_shin, "ش");
        setText(R.id.key_sin, "س");

        setText(R.id.key_ye, "ی");
        setText(R.id.key_be, "ب");
        setText(R.id.key_lam, "ل");
        setText(R.id.key_alef, "ا");
        setText(R.id.key_te, "ت");
        setText(R.id.key_nun, "ن");
        setText(R.id.key_mim, "م");

        setText(R.id.key_kaf, "ک");
        setText(R.id.key_gaf, "گ");
        setText(R.id.key_vav, "و");
        setText(R.id.key_re, "ر");
        setText(R.id.key_dal, "د");
        setText(R.id.key_zal, "ذ");
        setText(R.id.key_ze, "ز");

        setText(R.id.key_zhe, "ژ");
        setText(R.id.key_ta, "ط");
        setText(R.id.key_za, "ظ");
        setText(R.id.key_pe, "پ");
        setText(R.id.key_hamze, "ء");
    }

    private void setEnglish() {

        setText(R.id.key_zad, "Q");
        setText(R.id.key_sad, "W");
        setText(R.id.key_sen, "E");
        setText(R.id.key_ghaf, "R");
        setText(R.id.key_fa, "T");
        setText(R.id.key_ghain, "Y");
        setText(R.id.key_ain, "U");

        setText(R.id.key_he, "I");
        setText(R.id.key_khe, "O");
        setText(R.id.key_hah, "P");
        setText(R.id.key_jim, "A");
        setText(R.id.key_che, "S");
        setText(R.id.key_shin, "D");
        setText(R.id.key_sin, "F");

        setText(R.id.key_ye, "G");
        setText(R.id.key_be, "H");
        setText(R.id.key_lam, "J");
        setText(R.id.key_alef, "K");
        setText(R.id.key_te, "L");
        setText(R.id.key_nun, "Z");
        setText(R.id.key_mim, "X");

        setText(R.id.key_kaf, "C");
        setText(R.id.key_gaf, "V");
        setText(R.id.key_vav, "B");
        setText(R.id.key_re, "N");
        setText(R.id.key_dal, "M");
        setText(R.id.key_zal, ",");
        setText(R.id.key_ze, ".");

        setText(R.id.key_zhe, "?");
        setText(R.id.key_ta, "1");
        setText(R.id.key_za, "2");
        setText(R.id.key_pe, "3");
        setText(R.id.key_hamze, "!");
    }

    private void setText(int id, String text) {

        Button button = (Button) keyboardView.findViewById(id);

        if (button != null) {
            button.setText(text);
        }
    }

    private void sendText(String text) {

        InputConnection ic = getCurrentInputConnection();

        if (ic != null) {
            ic.commitText(text, 1);
        }
    }
    }
