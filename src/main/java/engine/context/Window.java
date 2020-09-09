package engine.context;

import org.lwjgl.glfw.GLFWVidMode;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.*;

public class Window {
    private long handle;

    Window(WindowBuilder settings) {
        if (!glfwInit()) {
            throw new RuntimeException("Failed to initialize GLFW");
        }

        glfwDefaultWindowHints();

        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 2);
        glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GLFW_TRUE);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);

        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);

        if (settings.getFullScreen()) {
            long primary_monitor = glfwGetPrimaryMonitor();
            GLFWVidMode video_mode = glfwGetVideoMode(primary_monitor);
            if (video_mode == null) {
                throw new RuntimeException("Failed to video mode from primary monitor");
            }

            glfwWindowHint(GLFW_RED_BITS, video_mode.redBits());
            glfwWindowHint(GLFW_GREEN_BITS, video_mode.greenBits());
            glfwWindowHint(GLFW_BLUE_BITS, video_mode.blueBits());
            glfwWindowHint(GLFW_REFRESH_RATE, video_mode.refreshRate());

            handle = glfwCreateWindow(video_mode.width(), video_mode.height(), settings.getTitle(), primary_monitor, NULL);
        } else {
            handle = glfwCreateWindow(settings.getWidth(), settings.getHeight(), settings.getTitle(), NULL, NULL);
        }

        if (handle == NULL) {
            throw new RuntimeException("Failed to create GLFW Window");
        }

        // TEMPORARY
        glfwSetKeyCallback(handle, (window, key, scan_code, action, mods) -> {
            if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
                glfwSetWindowShouldClose(window, true);
        });

        glfwMakeContextCurrent(handle);
        glfwShowWindow(handle);
    }

    public static WindowBuilder newWindow(int width, int height) {
        return new WindowBuilder(width, height);
    }

    public boolean isClosing() {
        return glfwWindowShouldClose(handle);
    }

    public void pollEvents() {
        glfwPollEvents();
    }

    public void swapBuffers() {
        glfwSwapBuffers(handle);
    }

    public void destroy() {
        glfwDestroyWindow(handle);
        glfwTerminate();
    }
}
