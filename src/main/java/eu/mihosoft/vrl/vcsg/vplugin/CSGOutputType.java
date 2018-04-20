/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.vrl.vcsg.vplugin;

import eu.mihosoft.vcsg.CSG;
import eu.mihosoft.vrl.annotation.TypeInfo;
import eu.mihosoft.vrl.vrljoglplugin.JoglType;
import eu.mihosoft.vrl.vrljoglplugin.glview.GLMeshCanvas;
import eu.mihosoft.vrl.vrljoglplugin.glview.STLLoader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


/**
 *
 * @author Michael Hoffer &lt;info@michaelhoffer.de&gt;
 */
@TypeInfo(input = false, output = true, style = "default", type = CSG.class)
public class CSGOutputType extends JoglType {
    private CSG viewValue;
    
    @Override
    public void setViewValue(Object o) {
        if (o instanceof CSG) {
            CSG csg = (CSG) o;
            viewValue = csg;

            try {
                File stlFile = Files.createTempFile("vrl_stl", ".stl").toFile();
                csg.toSTL(stlFile);
                GLMeshCanvas meshCanvas = new GLMeshCanvas(new STLLoader().loadMesh(stlFile));
                meshCanvas.setSkipInitAnimation(true);
                super.setViewValue(meshCanvas);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void emptyView() {
        viewValue=null;
        super.emptyView();
    }
    
    
    
    @Override
    public Object getViewValue() {
        return viewValue;
    }

    @Override
    public boolean preferBinarySerialization() {
        return true;
    }
    
    
}
