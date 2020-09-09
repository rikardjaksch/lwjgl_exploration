package engine.rendering.resources;

public class ResourceHandle {
    public static int NOT_INITIALIZED = 0x00ffffff;

    private int typeHandle;

    ResourceHandle() {
        typeHandle = encodeType(NOT_INITIALIZED, NOT_INITIALIZED);
    }

    ResourceHandle(int type) {
        typeHandle = encodeType(NOT_INITIALIZED, type);
    }

    public int type() {
        return (typeHandle & 0xff000000) >> 24;
    }

    public int handle() {
        return typeHandle & 0x00ffffff;
    }

    public boolean isValid() {
        return handle() != NOT_INITIALIZED;
    }

    private int encodeType(int handle, int type) {
        return (handle & 0x00ffffff) | (type << 24);
    }
}
