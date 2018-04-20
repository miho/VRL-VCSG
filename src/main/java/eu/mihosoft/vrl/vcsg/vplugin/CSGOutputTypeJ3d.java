/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.mihosoft.vrl.vcsg.vplugin;

import eu.mihosoft.vcsg.CSG;
import eu.mihosoft.vrl.annotation.TypeInfo;
import eu.mihosoft.vrl.v3d.VGeometry3D;

import java.awt.*;


/**
 *
 * @author Michael Hoffer &lt;info@michaelhoffer.de&gt;
 */
@TypeInfo(input = false, output = true, style = "j3d", type = CSG.class)
public class CSGOutputTypeJ3d extends VGeometry3DType {
    private CSG viewValue;
    
    @Override
    public void setViewValue(Object o) {
        if (o instanceof CSG) {
            CSG csg = (CSG) o;
            viewValue = csg;
            super.setViewValue(new VGeometry3D(
                    VTriangleConverter.toVTriangleArray(csg), Color.RED, null, 1.0f, false));
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
