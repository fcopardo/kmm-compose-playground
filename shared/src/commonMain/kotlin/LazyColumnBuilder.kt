import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

class LazyColumnBuilder(id : String) : composable<LazyColumnBuilder>(id) {

    companion object : BuilderCompanion<LazyColumnBuilder>() {
        override fun createBuilder(id: String): LazyColumnBuilder {
            return LazyColumnBuilder(id)
        }
    }

    private var listItems: List<Any> = emptyList()
    private var reverseLayout: Boolean = false
    private var contentPadding: PaddingValues = PaddingValues(0.dp)

    private var verticalArrangement: Arrangement.Vertical =
        if (!reverseLayout) Arrangement.Top else Arrangement.Bottom

    private var horizontalAlignment: Alignment.Horizontal = Alignment.Start
    private var userScrollEnabled: Boolean = true


    fun items(items: List<Any>): LazyColumnBuilder {
        this.listItems = items
        return this
    }

    fun reverseLayout(reverseLayout: Boolean): LazyColumnBuilder {
        this.reverseLayout = reverseLayout
        return this
    }

    fun contentPadding(contentPadding: PaddingValues): LazyColumnBuilder {
        this.contentPadding = contentPadding
        return this
    }

    fun verticalArrangement(verticalArrangement: Arrangement.Vertical): LazyColumnBuilder {
        this.verticalArrangement = verticalArrangement
        return this
    }

    fun horizontalAlignment(horizontalAlignment: Alignment.Horizontal): LazyColumnBuilder {
        this.horizontalAlignment = horizontalAlignment
        return this
    }

    fun userScrollEnabled(userScrollEnabled: Boolean): LazyColumnBuilder {
        this.userScrollEnabled = userScrollEnabled
        return this
    }

    @Composable
    override fun compose() {
        LazyColumn(
            modifier,
            rememberLazyListState(),
            contentPadding,
            reverseLayout,
            verticalArrangement,
            horizontalAlignment,
            ScrollableDefaults.flingBehavior(),
            userScrollEnabled,
            {}
        )
        dispose(id)
    }

    @Composable
    fun compose(content: LazyListScope.() -> Unit, state: LazyListState = rememberLazyListState(),
                flingBehavior: FlingBehavior = ScrollableDefaults.flingBehavior()) {
        LazyColumn(
            modifier,
            state,
            contentPadding,
            reverseLayout,
            verticalArrangement,
            horizontalAlignment,
            flingBehavior,
            userScrollEnabled,
            content
        )
        dispose(id)
    }
}