package engine.rendering.resources;

public class VertexDeclarationResource extends ResourceHandle {
    public static class Channel {
        VertexComponent component;
        ChannelType type;

        public Channel(VertexComponent component, ChannelType type) {
            this.component = component;
            this.type = type;
        }
    }

    public Channel[] channels;

    public VertexDeclarationResource() {
        super(ResourceType.VERTEX_DECLARATION);
        channels = null;
    }

    public VertexDeclarationResource(Channel[] channels) {
        super(ResourceType.VERTEX_DECLARATION);
        this.channels = channels.clone();
    }
}
