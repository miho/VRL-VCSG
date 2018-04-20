/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.vrl.vcsg.vplugin;

import eu.mihosoft.vrl.annotation.ComponentInfo;
import eu.mihosoft.vcsg.CSG;
import java.io.Serializable;

/**
 *
 * @author Michael Hoffer &lt;info@michaelhoffer.de&gt;
 */
@ComponentInfo(name="Difference", category="VCSG")
public class Difference implements Serializable{
    public CSG difference(CSG csg1, CSG csg2) {
        return csg1.difference(csg2);
    }
}
