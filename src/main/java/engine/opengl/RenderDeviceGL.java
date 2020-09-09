package engine.opengl;

import engine.rendering.RenderDevice;

public class RenderDeviceGL extends RenderDevice {
    private ResourceManagerGL resourceManager;

    public RenderDeviceGL() {
        resourceManager = new ResourceManagerGL();
    }
}
