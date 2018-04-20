/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.vrl.vcsg.vplugin;

import eu.mihosoft.vcsg.CSG;
import eu.mihosoft.vrl.annotation.ComponentInfo;
import eu.mihosoft.vrl.annotation.ParamInfo;
import eu.mihosoft.vvecmath.Vector3d;

import java.io.Serializable;

/**
 *
 * @author Michael Hoffer &lt;info@michaelhoffer.de&gt;
 */
@ComponentInfo(name="CubeCreator", category="VCSG")
public class CubeCreator implements Serializable{
    public CSG create(
            @ParamInfo(name="W", options="value=1") double w,
            @ParamInfo(name="H", options="value=1") double h,
            @ParamInfo(name="D", options="value=1") double d) {

        double minX = - w/2.0;
        double minY = - h/2.0;
        double minZ = - d/2.0;

        double maxX = + w/2.0;
        double maxY = + h/2.0;
        double maxZ = + d/2.0;

        return CSG.box(Vector3d.xyz(minX,minY,minZ), Vector3d.xyz(maxX,maxY,maxZ));
    }
}
