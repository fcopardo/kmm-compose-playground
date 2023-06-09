import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit

class TextBuilder {

    private var text: String = ""
    private var modifier: Modifier = Modifier
    private var color: Color = Color.Unspecified
    private var fontSize: TextUnit = TextUnit.Unspecified
    private var fontStyle: FontStyle? = null
    private var fontWeight: FontWeight? = null
    private var fontFamily: FontFamily? = null
    private var letterSpacing: TextUnit = TextUnit.Unspecified
    private var textDecoration: TextDecoration? = null
    private var textAlign: TextAlign? = null
    private var lineHeight: TextUnit = TextUnit.Unspecified
    private var overflow: TextOverflow = TextOverflow.Clip
    private var softWrap: Boolean = true
    private var maxLines: Int = Int.MAX_VALUE
    private var minLines: Int = 1
    private var onTextLayout: (TextLayoutResult) -> Unit = {}

    constructor(textChain : String){
        text = textChain
    }

    fun color(newColor : Color): TextBuilder {
        color = newColor
        return this
    }

    fun fontSize(fontSize : TextUnit): TextBuilder {
        this.fontSize = fontSize
        return this
    }

    fun fontStyle(fontStyle : FontStyle): TextBuilder {
        this.fontStyle = fontStyle
        return this
    }

    fun fontFamily(fontFamily: FontFamily): TextBuilder {
        this.fontFamily = fontFamily
        return this
    }

    fun letterSpacing(letterSpacing : TextUnit): TextBuilder {
        this.letterSpacing = letterSpacing
        return this
    }

    fun textDecoration(textDecoration: TextDecoration): TextBuilder {
        this.textDecoration = textDecoration
        return this
    }

    fun textAlign(textAlign: TextAlign): TextBuilder {
        this.textAlign = textAlign
        return this
    }

    fun lineHeight(lineHeight : TextUnit): TextBuilder {
        this.lineHeight = lineHeight
        return this
    }

    fun overflow(overflow: TextOverflow): TextBuilder {
        this.overflow = overflow
        return this
    }

    fun softwrap(wrap : Boolean): TextBuilder {
        softWrap = wrap
        return this
    }

    fun maxLines(max : Int){
        maxLines = max
    }

    fun minLines(min : Int): TextBuilder {
        if(min > 0) minLines = min
        return this
    }

    fun onTextLayout(onTextLayout: (TextLayoutResult) -> Unit): TextBuilder {
        this.onTextLayout = onTextLayout
        return this
    }

    @Composable
    fun compose(style : TextStyle? = LocalTextStyle.current){
        Text(text, modifier, color, fontSize, fontStyle, fontWeight, fontFamily, letterSpacing, textDecoration, textAlign, lineHeight, overflow, softWrap, maxLines, minLines, onTextLayout, style!!)
    }


}