package com.example.banmi.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.banmi.R;

import butterknife.internal.Utils;

/**
 * creation time 2019/5/24
 * author oujunlong
 */
public class VoucherFragment extends Fragment implements View.OnClickListener {
    private View view;
    /**
     * 请输入代金券码
     */
    private EditText mEd1;
    /**
     * 兑换
     */
    private Button mB1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_voucher, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mEd1 = (EditText) view.findViewById(R.id.ed1);
        mB1 = (Button) view.findViewById(R.id.b1);
        mB1.setOnClickListener(this);
        String string = mEd1.getText().toString();
        if(!TextUtils.isEmpty(string)){
            mB1.setEnabled(true);
        }else {
            mB1.setEnabled(false);
        }
        init();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.b1:
                Toast.makeText(getContext(), "兑换成功", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    public void init(){


        mEd1.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                String content = mEd1.getText().toString();
                if(content.length()==6){
                    mB1.setEnabled(true);
                }else {
                    mB1.setEnabled(false);
                }

            }

        });
    }

}
