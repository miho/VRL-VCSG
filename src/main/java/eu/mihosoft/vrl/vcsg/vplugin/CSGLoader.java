/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.vrl.vcsg.vplugin;

import eu.mihosoft.vcsg.CSG;
import eu.mihosoft.vrl.annotation.ComponentInfo;
import eu.mihosoft.vrl.annotation.ParamInfo;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author Michael Hoffer &lt;info@michaelhoffer.de&gt;
 */
@ComponentInfo(name="CSG-Loader", category="VCSG")
public class CSGLoader implements Serializable{

    private static final long serialVersionUID = 1L;


    public CSG load(@ParamInfo(name="File", style="load-dialog", options="endings=[\".stl\",\".brep\",\".stp\"]; description=\"CAD files (*.stp, *.stl, *.brep)\"") File f) throws IOException {

        String fName = f.getName();

        if(fName.toLowerCase().endsWith(".stl")) {
            return CSG.fromSTL(f);
        } if(fName.toLowerCase().endsWith(".brep")) {
            return CSG.fromBREP(f);
        } if(fName.toLowerCase().endsWith(".stp")) {
            return CSG.fromSTEP(f);
        }

        throw new RuntimeException("Unsupported file format: " + f);
    }

}
