#vertexshader
#version 330 core

attribute vec3 vertices;
attribute vec4 color;
attribute vec2 texCoords;
attribute float texId;
attribute int rotation;

varying vec4 vColor;
varying vec2 vTexCoords;
varying float vTexId;

uniform mat4 projection;

mat4 rotation3dZ(float angle) {
    float s = sin(angle);
    float c = cos(angle);

    return mat4(
    c, s, 0.0,0.0,
    -s, c, 0.0,0.0,
    0.0, 0.0, 1.0,0.0,
    0.0,0.0,0.0,1.0
    );
}
void main() {
    vColor = color;
    vTexCoords = texCoords;
    vTexId = texId;
    gl_Position =  rotation3dZ(rotation) * (projection * vec4(vertices, 1.0));
}

#fragmentshader
#version 330 core

uniform sampler2D[8] uTextures;

varying vec4 vColor;
varying vec2 vTexCoords;
varying float vTexId;

void main() {
    if (vTexId > 0) {
        int id = int(vTexId);
        gl_FragColor = vColor * texture(uTextures[id], vTexCoords);
    }
    else {
        gl_FragColor = vColor;
    }
}