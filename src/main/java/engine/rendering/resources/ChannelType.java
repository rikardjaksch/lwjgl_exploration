package engine.rendering.resources;

public enum ChannelType {
    FLOAT1(4, 1),
    FLOAT2(4, 2),
    FLOAT3(4, 3),
    FLOAT4(4, 4);

    private int typeSize;
    private int elementCount;

    ChannelType(int typeSize, int elementCount) {
        this.typeSize = typeSize;
        this.elementCount = elementCount;
    }

    public int typeSize() {
        return typeSize;
    }

    public int elementCount() {
        return elementCount;
    }

    public int byteSize() {
        return typeSize * elementCount;
    }
}
