package com.example.banmi.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.banmi.R;

//验证
public class VerificationActivity extends AppCompatActivity {

    private ImageView mIv;
    private TextView[] textView;
    private EditText mItemEdittext;
    private StringBuffer stringBuffer = new StringBuffer();
    private String inputContent;
    private int count = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        initView();
    }

    private void initView() {
        mIv = (ImageView) findViewById(R.id.iv);
        textView[0] = (TextView) findViewById(R.id.tv1);
        textView[1] = (TextView) findViewById(R.id.tv2);
        textView[2] = (TextView) findViewById(R.id.tv3);
        textView[3] = (TextView) findViewById(R.id.tv4);
        mItemEdittext = (EditText) findViewById(R.id.item_edittext);
        //将光标隐藏
        mItemEdittext.setCursorVisible(false);
        setListener();
    }

    private void setListener() {
        mItemEdittext.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // 如果字符不为""时才进行操作
                if (!editable.toString().equals("")) {
                    if (stringBuffer.length() > 3) {
                        //当文本长度大于3位时edittext置空
                        mItemEdittext.setText("");
                        return;
                    } else {
                        //将文字添加到StringBuffer中
                        stringBuffer.append(editable);
                        mItemEdittext.setText("");//添加后将EditText置空
                        count = stringBuffer.length();//记录stringbuffer的长度
                        inputContent = stringBuffer.toString();
                        if (stringBuffer.length() == 4) {
                            //文字长度位4  则调用完成输入的监听
                            if (inputCompleteListener != null) {
                                inputCompleteListener.inputComplete();
                            }
                        }
                    }

                    for (int i = 0; i < stringBuffer.length(); i++) {
                        textView[i].setText(String.valueOf(inputContent.charAt(i)));
                        textView[i].setBackgroundResource(R.color.hui99);
                    }

                }
            }
        });

        mItemEdittext.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_DEL
                        && event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (onKeyDelete()) return true;
                    return true;
                }
                return false;
            }
        });
    }


    public boolean onKeyDelete() {
        if (count == 0) {
            count = 4;
            return true;
        }
        if (stringBuffer.length() > 0) {
            //删除相应位置的字符
            stringBuffer.delete((count - 1), count);
            count--;
            inputContent = stringBuffer.toString();
            textView[stringBuffer.length()].setText("");
            textView[stringBuffer.length()].setBackgroundResource(R.color.bai);
            if (inputCompleteListener != null)
                inputCompleteListener.deleteContent(true);//有删除就通知manger

        }
        return false;
    }

    /**
     * 清空输入内容
     */
    public void clearEditText() {
        stringBuffer.delete(0, stringBuffer.length());
        inputContent = stringBuffer.toString();
        for (int i = 0; i < textView.length; i++) {
            textView[i].setText("");
            textView[i].setBackgroundResource(R.color.bai);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    private InputCompleteListener inputCompleteListener;

    public void setInputCompleteListener(InputCompleteListener inputCompleteListener) {
        this.inputCompleteListener = inputCompleteListener;
    }

    public interface InputCompleteListener {
        void inputComplete();

        void deleteContent(boolean isDelete);
    }

    /**
     * 获取输入文本
     *
     * @return
     */
    public String getEditContent() {
        return inputContent;
    }
}
