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
package quests.Q00652_AnAgedExAdventurer;

import org.l2jmobius.gameserver.ai.CtrlIntention;
import org.l2jmobius.gameserver.model.Location;
import org.l2jmobius.gameserver.model.actor.Npc;
import org.l2jmobius.gameserver.model.actor.Player;
import org.l2jmobius.gameserver.model.quest.Quest;
import org.l2jmobius.gameserver.model.quest.QuestState;
import org.l2jmobius.gameserver.model.quest.State;

public class Q00652_AnAgedExAdventurer extends Quest
{
	// NPCs
	private static final int TANTAN = 32012;
	private static final int SARA = 30180;
	// Item
	private static final int SOULSHOT_C = 1464;
	// Reward
	private static final int ENCHANT_ARMOR_D = 956;
	// Table of possible spawns
	private static final Location[] SPAWNS =
	{
		new Location(78355, -1325, -3659, 0),
		new Location(79890, -6132, -2922, 0),
		new Location(90012, -7217, -3085, 0),
		new Location(94500, -10129, -3290, 0),
		new Location(96534, -1237, -3677, 0)
	};
	// Current position
	private int _currentPosition = 0;
	
	public Q00652_AnAgedExAdventurer()
	{
		super(652);
		addStartNpc(TANTAN);
		addTalkId(TANTAN, SARA);
		addSpawn(TANTAN, 78355, -1325, -3659, 0, false, 0);
	}
	
	@Override
	public String onEvent(String event, Npc npc, Player player)
	{
		String htmltext = event;
		final QuestState st = getQuestState(player, false);
		if (st == null)
		{
			return htmltext;
		}
		
		if (event.equals("32012-02.htm"))
		{
			if (getQuestItemsCount(player, SOULSHOT_C) >= 100)
			{
				st.startQuest();
				takeItems(player, SOULSHOT_C, 100);
				npc.getAI().setIntention(CtrlIntention.AI_INTENTION_MOVE_TO, new Location(85326, 7869, -3620));
				startQuestTimer("apparition_npc", 6000, npc, player, false);
			}
			else
			{
				htmltext = "32012-02a.htm";
				st.exitQuest(true);
			}
		}
		else if (event.equals("apparition_npc"))
		{
			int chance = getRandom(5);
			
			// Loop to avoid to spawn to the same place.
			while (chance == _currentPosition)
			{
				chance = getRandom(5);
			}
			
			// Register new position.
			_currentPosition = chance;
			
			npc.deleteMe();
			addSpawn(TANTAN, SPAWNS[chance].getX(), SPAWNS[chance].getY(), SPAWNS[chance].getZ(), SPAWNS[chance].getHeading(), false, 0);
			return null;
		}
		
		return htmltext;
	}
	
	@Override
	public String onTalk(Npc npc, Player player)
	{
		String htmltext = getNoQuestMsg(player);
		final QuestState st = getQuestState(player, true);
		
		switch (st.getState())
		{
			case State.CREATED:
			{
				htmltext = (player.getLevel() < 46) ? "32012-00.htm" : "32012-01.htm";
				break;
			}
			case State.STARTED:
			{
				switch (npc.getId())
				{
					case SARA:
					{
						if (getRandom(100) < 50)
						{
							htmltext = "30180-01.htm";
							giveAdena(player, 5026, true);
							giveItems(player, ENCHANT_ARMOR_D, 1);
						}
						else
						{
							htmltext = "30180-02.htm";
							giveAdena(player, 10000, true);
						}
						st.exitQuest(true, true);
						break;
					}
					case TANTAN:
					{
						htmltext = "32012-04a.htm";
						break;
					}
				}
				break;
			}
		}
		
		return htmltext;
	}
}