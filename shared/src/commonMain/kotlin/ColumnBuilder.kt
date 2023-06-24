import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class ColumnBuilder(id: String) : composable<ColumnBuilder>(id) {

    companion object : BuilderCompanion<ColumnBuilder>() {
        override fun createBuilder(id: String): ColumnBuilder {
            return ColumnBuilder(id)
        }
    }

    private var verticalArrangement: Arrangement.Vertical = Arrangement.Top
    private var horizontalAlignment: Alignment.Horizontal = Alignment.Start

    fun verticalArrangement(verticalArrangement: Arrangement.Vertical): ColumnBuilder {
        this.verticalArrangement = verticalArrangement
        return this
    }

    fun horizontalAlignment(horizontalAlignment: Alignment.Horizontal): ColumnBuilder {
        this.horizontalAlignment = horizontalAlignment
        return this
    }

    @Composable
    fun compose(content: @Composable ColumnScope.() -> Unit){
        Column(modifier, verticalArrangement, horizontalAlignment, content)
        dispose(id)
    }

    @Composable
    override fun compose() {
        Column(modifier, verticalArrangement, horizontalAlignment, {})
    }

}