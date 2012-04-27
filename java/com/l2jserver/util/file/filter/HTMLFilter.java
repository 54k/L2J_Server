/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.l2jserver.util.file.filter;

import java.io.File;
import java.io.FileFilter;

/**
 * Specialized {@link FileFilter} class.<br>
 * Accepts <b>files</b> ending with ".htm" and ".html" only.
 * @author Zoey76
 */
public class HTMLFilter implements FileFilter
{
	@Override
	public boolean accept(File f)
	{
		if ((f == null) || !f.isFile())
		{
			return false;
		}
		final String name = f.getName().toLowerCase();
		return name.endsWith(".htm") || name.endsWith(".html");
	}
}
