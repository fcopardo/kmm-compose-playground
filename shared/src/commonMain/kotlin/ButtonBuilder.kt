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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape

class ButtonBuilder {

    private var onClick: () -> Unit = {}
    private var modifier: Modifier = Modifier
    private var enabled: Boolean = true
    private var border: BorderStroke? = null
    private var contentPadding: PaddingValues = ButtonDefaults.ContentPadding

    fun onClick(onClick: () -> Unit): ButtonBuilder {
        this.onClick = onClick
        return this
    }

    fun modifier(modifier: Modifier): ButtonBuilder {
        this.modifier = modifier
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
        Button(onClick, modifier, enabled, interactionSource!!, elevation!!, shape!!, border, colors!!, contentPadding, content)
    }
}