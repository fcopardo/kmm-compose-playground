import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

class LazyRowBuilder : AbstractRowBuilder<LazyRowBuilder> {

    protected var contentPadding: PaddingValues = PaddingValues(0.dp)
    protected var reverseLayout: Boolean = false
    protected var userScrollEnabled: Boolean = true

    private constructor(id : String) : super(id){
        horizontalArrangement(if (!reverseLayout) Arrangement.Start else Arrangement.End)
        verticalAlignment(Alignment.Top)
    }

    fun contentPadding(contentPadding: PaddingValues): LazyRowBuilder {
        this.contentPadding = contentPadding
        return this
    }

    fun reverseLayout(reverse : Boolean): LazyRowBuilder {
        this.reverseLayout = reverse
        return this
    }

    fun userScrollEnabled(userScrollEnabled: Boolean): LazyRowBuilder {
        this.userScrollEnabled = userScrollEnabled
        return this
    }
    
    @Composable
    override fun compose() {
        LazyRow(modifier, rememberLazyListState(), contentPadding, reverseLayout, horizontalArrangement,
            verticalAlignment, ScrollableDefaults.flingBehavior(), userScrollEnabled, {})
    }

    @Composable
    fun compose(flingBehavior: FlingBehavior = ScrollableDefaults.flingBehavior(),
                content: LazyListScope.() -> Unit, state: LazyListState = rememberLazyListState()){
        LazyRow(modifier, state, contentPadding, reverseLayout, horizontalArrangement,
            verticalAlignment, flingBehavior, userScrollEnabled, content)
    }
}