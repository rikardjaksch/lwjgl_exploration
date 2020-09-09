package client;

import engine.context.Window;
import engine.opengl.RenderDeviceGL;
import engine.rendering.RenderDevice;
import engine.rendering.RenderResourceContext;
import engine.rendering.resources.ChannelType;
import engine.rendering.resources.VertexComponent;
import engine.rendering.resources.VertexDeclarationResource;

public class EntryPoint {
    // Systems
    private Window win;
    private RenderDevice renderDevice;
    private RenderResourceContext rrc;

    // Resources used for rendering
    VertexDeclarationResource vdr;

    private void init() {
        // Create the window and the rendering device
        win = Window.newWindow(1280, 720).setTitle("Example").fullscreen(false).create();
        renderDevice = new RenderDeviceGL();

        // Create a render resource context from the rendering device
        // so that we can allocate client-side resources on the backend.
        rrc = renderDevice.newRenderResourceContext();

        // Create some resources on the client
        VertexDeclarationResource.Channel[] channels = new VertexDeclarationResource.Channel[2];
        channels[0] = new VertexDeclarationResource.Channel(VertexComponent.POSITION, ChannelType.FLOAT3);
        channels[1] = new VertexDeclarationResource.Channel(VertexComponent.COLOR, ChannelType.FLOAT3);
        vdr = new VertexDeclarationResource(channels);
        rrc.allocate(vdr);

        // Allocate the resources on the backend (several render resource context
        // objects can be used)
        renderDevice.dispatch(new RenderResourceContext[] {rrc});
    }

    private void run() {
        while (!win.isClosing()) {
            win.pollEvents();
            win.swapBuffers();
        }
    }

    private void destroy() {
        rrc.deallocate(vdr);
        win.destroy();
    }

    public static void main(String[] args) {
        try {
            EntryPoint ep = new EntryPoint();
            ep.init();
            ep.run();
            ep.destroy();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
