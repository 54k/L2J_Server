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
package com.l2jserver.gameserver.util;

import gnu.trove.TIntObjectHashMap;
import gnu.trove.TIntObjectProcedure;
import gnu.trove.TIntProcedure;
import gnu.trove.TObjectFunction;
import gnu.trove.TObjectProcedure;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Custom extension of TIntObjectHashMap that is synchronised via ReentrantReadWriteLock.
 * The purpose of this map is to replace the use of FastMap<K,V>.shared() which requires a lot of resources.
 * 
 * @author Nik
 *
 * @param <V> value object.
 */
public class L2TIntObjectHashMap<V extends Object> extends TIntObjectHashMap<V>
{
	private final Lock _readLock;
	private final Lock _writeLock;

	public L2TIntObjectHashMap()
	{
		super();
		ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
		_readLock = lock.readLock();
		_writeLock = lock.writeLock();
	}
	
	 public V put(int key, V value)
	 {
		 _writeLock.lock();
		 try
		 {
			 return super.put(key, value);
		 }
		 finally
		 {
			 _writeLock.unlock();
		 }
	 }
	 
	 public V get(int key)
	 {
		 _readLock.lock();
		 try
		 {
			 return super.get(key);
		 }
		 finally
		 {
			 _readLock.unlock();
		 }
	 }
	 
	 public void clear()
	 {
		 _writeLock.lock();
		 try
		 {
			 super.clear();
		 }
		 finally
		 {
			 _writeLock.unlock();
		 }
	 }
	 
	 public V remove(int key)
	 {
		 _writeLock.lock();
		 try
		 {
			 return super.remove(key);
		 }
		 finally
		 {
			 _writeLock.unlock();
		 }
	 }
	 
	 public boolean equals(Object other)
	 {
		 _readLock.lock();
		 try
		 {
			 return super.equals(other);
		 }
		 finally
		 {
			 _readLock.unlock();
		 }
	 }
	 
	 public Object[] getValues()
	 {
		 _readLock.lock();
		 try
		 {
			 return super.getValues();
		 }
		 finally
		 {
			 _readLock.unlock();
		 }
	 }
	 
	 public <T> T[] getValues(T[] arg0)
	 {
		 _readLock.lock();
		 try
		 {
			 return super.getValues(arg0);
		 }
		 finally
		 {
			 _readLock.unlock();
		 }
	 }
	 
	 public int[] keys()
	 {
		 _readLock.lock();
		 try
		 {
			 return super.keys();
		 }
		 finally
		 {
			 _readLock.unlock();
		 }
	 }
	 
	 public int[] keys(int[] arg0)
	 {
		 _readLock.lock();
		 try
		 {
			 return super.keys(arg0);
		 }
		 finally
		 {
			 _readLock.unlock();
		 }
	 }
	 
	 public boolean contains(int val)
	 {
		 _readLock.lock();
		 try
		 {
			 return super.contains(val);
		 }
		 finally
		 {
			 _readLock.unlock();
		 }
	 }
	 
	 public boolean containsValue(V arg0)
	 {
		 _readLock.lock();
		 try
		 {
			 return super.containsValue(arg0);
		 }
		 finally
		 {
			 _readLock.unlock();
		 }
	 }
	 
	 public boolean containsKey(int key)
	 {
		 _readLock.lock();
		 try
		 {
			 return super.containsKey(key);
		 }
		 finally
		 {
			 _readLock.unlock();
		 }
	 }
	 
	 public boolean forEachKey(TIntProcedure procedure)
	 {
		 _readLock.lock();
		 try
		 {
			 return super.forEachKey(procedure);
		 }
		 finally
		 {
			 _readLock.unlock();
		 }
	 }
	 
	 public boolean forEachValue(TObjectProcedure<V> arg0)
	 {
		 _readLock.lock();
		 try
		 {
			 return super.forEachValue(arg0);
		 }
		 finally
		 {
			 _readLock.unlock();
		 }
	 }
	 
	 public boolean forEachEntry(TIntObjectProcedure<V> arg0)
	 {
		 _readLock.lock();
		 try
		 {
			 return super.forEachEntry(arg0);
		 }
		 finally
		 {
			 _readLock.unlock();
		 }
	 }
	 
	 public boolean retainEntries(TIntObjectProcedure<V> arg0)
	 {
		 _writeLock.lock();
		 try
		 {
			 return super.retainEntries(arg0);
		 }
		 finally
		 {
			 _writeLock.unlock();
		 }
	 }
	 
	 public void transformValues(TObjectFunction<V,V> arg0)
	 {
		 _writeLock.lock();
		 try
		 {
			 super.transformValues(arg0);
		 }
		 finally
		 {
			 _writeLock.unlock();
		 }
	 }
}
