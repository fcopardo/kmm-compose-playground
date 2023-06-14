import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

abstract class composable<T> where T : composable<T> {
    protected var id : String = ""
    protected var modifier: Modifier = Modifier

    constructor(someId : String){
        this.id = someId
    }

    @Composable
    abstract fun compose()

    fun modifier(modifier: Modifier): T {
        this.modifier = modifier
        return this as T
    }
}