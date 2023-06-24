import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    MaterialTheme {
        var greetingText by remember { mutableStateOf("Hello, World!") }
        var showImage by remember { mutableStateOf(false) }

        TextBuilder.get("main")
            .text(greetingText)
            .modifier(Modifier.onKeyEvent { event->
                println("event type is "+event.toString())
                false
            })
            .color(Color.Red)
            .fontFamily(FontFamily.Serif)
            .fontStyle(FontStyle.Italic)
            .fontSize(TextUnit(15f, TextUnitType.Sp))
            .letterSpacing(TextUnit(10f, TextUnitType.Sp))
            .textAlign(TextAlign.Right)
            .overflow(TextOverflow.Ellipsis)

        ColumnBuilder.get("main")
            .modifier(Modifier.fillMaxWidth())
            .horizontalAlignment(Alignment.CenterHorizontally)
            .compose {
                ButtonBuilder.get("main")
                    .onClick { greetingText = "Hello, ${getPlatformName()}"
                        showImage = !showImage }
                    .compose {
                        TextBuilder.get("main")
                            .compose()
                    }
                AnimatedVisibility(showImage) {
                    Image(
                        painterResource("compose-multiplatform.xml"),
                        null
                    )
                }
                AnimatedVisibility(!showImage){
                    LazyColumn {
                    }
                }
            }
    }
}

expect fun getPlatformName(): String