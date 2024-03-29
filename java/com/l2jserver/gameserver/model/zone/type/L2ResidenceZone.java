/*
 * Copyright (C) 2004-2014 L2J Server
 * 
 * This file is part of L2J Server.
 * 
 * L2J Server is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * L2J Server is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.l2jserver.gameserver.model.zone.type;

import com.l2jserver.gameserver.model.TeleportWhereType;
import com.l2jserver.gameserver.model.actor.instance.L2PcInstance;
import com.l2jserver.gameserver.model.zone.L2ZoneRespawn;

/**
 * @author xban1x
 */
public abstract class L2ResidenceZone extends L2ZoneRespawn
{
	private int _residenceId;
	
	protected L2ResidenceZone(int id)
	{
		super(id);
	}
	
	protected void banishForeigners(int owningClanId, TeleportWhereType type)
	{
		for (L2PcInstance temp : getPlayersInside())
		{
			if ((temp.getClanId() == owningClanId) && (owningClanId != 0))
			{
				continue;
			}
			temp.teleToLocation(type);
		}
	}
	
	protected void setResidenceId(int residenceId)
	{
		_residenceId = residenceId;
	}
	
	public int getResidenceId()
	{
		return _residenceId;
	}
}
