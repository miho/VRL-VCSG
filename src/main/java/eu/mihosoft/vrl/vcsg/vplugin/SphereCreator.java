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
@ComponentInfo(name="SphereCreator", category="VCSG")
public class SphereCreator implements Serializable {

    private static final long serialVersionUID = 1L;

    public CSG create(
            @ParamInfo(name="Radius", options="value=1") double radius) {
        return CSG.sphere(Vector3d.ZERO,radius);
    }
}
