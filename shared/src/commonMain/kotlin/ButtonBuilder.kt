import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Shape

class ButtonBuilder(id: String) : composable<ButtonBuilder>(id){

    companion object : BuilderCompanion<ButtonBuilder>() {
        override fun createBuilder(id: String): ButtonBuilder {
            return ButtonBuilder(id)
        }
    }

    private var onClick: () -> Unit = {}
    private var enabled: Boolean = true
    private var border: BorderStroke? = null
    private var contentPadding: PaddingValues = ButtonDefaults.ContentPadding

    fun onClick(onClick: () -> Unit): ButtonBuilder {
        this.onClick = onClick
        return this
    }

    fun borderStroke(borderStroke: BorderStroke): ButtonBuilder {
        this.border = borderStroke
        return this
    }

    fun enabled(enabled : Boolean): ButtonBuilder {
        this.enabled = enabled
        return this
    }

    fun contentPadding(contentPadding : PaddingValues): ButtonBuilder {
        this.contentPadding = contentPadding
        return this
    }
    @Composable
    fun compose(
        interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() },
        elevation: ButtonElevation? = ButtonDefaults.elevation(),
        shape: Shape? = MaterialTheme.shapes.small,
        colors: ButtonColors? = ButtonDefaults.buttonColors(),
        content: @Composable RowScope.() -> Unit,
    ){
        Button(onClick, modifier, enabled, interactionSource!!, elevation!!, shape!!,
            border, colors!!, contentPadding, content)
        dispose(id)
    }

    @Composable
    fun compose(
        content: @Composable RowScope.() -> Unit
    ){
        Button(onClick, modifier, enabled, remember { MutableInteractionSource() },
            ButtonDefaults.elevation(), MaterialTheme.shapes.small, border,
            ButtonDefaults.buttonColors(), contentPadding, content)
        dispose(id)
    }

    @Composable
    override fun compose() {
        Button(onClick, modifier, enabled, remember { MutableInteractionSource() },
            ButtonDefaults.elevation(), MaterialTheme.shapes.small, border,
            ButtonDefaults.buttonColors(), contentPadding
        ) {}
        dispose(id)
    }
}