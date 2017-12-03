package app.ifox.com.phyandroidproject.NewActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import app.ifox.com.phyandroidproject.MyFragment1;
import app.ifox.com.phyandroidproject.R;

/**
 * Created by 13118467271 on 2017/12/3.
 */

public class NewCompleteIntroduceActivity extends AppCompatActivity implements View.OnClickListener {
    private Button back;
    private WebView newWeb;
    private EditText comment;
    private TextView send;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_complete_introduce_activity);
        initView();//初始化
    }

    private void initView() {
        back = findViewById(R.id.introduce_back);
        newWeb = findViewById(R.id.new_web);
        comment = findViewById(R.id.new_comment_text);
        send = findViewById(R.id.new_comment_send);
        newWeb.getSettings().setJavaScriptEnabled(true);
        Intent intent = getIntent();
        String urlData = intent.getStringExtra("url");
        newWeb.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;

            }
        });
        newWeb.loadUrl(urlData);
        back.setOnClickListener(this);
        send.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.introduce_back:
                Intent intentBack = new Intent(NewCompleteIntroduceActivity.this, MyFragment1.class);
                startActivity(intentBack);
                finish();
                break;
            case R.id.new_comment_send:
                String commentText = comment.getText().toString();
                //评论数据传输
                Toast.makeText(this, commentText, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
