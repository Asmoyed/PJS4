#vertexshader
#version 330 core

#define PI 3.1415926538

attribute vec3 vertices;
attribute vec4 color;
attribute vec2 texCoords;
attribute float texId;
attribute float rotation;

varying vec4 vColor;
varying vec2 vTexCoords;
varying float vTexId;

uniform mat4 projection;

mat4 rotationMatrix(vec3 axis, float angle) {
    axis = normalize(axis);
    float s = sin(angle);
    float c = cos(angle);
    float oc = 1.0 - c;

    return mat4(oc * axis.x * axis.x + c,           oc * axis.x * axis.y - axis.z * s,  oc * axis.z * axis.x + axis.y * s,  0.0,
    oc * axis.x * axis.y + axis.z * s,  oc * axis.y * axis.y + c,           oc * axis.y * axis.z - axis.x * s,  0.0,
    oc * axis.z * axis.x - axis.y * s,  oc * axis.y * axis.z + axis.x * s,  oc * axis.z * axis.z + c,           0.0,
    0.0,                                0.0,                                0.0,                                1.0);
}

vec3 rotate(vec3 v, vec3 axis, float angle) {
    mat4 m = rotationMatrix(axis, angle);
    return (m * vec4(v, 1.0)).xyz;
}
void main() {
    vColor = color;
    vTexCoords = texCoords;
    vTexId = texId;

    gl_Position =   (projection * vec4(vertices, 1.0));
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