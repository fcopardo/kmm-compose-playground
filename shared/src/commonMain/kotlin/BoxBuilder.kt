import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable

class BoxBuilder(id: String) : composable<BoxBuilder>(id) {

    companion object : BuilderCompanion<BoxBuilder>() {
        override fun createBuilder(id: String): BoxBuilder {
            return BoxBuilder(id)
        }
    }

    @Composable
    override fun compose() {
        Box(
            modifier = modifier
        )
        id
        dispose(id)
    }

}