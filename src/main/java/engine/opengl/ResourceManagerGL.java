package engine.opengl;

import engine.opengl.resources.VertexBufferGL;
import engine.rendering.RenderResourceContext;

import java.util.List;

public class ResourceManagerGL {
    private List<VertexBufferGL> vertexBuffers;
    private List<Integer> unusedVertexBuffers;

    public void dispatch(RenderResourceContext context) {
        // 1) Get the list of commands in the context
        // 2) for each command in list
        //          switch (command.type)
        //              case ALLOC_VERTEX_BUFFER
        //              case ALLOC_VERTEX_DECLARATION
    }
}
