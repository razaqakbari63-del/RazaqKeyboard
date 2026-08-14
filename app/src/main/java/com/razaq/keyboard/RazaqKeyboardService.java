Button back = (Button) view.findViewById(R.id.key_back);

back.setOnTouchListener(new View.OnTouchListener() {

    private android.os.Handler handler = new android.os.Handler();
    private Runnable runnable;

    @Override
    public boolean onTouch(View v, android.view.MotionEvent event) {

        if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {

            runnable = new Runnable() {
                @Override
                public void run() {
                    if (getCurrentInputConnection() != null) {
                        getCurrentInputConnection().deleteSurroundingText(1, 0);
                    }
                    handler.postDelayed(this, 50);
                }
            };

            handler.post(runnable);

        } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
            handler.removeCallbacks(runnable);
        }

        return true;
    }
});
