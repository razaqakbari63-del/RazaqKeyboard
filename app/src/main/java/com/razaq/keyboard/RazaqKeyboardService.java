package com.razaq.keyboard;

import android.inputmethodservice.InputMethodService;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.os.Handler;

public class RazaqKeyboardService extends InputMethodService {

    private View view;
    private boolean english = false;
    private Handler handler = new Handler();

    private Runnable deleteRunnable;

    @Override
    public View onCreateInputView() {
        view = getLayoutInflater().inflate(R.layout.keyboard_view, null);
        setupButtons();
        setPersian();
        return view;
    }

    private void setupButtons() {

        makeKey(R.id.key_zad, "ض", "ᘔ");
        makeKey(R.id.key_sad, "ص", "ᔕ");
        makeKey(R.id.key_sen, "ث", "Ǝ");
        makeKey(R.id.key_ghaf, "ق", "Ɋ");
        makeKey(R.id.key_fa, "ف", "Ғ");
        makeKey(R.id.key_ghain, "غ", "Ƴ");
        makeKey(R.id.key_ain, "ع", "ᑌ");

        makeKey(R.id.key_he, "ھ", "I");
        makeKey(R.id.key_khe, "خ", "O");
        makeKey(R.id.key_hah, "ح", "P");
        makeKey(R.id.key_jim, "ج", "ᗩ");
        makeKey(R.id.key_che, "چ", "ᔕ");
        makeKey(R.id.key_shin, "ش", "ᗪ");
        makeKey(R.id.key_sin, "س", "Ғ");

        makeKey(R.id.key_ye, "ے", "G");
        makeKey(R.id.key_be, "ب", "ᕼ");
        makeKey(R.id.key_lam, "ݪ", "J");
        makeKey(R.id.key_alef, "ا", "K");
        makeKey(R.id.key_te, "ت", "ᒪ");
        makeKey(R.id.key_nun, "טּ", "乙");
        makeKey(R.id.key_mim, "م", "X");

        makeKey(R.id.key_kaf, "ڪ", "ᑕ");
        makeKey(R.id.key_gaf, "گ", "ᐯ");
        makeKey(R.id.key_vav, "و", "ᗷ");
        makeKey(R.id.key_re, "ࢪ", "ᖇ");
        makeKey(R.id.key_dal, "כ", "ᗰ");
        makeKey(R.id.key_zal, "ذ", "ᘔ");
        makeKey(R.id.key_ze, "ز", "乙");

        makeKey(R.id.key_zhe, "ژ", "ᘔ");
        makeKey(R.id.key_ta, "ط", "T");
        makeKey(R.id.key_za, "ظ", "Z");
        makeKey(R.id.key_pe, "پ", "ᑭ");
        makeKey(R.id.key_hamze, "ء", "!");

        Button back = (Button) view.findViewById(R.id.key_back);

        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteOne();
            }
        });

        back.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                deleteMany();

                deleteRunnable = new Runnable() {
                    @Override
                    public void run() {
                        deleteMany();
                        handler.postDelayed(this, 80);
                    }
                };

                handler.postDelayed(deleteRunnable, 300);
                return true;
            }
        });

        back.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, android.view.MotionEvent event) {

                if (event.getAction() == android.view.MotionEvent.ACTION_UP ||
                    event.getAction() == android.view.MotionEvent.ACTION_CANCEL) {

                    if (deleteRunnable != null) {
                        handler.removeCallbacks(deleteRunnable);
                    }
                }

                return false;
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
                if (getCurrentInputConnection() != null) {
                    getCurrentInputConnection().sendKeyEvent(
                        new android.view.KeyEvent(
                            android.view.KeyEvent.ACTION_DOWN,
                            android.view.KeyEvent.KEYCODE_ENTER
                        )
                    );
                }
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

        Button kashida = (Button) view.findViewById(R.id.key_kashida);

        kashida.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                sendText("ـ");
            }
        });

        kashida.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                sendText("ــــــــــــــــــــــــ");
                return true;
            }
        });
    }

    private void makeKey(final int id, final String persian, final String englishText) {

        Button button = (Button) view.findViewById(id);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (english) {
                    sendText(englishText);
                } else {
                    sendText(persian);
                }
            }
        });

        button.setText(persian);
    }

    private void deleteOne() {

        if (getCurrentInputConnection() != null) {
            getCurrentInputConnection().deleteSurroundingText(1, 0);
        }
    }

    private void deleteMany() {

        if (getCurrentInputConnection() != null) {
            getCurrentInputConnection().deleteSurroundingText(5, 0);
        }
    }

    private void sendText(String text) {

        if (getCurrentInputConnection() != null) {
            getCurrentInputConnection().commitText(text, 1);
        }
    }

    private void setText(int id, String text) {

        Button button = (Button) view.findViewById(id);

        if (button != null) {
            button.setText(text);
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
        setText(R.id.key_lam, "ݪ");
        setText(R.id.key_alef, "ا");
        setText(R.id.key_te, "ت");
        setText(R.id.key_nun, "טּ");
        setText(R.id.key_mim, "م");

        setText(R.id.key_kaf, "ڪ");
        setText(R.id.key_gaf, "گ");
        setText(R.id.key_vav, "و");
        setText(R.id.key_re, "ࢪ");
        setText(R.id.key_dal, "כ");
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
        setText(R.id.key_jim, "ᗩ");
        setText(R.id.key_che, "S");
        setText(R.id.key_shin, "ᗪ");
        setText(R.id.key_sin, "Ғ");

        setText(R.id.key_ye, "G");
        setText(R.id.key_be, "ᕼ");
        setText(R.id.key_lam, "J");
        setText(R.id.key_alef, "K");
        setText(R.id.key_te, "ᒪ");
        setText(R.id.key_nun, "乙");
        setText(R.id.key_mim, "X");

        setText(R.id.key_kaf, "ᑕ");
        setText(R.id.key_gaf, "ᐯ");
        setText(R.id.key_vav, "ᗷ");
        setText(R.id.key_re, "ᖇ");
        setText(R.id.key_dal, "ᗰ");
        setText(R.id.key_zal, "Z");
        setText(R.id.key_ze, "ᘔ");

        setText(R.id.key_zhe, "ᘔ");
        setText(R.id.key_ta, "T");
        setText(R.id.key_za, "乙");
        setText(R.id.key_pe, "ᑭ");
        setText(R.id.key_hamze, "!");
    }
            }
