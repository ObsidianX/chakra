package net.obsidianx.chakra

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import net.obsidianx.chakra.types.FlexAlign
import net.obsidianx.chakra.types.FlexDirection
import net.obsidianx.chakra.types.FlexJustify
import net.obsidianx.chakra.types.FlexPositionType

@Composable
fun DepthLayout() {
    Flexbox(
        modifier = Modifier
            .flex {
                debugTag("outer")
                debugDump()
                width(300.dp)
                height(300.dp)
                alignItems(FlexAlign.Center)
                justifyContent(FlexJustify.Center)
            }
            .border(1.dp, Color.Red)
    ) {
        Flexbox(modifier = Modifier
            .flex {
                depthLayout()
                debugTag("depth-layer1")
                alignItems(FlexAlign.Center)
                justifyContent(FlexJustify.Center)
                padding(16.dp)
            }
            .border(1.dp, Color.Magenta)
            .clipToBounds()
        ) {
            Flexbox(
                modifier = Modifier
                    .flex {
                        depthLayout()
                        debugTag("depth-layer2")
                        alignItems(FlexAlign.Center)
                        justifyContent(FlexJustify.Center)
                        padding(16.dp)
                    }
                    .border(1.dp, Color.Green)
            ) {
                Text(
                    "Hello, World!",
                    modifier = Modifier
                        .border(1.dp, Color.Blue)
                        .flex {
                            debugTag("text")
                        }
                )
            }
        }
    }

    Spacer(modifier = Modifier.size(10.dp))

    Flexbox(modifier = Modifier.flex {
        direction(FlexDirection.Row)
    }) {
        NineSegment(align = FlexAlign.Start, justify = FlexJustify.Start)
        Spacer(modifier = Modifier.size(5.dp))
        NineSegment(align = FlexAlign.Center, justify = FlexJustify.Start)
        Spacer(modifier = Modifier.size(5.dp))
        NineSegment(align = FlexAlign.End, justify = FlexJustify.Start)
    }
    Spacer(modifier = Modifier.size(5.dp))
    Flexbox(modifier = Modifier.flex {
        direction(FlexDirection.Row)
    }) {
        NineSegment(align = FlexAlign.Start, justify = FlexJustify.Center)
        Spacer(modifier = Modifier.size(5.dp))
        NineSegment(align = FlexAlign.Center, justify = FlexJustify.Center)
        Spacer(modifier = Modifier.size(5.dp))
        NineSegment(align = FlexAlign.End, justify = FlexJustify.Center)
    }
    Spacer(modifier = Modifier.size(5.dp))
    Flexbox(modifier = Modifier.flex {
        direction(FlexDirection.Row)
    }) {
        NineSegment(align = FlexAlign.Start, justify = FlexJustify.End)
        Spacer(modifier = Modifier.size(5.dp))
        NineSegment(align = FlexAlign.Center, justify = FlexJustify.End)
        Spacer(modifier = Modifier.size(5.dp))
        NineSegment(align = FlexAlign.End, justify = FlexJustify.End)
    }

    Spacer(modifier = Modifier.size(10.dp))

    Flexbox(modifier = Modifier
        .flex {
            direction(FlexDirection.Column)
            height(50.dp)
            alignItems(FlexAlign.Stretch)
        }
        .border(1.dp, Color.Red)) {
        Flexbox(modifier = Modifier
            .flex {
                depthLayout()
                justifyContent(FlexJustify.Center)
                alignItems(FlexAlign.Center)
            }
            .border(1.dp, Color.Blue)) {
            Text(
                modifier = Modifier.flex { positionType(FlexPositionType.Absolute) },
                text = "Hello"
            )
            Text(
                modifier = Modifier.flex { positionType(FlexPositionType.Absolute) },
                text = "World"
            )
        }
    }

    Spacer(modifier = Modifier.size(10.dp))

    Flexbox(modifier = Modifier
        .flex {
            direction(FlexDirection.Column)
            height(50.dp)
            alignItems(FlexAlign.Start)
        }
        .border(1.dp, Color.Red)) {
        Flexbox(modifier = Modifier
            .flex {
                depthLayout()
                justifyContent(FlexJustify.Center)
                alignItems(FlexAlign.Center)
            }
            .border(1.dp, Color.Blue)) {
            Text(text = "Hello")
            Text(text = "World")
        }
    }

    Spacer(modifier = Modifier.size(10.dp))

    Flexbox(modifier = Modifier
        .flex {
            direction(FlexDirection.Column)
            height(50.dp)
        }
        .border(1.dp, Color.Red)) {
        Flexbox(modifier = Modifier
            .flex {
                depthLayout()
                justifyContent(FlexJustify.Center)
                alignItems(FlexAlign.Center)
            }
            .border(1.dp, Color.Blue)) {
            Flexbox(modifier = Modifier
                .flex {
                    depthLayout()
                    width(50f)
                    height(50f)
                    minWidth(1.dp)
                    minHeight(1.dp)
                }
                .border(1.dp, Color.Green)) {
                Text(text = "Hello")
                Text(text = "World")
            }
        }
    }
}

@Composable
fun NineSegment(align: FlexAlign, justify: FlexJustify) {
    Flexbox(modifier = Modifier
        .flex {
            width(50.dp)
            height(50.dp)
            depthLayout(true)
            alignItems(align)
            justifyContent(justify)
            padding(10.dp)
        }
        .border(1.dp, Color.Green)
        .clipToBounds()) {
        Flexbox(modifier = Modifier
            .flex {
                width(100.dp)
                height(100.dp)
            }
            .background(Color.Blue, RoundedCornerShape(100))
            .border(1.dp, Color.Blue, RoundedCornerShape(100))
        )
    }
}
