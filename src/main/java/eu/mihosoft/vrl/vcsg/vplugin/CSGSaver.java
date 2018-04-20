/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.vrl.vcsg.vplugin;

import eu.mihosoft.vcsg.CSG;
import eu.mihosoft.vrl.annotation.ComponentInfo;
import eu.mihosoft.vrl.annotation.MethodInfo;
import eu.mihosoft.vrl.annotation.ParamInfo;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author Michael Hoffer &lt;info@michaelhoffer.de&gt;
 */
@ComponentInfo(name="CSG-Saver", category="VCSG")
public class CSGSaver implements Serializable{

    private static final long serialVersionUID = 1L;


    @MethodInfo(hide = false)
    public File save(@ParamInfo(name="File", style="save-dialog", options="endings=[\".stl\",\".brep\",\".stp\"]; description=\"CAD files (*.stp, *.stl, *.brep)\"") File f, CSG csg) throws IOException {

        String fName = f.getName();

        if(fName.toLowerCase().endsWith(".stl")) {
            csg.toSTL(f);
        } if(fName.toLowerCase().endsWith(".brep")) {
            csg.toBREP(f);
        } if(fName.toLowerCase().endsWith(".stp")) {
            csg.toSTEP(f);
        }

        return f;
    }

    public File saveSTL(@ParamInfo(name="File", style="save-dialog", options="endings=[\".stl\"]; description=\"CAD files (*.stl)\"") File f,
                        @ParamInfo(name="TOL", options="value=0.5") double tol, CSG csg) throws IOException {

        csg.toSTL(f,tol);

        return f;
    }
}
