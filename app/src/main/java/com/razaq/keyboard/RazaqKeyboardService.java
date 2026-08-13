package com.razaq.keyboard;

import android.inputmethodservice.InputMethodService;
import android.view.View;
import android.widget.Button;

public class RazaqKeyboardService extends InputMethodService {

    @Override
    public View onCreateInputView() {
        View view = getLayoutInflater().inflate(R.layout.keyboard_view, null);

        Button key = view.findViewById(R.id.key);
        key.setOnClickListener(v -> {
            if (getCurrentInputConnection() != null) {
                getCurrentInputConnection().commitText("ڪ", 1);
            }
        });

        return view;
    }
}
