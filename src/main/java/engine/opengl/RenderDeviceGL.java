package engine.opengl;

import engine.rendering.RenderDevice;
import engine.rendering.RenderResourceContext;

public class RenderDeviceGL extends RenderDevice {
    private ResourceManagerGL resourceManager;

    public RenderDeviceGL() {
        resourceManager = new ResourceManagerGL();
    }

    public void dispatch(RenderResourceContext[] rrc) {
        for (RenderResourceContext context : rrc) {
            resourceManager.dispatch(context);
        }
    }
}
