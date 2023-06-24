import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment

abstract class AbstractRowBuilder<T>(id : String) : composable<T>(id) where T : composable<T> {

    protected var horizontalArrangement: Arrangement.Horizontal = Arrangement.Start
    protected var verticalAlignment: Alignment.Vertical = Alignment.Top

    fun horizontalArrangement(horizontalArrangement: Arrangement.Horizontal) : T {
        this.horizontalArrangement = horizontalArrangement
        return this as T
    }

    fun verticalAlignment(verticalAlignment: Alignment.Vertical): T {
        this.verticalAlignment = verticalAlignment
        return this as T
    }

}