/*
 * This file is part of the L2J Mobius project.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.l2jmobius.gameserver.network.serverpackets;

import java.util.Collection;

import org.l2jmobius.commons.network.WritableBuffer;
import org.l2jmobius.gameserver.model.TradeItem;
import org.l2jmobius.gameserver.model.actor.Player;
import org.l2jmobius.gameserver.network.GameClient;
import org.l2jmobius.gameserver.network.ServerPackets;

public class PrivateStoreManageListSell extends ServerPacket
{
	private final int _objId;
	private final long _playerAdena;
	private final boolean _packageSale;
	private final Collection<TradeItem> _itemList;
	private final Collection<TradeItem> _sellList;
	
	public PrivateStoreManageListSell(Player player, boolean isPackageSale)
	{
		_objId = player.getObjectId();
		_playerAdena = player.getAdena();
		player.getSellList().updateItems();
		_packageSale = isPackageSale;
		_itemList = player.getInventory().getAvailableItems(player.getSellList());
		_sellList = player.getSellList().getItems();
	}
	
	@Override
	public void writeImpl(GameClient client, WritableBuffer buffer)
	{
		ServerPackets.PRIVATE_STORE_MANAGE_LIST_SELL.writeId(this, buffer);
		// section 1
		buffer.writeInt(_objId);
		buffer.writeInt(_packageSale); // Package sell
		buffer.writeInt((int) _playerAdena);
		// section2
		buffer.writeInt(_itemList.size()); // for potential sells
		for (TradeItem item : _itemList)
		{
			buffer.writeInt(item.getItem().getType2());
			buffer.writeInt(item.getObjectId());
			buffer.writeInt(item.getItem().getId());
			buffer.writeInt(item.getCount());
			buffer.writeShort(0);
			buffer.writeShort(item.getEnchant()); // enchant level
			buffer.writeShort(item.getCustomType2());
			buffer.writeInt(item.getItem().getBodyPart());
			buffer.writeInt(item.getPrice()); // store price
		}
		// section 3
		buffer.writeInt(_sellList.size()); // count for any items already added for sell
		for (TradeItem item : _sellList)
		{
			buffer.writeInt(item.getItem().getType2());
			buffer.writeInt(item.getObjectId());
			buffer.writeInt(item.getItem().getId());
			buffer.writeInt(item.getCount());
			buffer.writeShort(0);
			buffer.writeShort(item.getEnchant()); // enchant level
			buffer.writeShort(0);
			buffer.writeInt(item.getItem().getBodyPart());
			buffer.writeInt(item.getPrice()); // your price
			buffer.writeInt(item.getItem().getReferencePrice()); // store price
		}
	}
}
