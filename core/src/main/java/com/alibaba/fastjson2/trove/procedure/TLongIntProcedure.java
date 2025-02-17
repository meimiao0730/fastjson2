///////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2001, Eric D. Friedman All Rights Reserved.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this program; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
///////////////////////////////////////////////////////////////////////////////

package com.alibaba.fastjson2.trove.procedure;

//////////////////////////////////////////////////
// THIS IS A GENERATED CLASS. DO NOT HAND EDIT! //
//////////////////////////////////////////////////


/**
 * Interface for procedures that take two parameters of type long and int.
 */
public interface TLongIntProcedure {

    /**
     * Executes this procedure. A false return value indicates that
     * the application executing this procedure should not invoke this
     * procedure again.
     *
     * @param a a <code>long</code> value
     * @param b a <code>int</code> value
     * @return true if additional invocations of the procedure are
     * allowed.
     */
    boolean execute(long a, int b);
}
