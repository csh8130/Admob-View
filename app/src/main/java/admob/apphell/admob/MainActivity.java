package admob.apphell.admob;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
    private WebView v;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (v.canGoBack()) {
                v.goBack();
                return false;
            }
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        v = (WebView) findViewById(R.id.webview);
        WebSettings settings = v.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);

        v.setWebViewClient(new WebViewClient()
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });

        v.loadUrl("https://accounts.google.com/signin/v2/identifier?service=admob&passive=1209600&continue=https%3A%2F%2Fapps.admob.com%2F%3F_ga%3D2.10235760.476797540.1529681874-430049061.1529681874%23&followup=https%3A%2F%2Fapps.admob.com%2F%3F_ga%3D2.10235760.476797540.1529681874-430049061.1529681874&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
        v.zoomOut();
    }
}
