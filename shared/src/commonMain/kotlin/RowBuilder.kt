import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable

class RowBuilder(id: String) : AbstractRowBuilder<RowBuilder>(id) {

    @Composable
    override fun compose() {
        Row(modifier, horizontalArrangement, verticalAlignment, {})
    }

    @Composable
    fun compose(content: @Composable RowScope.() -> Unit) {
        Row(modifier, horizontalArrangement, verticalAlignment, content)
    }
}