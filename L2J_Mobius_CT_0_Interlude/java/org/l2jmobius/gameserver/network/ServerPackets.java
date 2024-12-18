/*
 * Copyright (c) 2013 L2jMobius
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR
 * IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package org.l2jmobius.gameserver.network;

import org.l2jmobius.Config;
import org.l2jmobius.commons.network.WritableBuffer;
import org.l2jmobius.gameserver.network.serverpackets.ServerPacket;

/**
 * @author Mobius
 */
public enum ServerPackets
{
	KEY_PACKET(0x00),
	CHAR_MOVE_TO_LOCATION(0x01),
	NPC_SAY(0x02),
	CHAR_INFO(0x03),
	USER_INFO(0x04),
	ATTACK(0x05),
	DIE(0x06),
	REVIVE(0x07),
	SPAWN_ITEM(0x0B),
	DROP_ITEM(0x0C),
	GET_ITEM(0x0D),
	STATUS_UPDATE(0x0E),
	NPC_HTML_MESSAGE(0x0F),
	SELL_LIST(0x10),
	BUY_LIST(0x11),
	DELETE_OBJECT(0x12),
	CHAR_SELECT_INFO(0x13),
	LOGIN_FAIL(0x14),
	CHAR_SELECTED(0x15),
	NPC_INFO(0x16),
	CHAR_TEMPLATES(0x17),
	CHAR_CREATE_OK(0x19),
	CHAR_CREATE_FAIL(0x1A),
	ITEM_LIST(0x1B),
	SUNRISE(0x1C),
	SUNSET(0x1D),
	TRADE_START(0x1E),
	TRADE_OWN_ADD(0x20),
	TRADE_OTHER_ADD(0x21),
	TRADE_DONE(0x22),
	CHAR_DELETE_OK(0x23),
	CHAR_DELETE_FAIL(0x24),
	ACTION_FAIL(0x25),
	SERVER_CLOSE(0x26),
	INVENTORY_UPDATE(0x27),
	TELEPORT_TO_LOCATION(0x28),
	TARGET_SELECTED(0x29),
	TARGET_UNSELECTED(0x2A),
	AUTO_ATTACK_START(0x2B),
	AUTO_ATTACK_STOP(0x2C),
	SOCIAL_ACTION(0x2D),
	CHANGE_MOVE_TYPE(0x2E),
	CHANGE_WAIT_TYPE(0x2F),
	MANAGE_PLEDGE_POWER(0x30),
	ASK_JOIN_PLEDGE(0x32),
	JOIN_PLEDGE(0x33),
	ASK_JOIN_PARTY(0x39),
	JOIN_PARTY(0x3A),
	WAREHOUSE_DEPOSIT_LIST(0x41),
	WAREHOUSE_WITHDRAW_LIST(0x42),
	SHORT_CUT_REGISTER(0x44),
	SHORT_CUT_INIT(0x45),
	STOP_MOVE(0x47),
	MAGIC_SKILL_USE(0x48),
	MAGIC_SKILL_CANCELD(0x49),
	CREATURE_SAY(0x4A),
	EQUIP_UPDATE(0x4B),
	DOOR_INFO(0x4C),
	DOOR_STATUS_UPDATE(0x4D),
	PARTY_SMALL_WINDOW_ALL(0x4E),
	PARTY_SMALL_WINDOW_ADD(0x4F),
	PARTY_SMALL_WINDOW_DELETE_ALL(0x50),
	PARTY_SMALL_WINDOW_DELETE(0x51),
	PARTY_SMALL_WINDOW_UPDATE(0x52),
	PLEDGE_SHOW_MEMBER_LIST_ALL(0x53),
	PLEDGE_SHOW_MEMBER_LIST_UPDATE(0x54),
	PLEDGE_SHOW_MEMBER_LIST_ADD(0x55),
	PLEDGE_SHOW_MEMBER_LIST_DELETE(0x56),
	SKILL_LIST(0x58),
	VEHICLE_INFO(0x59),
	VEHICLE_DEPARTURE(0x5A),
	VEHICLE_CHECK_LOCATION(0x5B),
	GET_ON_VEHICLE(0x5C),
	GET_OFF_VEHICLE(0x5D),
	SEND_TRADE_REQUEST(0x5E),
	RESTART_RESPONSE(0x5F),
	MOVE_TO_PAWN(0x60),
	VALIDATE_LOCATION(0x61),
	BEGIN_ROTATION(0x62),
	STOP_ROTATION(0x63),
	SYSTEM_MESSAGE(0x64),
	START_PLEDGE_WAR(0x65),
	STOP_PLEDGE_WAR(0x67),
	SURRENDER_PLEDGE_WAR(0x69),
	PLEDGE_CREST(0x6C),
	SETUP_GAUGE(0x6D),
	SHOW_BOARD(0x6E),
	CHOOSE_INVENTORY_ITEM(0x6F),
	MOVE_TO_LOCATION_IN_VEHICLE(0x71),
	STOP_MOVE_IN_VEHICLE(0x72),
	VALIDATE_LOCATION_IN_VEHICLE(0x73),
	TRADE_UPDATE(0x74),
	TRADE_PRESS_OWN_OK(0x75),
	MAGIC_SKILL_LAUNCHED(0x76),
	TRADE_PRESS_OTHER_OK(0x7C),
	ASK_JOIN_FRIEND(0x7D),
	LEAVE_WORLD(0x7E),
	ABNORMAL_STATUS_UPDATE(0x7F),
	QUEST_LIST(0x80),
	ENCHANT_RESULT(0x81),
	PLEDGE_SHOW_MEMBER_LIST_DELETE_ALL(0x82),
	PLEDGE_INFO(0x83),
	RIDE(0x86),
	PLEDGE_SHOW_INFO_UPDATE(0x88),
	ACQUIRE_SKILL_LIST(0x8A),
	ACQUIRE_SKILL_INFO(0x8B),
	SERVER_OBJECT_INFO(0x8C),
	ACQUIRE_SKILL_DONE(0x8E),
	GM_VIEW_CHARACTER_INFO(0x8F),
	GM_VIEW_PLEDGE_INFO(0x90),
	GM_VIEW_SKILL_INFO(0x91),
	GM_VIEW_QUEST_LIST(0x93),
	GM_VIEW_ITEM_LIST(0x94),
	GM_VIEW_WAREHOUSE_WITHDRAW_LIST(0x95),
	PARTY_MATCH_LIST(0x96),
	PARTY_MATCH_DETAIL(0x97),
	PLAY_SOUND(0x98),
	STATIC_OBJECT(0x99),
	PRIVATE_STORE_MANAGE_LIST_SELL(0x9A),
	PRIVATE_STORE_LIST_SELL(0x9B),
	PRIVATE_STORE_MSG_SELL(0x9C),
	SHOW_MINI_MAP(0x9D),
	TUTORIAL_SHOW_HTML(0xA0),
	TUTORIAL_SHOW_QUESTION_MARK(0xA1),
	TUTORIAL_ENABLE_CLIENT_EVENT(0xA2),
	TUTORIAL_CLOSE_HTML(0xA3),
	MY_TARGET_SELECTED(0xA6),
	PARTY_MEMBER_POSITION(0xA7),
	ASK_JOIN_ALLIANCE(0xA8),
	ALLIANCE_CREST(0xAE),
	PET_STATUS_SHOW(0xB0),
	PET_INFO(0xB1),
	PET_ITEM_LIST(0xB2),
	PET_INVENTORY_UPDATE(0xB3),
	ALLIANCE_INFO(0xB4),
	PET_STATUS_UPDATE(0xB5),
	PET_DELETE(0xB6),
	PRIVATE_STORE_BUY_MANAGE_LIST(0xB7),
	PRIVATE_STORE_BUY_LIST(0xB8),
	PRIVATE_STORE_BUY_MSG(0xB9),
	VEHICLE_START(0xC0),
	SKILL_COOL_TIME(0xC1),
	PACKAGE_TO_LIST(0xC2),
	PACKAGE_SENDABLE_LIST(0xC3),
	EARTHQUAKE(0xC4),
	SPECIAL_CAMERA(0xC7),
	NORMAL_CAMERA(0xC8),
	SIEGE_INFO(0xC9),
	SIEGE_ATTACKER_LIST(0xCA),
	SIEGE_DEFENDER_LIST(0xCB),
	NICK_NAME_CHANGED(0xCC),
	PLEDGE_STATUS_CHANGED(0xCD),
	RELATION_CHANGED(0xCE),
	EVENT_TRIGGER(0xCF),
	MULTI_SELL_LIST(0xD0),
	SET_SUMMON_REMAIN_TIME(0xD1),
	NET_PING(0xD3),
	DICE(0xD4),
	SNOOP(0xD5),
	RECIPE_BOOK_ITEM_LIST(0xD6),
	RECIPE_ITEM_MAKE_INFO(0xD7),
	RECIPE_SHOP_MANAGE_LIST(0xD8),
	RECIPE_SHOP_SELL_LIST(0xD9),
	RECIPE_SHOP_ITEM_INFO(0xDA),
	RECIPE_SHOP_MSG(0xDB),
	SHOW_CALCULATOR(0xDC),
	MON_RACE_INFO(0xDD),
	SHOW_TOWN_MAP(0xDE),
	OBSERVATION_MODE(0xDF),
	OBSERVATION_RETURN(0xE0),
	CHAIR_SIT(0xE1),
	HENNA_EQUIP_LIST(0xE2),
	HENNA_ITEM_INFO(0xE3),
	HENNA_INFO(0xE4),
	HENNA_REMOVE_LIST(0xE5),
	HENNA_ITEM_REMOVE_INFO(0xE6),
	SEND_MACRO_LIST(0xE7),
	BUY_LIST_SEED(0xE8),
	SELL_LIST_PROCURE(0xE9),
	GM_VIEW_HENNA_INFO(0xEA),
	RADAR_CONTROL(0xEB),
	CLIENT_SET_TIME(0xEC),
	CONFIRM_DLG(0xED),
	PARTY_SPELLED(0xEE),
	SHOP_PREVIEW_LIST(0xEF),
	SHOP_PREVIEW_INFO(0xF0),
	CAMERA_MODE(0xF1),
	SHOW_XMAS_SEAL(0xF2),
	ETC_STATUS_UPDATE(0xF3),
	SHORT_BUFF_STATUS_UPDATE(0xF4),
	SSQ_STATUS(0xF5),
	AGIT_DECO_INFO(0xF7),
	SIGNS_SKY(0xF8),
	GAME_GUARD_QUERY(0xF9),
	FRIEND_LIST(0xFA),
	L2_FRIEND(0xFB),
	FRIEND_STATUS(0xFC),
	FRIEND_RECV_MSG(0xFD),
	// ExPackets
	EX_COLOSSEUM_FENCE_INFO(0xFE, 0x09),
	EX_PARTY_ROOM_MEMBER(0xFE, 0x0E),
	EX_CLOSE_PARTY_ROOM(0xFE, 0x0F),
	EX_MANAGE_PARTY_ROOM_MEMBER(0xFE, 0x10),
	EX_AUTO_SOUL_SHOT(0xFE, 0x12),
	EX_FISHING_START(0xFE, 0x13),
	EX_FISHING_END(0xFE, 0x14),
	EX_FISHING_START_COMBAT(0xFE, 0x15),
	EX_FISHING_HP_REGEN(0xFE, 0x16),
	EX_ENCHANT_SKILL_LIST(0xFE, 0x17),
	EX_ENCHANT_SKILL_INFO(0xFE, 0x18),
	EX_QUEST_INFO(0xFE, 0x19),
	EX_SHOW_QUEST_MARK(0xFE, 0x1A),
	EX_SEND_MANOR_LIST(0xFE, 0x1B),
	EX_SHOW_SEED_INFO(0xFE, 0x1C),
	EX_SHOW_CROP_INFO(0xFE, 0x1D),
	EX_SHOW_MANOR_DEFAULT_INFO(0xFE, 0x1E),
	EX_SHOW_SEED_SETTING(0xFE, 0x1F),
	EX_SHOW_CROP_SETTING(0xFE, 0x20),
	EX_SHOW_SELL_CROP_LIST(0xFE, 0x21),
	EX_SHOW_PROCURE_CROP_DETAIL(0xFE, 0x22),
	EX_HERO_LIST(0xFE, 0x23),
	EX_SERVER_PRIMITIVE(0xFE, 0x24),
	EX_OPEN_MPCC(0xFE, 0x25),
	EX_CLOSE_MPCC(0xFE, 0x26),
	EX_ASK_JOIN_MPCC(0xFE, 0x27),
	EX_PLEDGE_EMBLEM(0xFE, 0x28),
	EX_OLYMPIAD_USER_INFO(0xFE, 0x29),
	EX_OLYMPIAD_SPELLED_INFO(0xFE, 0x2A),
	EX_OLYMPIAD_MODE(0xFE, 0x2B),
	EX_OLYMPIAD_MATCH_END(0xFE, 0x2C),
	EX_MAIL_ARRIVED(0xFE, 0x2D),
	EX_STORAGE_MAX_COUNT(0xFE, 0x2E),
	EX_MULTI_PARTY_COMMAND_CHANNEL_INFO(0xFE, 0x30),
	EX_PC_CAFE_POINT_INFO(0xFE, 0x31),
	EX_SET_COMPASS_ZONE_CODE(0xFE, 0x32),
	EX_GET_BOSS_RECORD(0xFE, 0x33),
	EX_ASK_JOIN_PARTY_ROOM(0xFE, 0x34),
	EX_LIST_PARTY_MATCHING_WAITING_ROOM(0xFE, 0x35),
	EX_SHOW_ADVENTURER_GUIDE_BOOK(0xFE, 0x37),
	EX_SHOW_SCREEN_MESSAGE(0xFE, 0x38),
	PLEDGE_SKILL_LIST(0xFE, 0x39),
	PLEDGE_SKILL_LIST_ADD(0xFE, 0x3A),
	PLEDGE_POWER_GRADE_LIST(0xFE, 0x3B),
	PLEDGE_RECEIVE_POWER_INFO(0xFE, 0x3C),
	PLEDGE_RECEIVE_MEMBER_INFO(0xFE, 0x3D),
	PLEDGE_RECEIVE_WAR_LIST(0xFE, 0x3E),
	PLEDGE_RECEIVE_SUB_PLEDGE_CREATED(0xFE, 0x3F),
	EX_RED_SKY(0xFE, 0x40),
	SHOW_PC_CAFE_COUPON_SHOW_UI(0xFE, 0x43),
	EX_SEARCH_ORC(0xFE, 0x44),
	EX_CURSED_WEAPON_LIST(0xFE, 0x45),
	EX_CURSED_WEAPON_LOCATION(0xFE, 0x46),
	EX_RESTART_CLIENT(0xFE, 0x47),
	EX_REQUEST_HACK_SHIELD(0xFE, 0x48),
	EX_USE_SHARED_GROUP_ITEM(0xFE, 0x49),
	EX_MPCC_SHOW_PARTY_MEMBER_INFO(0xFE, 0x4A),
	EX_DUEL_ASK_START(0xFE, 0x4B),
	EX_DUEL_READY(0xFE, 0x4C),
	EX_DUEL_START(0xFE, 0x4D),
	EX_DUEL_END(0xFE, 0x4E),
	EX_DUEL_UPDATE_USER_INFO(0xFE, 0x4F),
	EX_SHOW_VARIATION_MAKE_WINDOW(0xFE, 0x50),
	EX_SHOW_VARIATION_CANCEL_WINDOW(0xFE, 0x51),
	EX_PUT_ITEM_RESULT_FOR_VARIATION_MAKE(0xFE, 0x52),
	EX_PUT_INTENSIVE_RESULT_FOR_VARIATION_MAKE(0xFE, 0x53),
	EX_PUT_COMMISSION_RESULT_FOR_VARIATION_MAKE(0xFE, 0x54),
	EX_VARIATION_RESULT(0xFE, 0x55),
	EX_PUT_ITEM_RESULT_FOR_VARIATION_CANCEL(0xFE, 0x56),
	EX_VARIATION_CANCEL_RESULT(0xFE, 0x57),
	EX_SHOW_SLIDESHOW_KAMAEL(0xFE, 0x5B);
	
	private final int _id1;
	private final int _id2;
	
	ServerPackets(int id1)
	{
		this(id1, -1);
	}
	
	ServerPackets(int id1, int id2)
	{
		_id1 = id1;
		_id2 = id2;
	}
	
	public void writeId(ServerPacket packet, WritableBuffer buffer)
	{
		if (Config.DEBUG_SERVER_PACKETS)
		{
			final String name = packet.getClass().getSimpleName();
			if (!Config.ALT_DEV_EXCLUDED_PACKETS.contains(name))
			{
				PacketLogger.info((_id2 > 0 ? "[S EX] " : "[S] ") + name);
			}
		}
		
		buffer.writeByte(_id1);
		if (_id2 > 0)
		{
			buffer.writeShort(_id2);
		}
	}
}
