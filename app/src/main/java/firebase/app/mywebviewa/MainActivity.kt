package firebase.app.mywebviewa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebView

class MainActivity : AppCompatActivity() {
    private val direction :String = "http://10.0.2.2:81/Android/helloAndroid.html"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView = findViewById<WebView>(R.id.webView)
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webView.addJavascriptInterface(WebAppInterface(this),"Android")
        webView.webViewClient =MyWebViewClient()
        webView.loadUrl(direction)

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        val webView = findViewById<WebView>(R.id.webView)
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()){
            webView.goBack()
            return true
        }

        return super.onKeyDown(keyCode, event)

    }
}