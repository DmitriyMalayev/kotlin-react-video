import react.FC
import react.Props
import react.dom.html.ReactHTML.p
import react.key

external interface VideoListProps : Props {
    var videos: List<Video>
    var selectedVideo: Video?
    var onSelectVideo: (Video) -> Unit     //function that takes a Video and returns Unit
}

val VideoList = FC<VideoListProps> { props ->
    //    var selectedVideo: Video? by useState(null)    //Video? can be null
    for (video in props.videos) {
        p {
            key = video.id.toString()   //Why toString?
            onClick = {
                props.onSelectVideo(video)  //when rendered
            }
            if (video == props.selectedVideo) {
                +"▶ "
            }
            +"${video.speaker}: ${video.title}"
        }
    }
}

/*
This interface will hold all the props which can be passed to a VideoList component.
The external modified tells the compiler that the interface's implementation is provided externally, so it doesn't try to generate JavaScript code from the declaration.

The VideoList functional component keeps state (a value that's independent of the current function invocation)  State is nullable and has the Video? type.   It's default value is null.

The useState() function from React instructs the framework to keep track of state across multiple invocations of the function. For example, even though you specify a default value, React makes sure that the default value is only assigned in the beginning. When state changes the component will rerender based on the new state.

The by keyword indicates that useState() acts as a delegated property. Like with any other variable, you read and write values.

*/
