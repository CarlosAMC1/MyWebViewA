package firebase.app.mywebviewa

import android.content.Context
import android.webkit.ConsoleMessage
import android.webkit.JavascriptInterface
import android.widget.Toast

class WebAppInterface(context: Context) {
    private var context =context
    @JavascriptInterface
    public fun showToastMessage(message: String){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
    }
}