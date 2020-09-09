package engine.context;

public class WindowBuilder {
    private static final String DEFAULT_TITLE = "Sandbox";

    private final int width;
    private final int height;

    private String title = DEFAULT_TITLE;
    private boolean fullScreen = false;

    WindowBuilder(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public WindowBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public WindowBuilder fullscreen(boolean fullscreen) {
        this.fullScreen = fullscreen;
        return this;
    }

    public Window create() {
        return new Window(this);
    }

    protected int getWidth() {
        return width;
    }

    protected int getHeight() {
        return height;
    }

    protected String getTitle() {
        return title;
    }

    protected boolean getFullScreen() {
        return fullScreen;
    }
}
