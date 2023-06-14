import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation

class BasicTextFieldBuilder(id: String) : composable<BasicTextFieldBuilder>(id) {
    
    companion object : BuilderCompanion<BasicTextFieldBuilder>(){
        override fun createBuilder(id: String): BasicTextFieldBuilder {
            return BasicTextFieldBuilder(id)
        }
    }

    private var value: TextFieldValue? = null
    private var onValueChange: (TextFieldValue) -> Unit = {}
    private var enabled: Boolean = true
    private var readOnly: Boolean = false
    private var textStyle: TextStyle = TextStyle.Default
    private var keyboardOptions: KeyboardOptions = KeyboardOptions.Default
    private var keyboardActions: KeyboardActions = KeyboardActions.Default
    private var singleLine: Boolean = false
    private var maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE
    private var minLines: Int = 1
    private var visualTransformation: VisualTransformation = VisualTransformation.None
    private var onTextLayout: (TextLayoutResult) -> Unit = {}
    private var cursorBrush: Brush = SolidColor(Color.Black)

    fun value(value : TextFieldValue): BasicTextFieldBuilder {
        this.value = value
        return this
    }

    fun onValueChange(onValueChange: (TextFieldValue) -> Unit): BasicTextFieldBuilder {
        this.onValueChange = onValueChange
        return this
    }

    fun enabled(enabled : Boolean): BasicTextFieldBuilder {
        this.enabled = enabled
        return this
    }

    fun readOnly(readOnly : Boolean): BasicTextFieldBuilder {
        this.readOnly = readOnly
        return this
    }

    fun textStyle(style : TextStyle): BasicTextFieldBuilder {
        textStyle = style
        return this
    }

    fun keyboardOptions(keyboardOptions: KeyboardOptions): BasicTextFieldBuilder {
        this.keyboardOptions = keyboardOptions
        return this
    }

    fun keyboardActions(keyboardActions: KeyboardActions): BasicTextFieldBuilder {
        this.keyboardActions = keyboardActions
        return this
    }

    fun minLines(lines : Int): BasicTextFieldBuilder {
        this.minLines = lines
        return this
    }

    fun maxLines(lines : Int): BasicTextFieldBuilder {
        this.maxLines = lines
        return this
    }

    fun visualTransformation(visualTransformation: VisualTransformation): BasicTextFieldBuilder {
        this.visualTransformation = visualTransformation
        return this
    }

    fun onTextLayout(onTextLayout: (TextLayoutResult) -> Unit): BasicTextFieldBuilder {
        this.onTextLayout = onTextLayout
        return this
    }

    fun cursorBrush(cursorBrush: Brush): BasicTextFieldBuilder {
        this.cursorBrush = cursorBrush
        return this
    }

    @Composable
    override fun compose() {
        BasicTextField(
            value!!, onValueChange, modifier, enabled, readOnly, textStyle, keyboardOptions, keyboardActions, singleLine, maxLines, minLines,
            visualTransformation, onTextLayout, remember { MutableInteractionSource() }, cursorBrush, {})
        dispose(id)
    }

    @Composable
    fun compose(interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }, decorationBox: @Composable (innerTextField: @Composable () -> Unit) -> Unit =
        @Composable { innerTextField -> innerTextField() }) {

        BasicTextField(
            value!!, onValueChange, modifier, enabled, readOnly, textStyle, keyboardOptions, keyboardActions, singleLine, maxLines, minLines,
            visualTransformation, onTextLayout, interactionSource, cursorBrush, decorationBox)
        dispose(id)

    }


}