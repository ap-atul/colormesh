# colormesh
Color Mesh is a library that can create gradient and colour background for android views.

## Usage
1. HEX Color codes: Add hex codes of color to the ColorMesh object to create a gradient. Similarly add
multiple colors to create a complex gradient.
2. Shape: Mention shape possible values ```RECTANGLE``` , ```OVAL``` and ```RING```.
3. Transparency/Alpha : Define visibility
4. Generate Colors : Random colors from ```Palette```
5. Orientation: Set Orientation for the gradient
6. Type: Set type of Gradient possible values ```LINEAR``` and ```RADIAL```


* Define an object
```java
ColorMesh colorMesh = new ColorMesh();
```

* Make fixed single color shape
```java
colorMesh
    .setColor("#216EF3")
    .setTransparency(70)
    .setOrientation(ColorMesh.TL_BR)
    .setType(ColorMesh.LINEAR)
    .setShape(ColorMesh.OVAL)
    .setCornerRadius(15)
    .attach(YOUR_VIEW);
```

* Make a random color gradient
```java
colorMesh
    .setRandomColors(FRUITY, 3) // Palette and count of colors
    .setTransparency(70)
    .setOrientation(ColorMesh.BR_TL)
    .setType(ColorMesh.LINEAR)
    .setShape(ColorMesh.OVAL)
    .setCornerRadius(15)
    .attach(YOUR_VIEW);
```

* Custom gradient color shape
```java
colorMesh
    .setColors(new String[]{
            "#216EF3",
            "#4BA1FC",
            "#4BA2FC",
            "#03A9F4"
    })
    .setTransparency(70)
    .setOrientation(ColorMesh.TOP_BOTTOM)
    .setType(ColorMesh.LINEAR)
    .setShape(ColorMesh.RECTANGLE)
    .setCornerRadius(15)
    .attach(YOUR_VIEW);
```