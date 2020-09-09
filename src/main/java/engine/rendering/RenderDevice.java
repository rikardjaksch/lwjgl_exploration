package engine.rendering;

public class RenderDevice {
    /**
     * Creates a new RenderResourceContext that can
     * be used to record the creation of new RenderResources
     * @return A new RenderResourceContext
     */
    public RenderResourceContext newRenderResourceContext() {
        return new RenderResourceContext();
    }


    public void dispatch(RenderResourceContext[] rrc) {

    }
}
