package com.vpbank.sqlitesimple.sql.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.vpbank.sqlitesimple.R;

public class Textviewcustom extends TextView {
    public Textviewcustom(Context context, @androidx.annotation.Nullable AttributeSet attrs) {
        super(context, attrs);
        setTextColor(R.color.colorAccent);
        setTextSize(17);
    }
}
