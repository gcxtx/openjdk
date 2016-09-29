/*
 * Copyright (c) 2002, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package com.sun.corba.se.impl.resolver ;

import java.util.Set ;
import java.util.HashSet ;

import com.sun.corba.se.spi.resolver.Resolver ;

public class CompositeResolverImpl implements Resolver {
    private Resolver first ;
    private Resolver second ;

    public CompositeResolverImpl( Resolver first, Resolver second )
    {
        this.first = first ;
        this.second = second ;
    }

    public org.omg.CORBA.Object resolve( String name )
    {
        org.omg.CORBA.Object result = first.resolve( name ) ;
        if (result == null)
            result = second.resolve( name ) ;
        return result ;
    }

    public java.util.Set list()
    {
        Set result = new HashSet() ;
        result.addAll( first.list() ) ;
        result.addAll( second.list() ) ;
        return result ;
    }
}
