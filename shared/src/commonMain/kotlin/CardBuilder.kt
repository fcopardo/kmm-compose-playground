import androidx.compose.foundation.BorderStroke
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp

class CardBuilder(id : String) : composable<CardBuilder>(id) {

    companion object : BuilderCompanion<CardBuilder>() {
        override fun createBuilder(id: String): CardBuilder {
            return CardBuilder(id)
        }
    }

    private var backgroundColor: Color = Color.Unspecified
    private var elevation: Dp = Dp.Unspecified
    private var border: BorderStroke? = null

    fun backgroundColor(backgroundColor: Color): CardBuilder {
        this.backgroundColor = backgroundColor
        return this
    }

    fun elevation(elevation: Dp): CardBuilder {
        this.elevation = elevation
        return this
    }

    fun border(stroke : BorderStroke): CardBuilder {
        this.border = stroke
        return this
    }

    @Composable
    override fun compose() {
        Card(
            modifier = modifier,
            backgroundColor = backgroundColor,
            elevation = elevation,
            content = { },
            shape = MaterialTheme.shapes.medium,
            contentColor = contentColorFor(backgroundColor)
        )
    }

    @Composable
    fun compose(shape: Shape = MaterialTheme.shapes.medium,
                contentColor: Color = contentColorFor(backgroundColor),
                content: @Composable () -> Unit){
        Card(
            modifier = modifier,
            backgroundColor = backgroundColor,
            elevation = elevation,
            content = content,
            shape = shape,
            contentColor = contentColor
        )
    }
}