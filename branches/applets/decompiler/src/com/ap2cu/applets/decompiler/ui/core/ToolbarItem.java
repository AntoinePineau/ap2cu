/*
 *  ToolBarItem.java Copyright (c) 2006,07 Swaroop Belur 
 *  
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *
 */

package com.ap2cu.applets.decompiler.ui.core;

import javax.swing.*;

/**
 * @author swaroop belur
 */
public class ToolbarItem extends UIObject {
     public void setDesc(java.lang.String desc)
     {
         this.whatAmI=desc;
     }

     JMenu jmenu=null;

    public ToolbarItem(String title)
    {
       jmenu=new JMenu(title);
    }

    public JMenu getItem()
    {
        return jmenu;
    }


    public void addChild(ActionItem child)
    {
       registerChild(child);
    }
    private void registerChild(ActionItem child)
    {
        jmenu.add(child.getItem());
    }

}
