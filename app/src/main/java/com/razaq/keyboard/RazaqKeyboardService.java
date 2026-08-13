package com.razaq.keyboard;

import android.inputmethodservice.InputMethodService;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RazaqKeyboardService extends InputMethodService {

    private View view;
    private boolean english = false;

    @Override
    public View onCreateInputView() {
        view = getLayoutInflater().inflate(R.layout.keyboard_view, null);

        setupButtons();
        setPersian();

        return view;
    }

    private void setupButtons() {

        setButton(R.id.key_zad, "ض");
        setButton(R.id.key_sad, "ص");
        setButton(R.id.key_sen, "ث");
        setButton(R.id.key_ghaf, "ق");
        setButton(R.id.key_fa, "ف");
        setButton(R.id.key_ghain, "غ");
        setButton(R.id.key_ain, "ع");

        setButton(R.id.key_he, "ه");
        setButton(R.id.key_khe, "خ");
        setButton(R.id.key_hah, "ح");
        setButton(R.id.key_jim, "ج");
        setButton(R.id.key_che, "چ");
        setButton(R.id.key_shin, "ش");
        setButton(R.id.key_sin, "س");

        setButton(R.id.key_ye, "ی");
        setButton(R.id.key_be, "ب");
        setButton(R.id.key_lam, "ل");
        setButton(R.id.key_alef, "ا");
        setButton(R.id.key_te, "ت");
        setButton(R.id.key_nun, "ن");
        setButton(R.id.key_mim, "م");

        setButton(R.id.key_kaf, "ک");
        setButton(R.id.key_gaf, "گ");
        setButton(R.id.key_vav, "و");
        setButton(R.id.key_re, "ر");
        setButton(R.id.key_dal, "د");
        setButton(R.id.key_zal, "ذ");
        setButton(R.id.key_ze, "ز");

        setButton(R.id.key_zhe, "ژ");
        setButton(R.id.key_ta, "ط");
        setButton(R.id.key_za, "ظ");
        setButton(R.id.key_pe, "پ");
        setButton(R.id.key_hamze, "ء");

        Button back = (Button) view.findViewById(R.id.key_back);
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getCurrentInputConnection() != null) {
                    getCurrentInputConnection().deleteSurroundingText(1, 0);
                }
            }
        });

        Button space = (Button) view.findViewById(R.id.key_space);
        space.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                sendText(" ");
            }
        });

        Button enter = (Button) view.findViewById(R.id.key_enter);
        enter.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                sendText("\n");
            }
        });

        Button globe = (Button) view.findViewById(R.id.key_globe);
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
    }

    private void setButton(int id, final String text) {

        Button button = (Button) view.findViewById(id);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                sendText(text);
            }
        });
    }

    private void setText(int id, String text) {

        Button button = (Button) view.findViewById(id);

        if (button != null) {
            button.setText(text);
        }
    }

    private void sendText(String text) {

        if (getCurrentInputConnection() != null) {
            getCurrentInputConnection().commitText(text, 1);
        }
    }

    private void setPersian() {

        setText(R.id.key_zad, "ض");
        setText(R.id.key_sad, "ص");
        setText(R.id.key_sen, "ث");
        setText(R.id.key_ghaf, "ق");
        setText(R.id.key_fa, "ف");
        setText(R.id.key_ghain, "غ");
        setText(R.id.key_ain, "ع");

        setText(R.id.key_he, "ھ");
        setText(R.id.key_khe, "خ");
        setText(R.id.key_hah, "ح");
        setText(R.id.key_jim, "ج");
        setText(R.id.key_che, "چ");
        setText(R.id.key_shin, "ش");
        setText(R.id.key_sin, "س");

        setText(R.id.key_ye, "ے");
        setText(R.id.key_be, "ب");
        setText(R.id.key_lam, "ل");
        setText(R.id.key_alef, "ا");
        setText(R.id.key_te, "ت");
        setText(R.id.key_nun, "טּ");
        setText(R.id.key_mim, "م");

        setText(R.id.key_kaf, "ڪ");
        setText(R.id.key_gaf, "گ");
        setText(R.id.key_vav, "و");
        setText(R.id.key_re, "ࢪ");
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
        setText(R.id.key_zal, "ᑕ");
        setText(R.id.key_ze, "ᘔ");

        setText(R.id.key_zhe, "ᖇ");
        setText(R.id.key_ta, "ᗩ");
        setText(R.id.key_za, "乙");
        setText(R.id.key_pe, "Ɋ");
        setText(R.id.key_hamze, "!");
    }
}
