import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxColors
import androidx.compose.material.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

class CheckboxBuilder(id: String) : composable<CheckboxBuilder>(id) {

    companion object : BuilderCompanion<CheckboxBuilder>() {
        override fun createBuilder(id: String): CheckboxBuilder {
            return CheckboxBuilder(id)
        }
    }

    private var checked: Boolean = false
    private var onCheckedChange: (Boolean) -> Unit = {}
    private var enabled: Boolean = true

    fun checked(checked: Boolean): CheckboxBuilder {
        this.checked = checked
        return this
    }

    fun onCheckedChange(onCheckedChange: (Boolean) -> Unit): CheckboxBuilder {
        this.onCheckedChange = onCheckedChange
        return this
    }

    fun enabled(enabled : Boolean): CheckboxBuilder {
        this.enabled = enabled
        return this
    }

    @Composable
    override fun compose() {
        Checkbox(
            modifier = modifier,
            checked = checked,
            colors = CheckboxDefaults.colors(),
            interactionSource = remember { MutableInteractionSource() },
            onCheckedChange = onCheckedChange
        )
        dispose(id)
    }

    @Composable
    fun compose(colors: CheckboxColors = CheckboxDefaults.colors(),
            interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },) {
        Checkbox(
            modifier = modifier,
            checked = checked,
            colors = colors,
            interactionSource = interactionSource,
            onCheckedChange = onCheckedChange
        )
        dispose(id)
    }
}