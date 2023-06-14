import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class ColumnBuilder {

    companion object{
        private var activeBuilders = mutableMapOf<String, ColumnBuilder>()
        fun get(id : String): ColumnBuilder {
            if(activeBuilders.containsKey(id)) return activeBuilders[id]!!
            var builder = ColumnBuilder(id)
            activeBuilders[id] = builder
            return builder
        }

        fun dispose(id : String){
            activeBuilders.remove(id)
        }

        fun destroy(){
            activeBuilders.clear()
        }
    }

    private var id = ""
    private var modifier: Modifier = Modifier
    private var verticalArrangement: Arrangement.Vertical = Arrangement.Top
    private var horizontalAlignment: Alignment.Horizontal = Alignment.Start

    private constructor(id: String){
        this.id = id
    }

    fun modifier(modifier : Modifier) : ColumnBuilder {
        this.modifier = modifier
        return this
    }

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
    
}