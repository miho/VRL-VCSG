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
@ComponentInfo(name="CylinderCreator", category="VCSG")
public class CylinderCreator implements Serializable{
    public CSG create(
            @ParamInfo(name="Radius (Top)", options="value=1") double radiusTop,
            @ParamInfo(name="Radius (Bottom)", options="value=1") double radiusBottom,
            @ParamInfo(name="Height", options="value=1") double height) {

        return CSG.cone(Vector3d.z(-height/2.0), radiusBottom, radiusTop, height);
    }
}
