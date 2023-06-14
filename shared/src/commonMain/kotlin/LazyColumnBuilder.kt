import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

class LazyColumnBuilder(id : String) : composable<LazyColumnBuilder>(id) {

    companion object : BuilderCompanion<LazyColumnBuilder>() {
        override fun createBuilder(id: String): LazyColumnBuilder {
            return LazyColumnBuilder(id)
        }
    }

    private var listItems: List<Any> = emptyList()
    private var reverseLayout: Boolean = false

    fun items(items: List<Any>): LazyColumnBuilder {
        this.listItems = items
        return this
    }

    fun reverseLayout(reverseLayout: Boolean): LazyColumnBuilder {
        this.reverseLayout = reverseLayout
        return this
    }

    @Composable
    override fun compose() {
        LazyColumn(
            modifier = modifier,
            reverseLayout = reverseLayout,
            state = rememberLazyListState(),
            content = {
                items(listItems){ item->
                    Text(item.toString())
                }
            }
        )
        dispose(id)
    }

    @Composable
    fun compose(content: LazyListScope.() -> Unit) {
        LazyColumn(
            modifier = modifier,
            reverseLayout = reverseLayout,
            state = rememberLazyListState(),
            content = content
        )
        dispose(id)
    }
}