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
package quests.Q00370_AnElderSowsSeeds;

import java.util.HashMap;
import java.util.Map;

import org.l2jmobius.gameserver.model.actor.Npc;
import org.l2jmobius.gameserver.model.actor.Player;
import org.l2jmobius.gameserver.model.quest.Quest;
import org.l2jmobius.gameserver.model.quest.QuestState;
import org.l2jmobius.gameserver.model.quest.State;

public class Q00370_AnElderSowsSeeds extends Quest
{
	// NPC
	private static final int CASIAN = 30612;
	// Items
	private static final int SPELLBOOK_PAGE = 5916;
	private static final int CHAPTER_OF_FIRE = 5917;
	private static final int CHAPTER_OF_WATER = 5918;
	private static final int CHAPTER_OF_WIND = 5919;
	private static final int CHAPTER_OF_EARTH = 5920;
	// Drop chances
	private static final Map<Integer, Integer> MOBS1 = new HashMap<>();
	private static final Map<Integer, Double> MOBS2 = new HashMap<>();
	static
	{
		MOBS1.put(20082, 9); // ant_recruit
		MOBS1.put(20086, 9); // ant_guard
		MOBS1.put(20090, 22); // noble_ant_leader
		MOBS2.put(20084, 0.101); // ant_patrol
		MOBS2.put(20089, 0.100); // noble_ant
	}
	
	public Q00370_AnElderSowsSeeds()
	{
		super(370);
		registerQuestItems(SPELLBOOK_PAGE, CHAPTER_OF_FIRE, CHAPTER_OF_WATER, CHAPTER_OF_WIND, CHAPTER_OF_EARTH);
		addStartNpc(CASIAN);
		addTalkId(CASIAN);
		addKillId(20082, 20084, 20086, 20089, 20090);
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
		
		switch (event)
		{
			case "30612-3.htm":
			{
				st.startQuest();
				break;
			}
			case "30612-6.htm":
			{
				if (hasQuestItems(player, CHAPTER_OF_FIRE, CHAPTER_OF_WATER, CHAPTER_OF_WIND, CHAPTER_OF_EARTH))
				{
					htmltext = "30612-8.htm";
					takeItems(player, CHAPTER_OF_FIRE, 1);
					takeItems(player, CHAPTER_OF_WATER, 1);
					takeItems(player, CHAPTER_OF_WIND, 1);
					takeItems(player, CHAPTER_OF_EARTH, 1);
					giveAdena(player, 3600, true);
				}
				break;
			}
			case "30612-9.htm":
			{
				st.exitQuest(true, true);
				break;
			}
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
				htmltext = (player.getLevel() < 28) ? "30612-0a.htm" : "30612-0.htm";
				break;
			}
			case State.STARTED:
			{
				htmltext = "30612-4.htm";
				break;
			}
		}
		
		return htmltext;
	}
	
	@Override
	public String onKill(Npc npc, Player player, boolean isSummon)
	{
		final QuestState qs = getRandomPartyMemberState(player, -1, 3, npc);
		if (qs != null)
		{
			final int npcId = npc.getId();
			if (MOBS1.containsKey(npcId))
			{
				if (getRandom(100) < MOBS1.get(npcId))
				{
					final Player luckyPlayer = getRandomPartyMember(player, npc);
					if (luckyPlayer != null)
					{
						giveItemRandomly(luckyPlayer, npc, SPELLBOOK_PAGE, 1, 0, 1, true);
					}
				}
			}
			else
			{
				giveItemRandomly(qs.getPlayer(), npc, SPELLBOOK_PAGE, 1, 0, MOBS2.get(npcId), true);
			}
		}
		
		return super.onKill(npc, player, isSummon);
	}
}
