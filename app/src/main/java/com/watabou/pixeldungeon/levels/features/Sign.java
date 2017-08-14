/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.watabou.pixeldungeon.levels.features;

import com.watabou.noosa.audio.Sample;
import com.watabou.pixeldungeon.Assets;
import com.watabou.pixeldungeon.Dungeon;
import com.watabou.pixeldungeon.effects.CellEmitter;
import com.watabou.pixeldungeon.effects.particles.ElmoParticle;
import com.watabou.pixeldungeon.levels.DeadEndLevel;
import com.watabou.pixeldungeon.levels.Terrain;
import com.watabou.pixeldungeon.scenes.GameScene;
import com.watabou.pixeldungeon.utils.GLog;
import com.watabou.pixeldungeon.windows.WndMessage;

public class Sign {

	private static final String TXT_DEAD_END = 
		"What are you doing here?!";
	
	private static final String[] TIPS = {
		//"Don't overestimate your strength, use weapons and armor you can handle.",

		"The villagers of Peterbrugh have grown increasingly anxious..\n" +
				"\n" +
				"The women and children have fled..\n" +
				"\n" +
				"The men have pretended to be women, and also fled..\n" +
				"\n" +
				"Even the King's brave knights have seemingly misplaced their dangly bits.\n" +
				"\n" +
				"There is something stirring from within the very bowels of The Dungeon... causing sickness, and pain..\n" +
				"\n" +
				"Life in Peterbrugh is threatened to be forever tainted (ha, taint) by this unseen presence.\n" +
				"\n" +
				"What they need is a hero.\n" +
				"\n" +
				"Could it be you?",

		"This dungeon becomes more and more puzzling...\n" +
				"\n" +
				"It now seems there is something living...no.. not simply living.. growing.. deep, deep inside its most inner belly.\n" +
				"\n" +
				"Many heroes before you, from far away lands, have been sent ahead and died attempting " +
				"to determine just what entity is wreaking havoc from below. \n" +
				"\n" +
				"Hmmm, what could it be, what could it be... \n" +
				"\n" +
				"OH, what in the bosom of Brunhild?!? It seems that it is an unborn child!! A fetus!! You, sir, nay, HERO(!!!) are soon to reach Level 3 Uncle!!! \n" +
				"\n" +
				"BY THE BARD'S BONES, BABY Z IS COMING SPRING OF 2018!!!\n" +
				"\n" +
				"HURRAH!!",

		//"Not all doors in the dungeon are visible at first sight. If you are stuck, search for hidden doors.",
		"Remember, that raising your strength is not the only way to access better equipment. You can go " +
			"the other way, lowering its strength requirement with Scrolls of Upgrade.",
		"You can spend your gold in shops on deeper levels of the dungeon. The first one is on the 6th level.",
			
		"Beware of Goo!",
		
		"Pixel-Mart - all you need for successful adventure!",
		"Identify your potions and scrolls as soon as possible. Don't put it off to the moment " +
			"when you actually need them.",
		"Being hungry doesn't hurt, but starving does hurt.",
		"Surprise attack has a better chance to hit. For example, you can ambush your enemy behind " +
			"a closed door when you know it is approaching.",
		
		"Don't let The Tengu out!",
		
		"Pixel-Mart. Spend money. Live longer.",
		"When you're attacked by several monsters at the same time, try to retreat behind a door.",
		"If you are burning, you can't put out the fire in the water while levitating.",
		"There is no sense in possessing more than one Ankh at the same time, because you will lose them upon resurrecting.",
		
		"DANGER! Heavy machinery can cause injury, loss of limbs or death!",
		
		"Pixel-Mart. A safer life in dungeon.",
		"When you upgrade an enchanted weapon, there is a chance to destroy that enchantment.",
		"Weapons and armors deteriorate faster than wands and rings, but there are more ways to fix them.",
		"The only way to obtain a Scroll of Wipe Out is to receive it as a gift from the dungeon spirits.",
		
		"No weapons allowed in the presence of His Majesty!",
		
		"Pixel-Mart. Special prices for demon hunters!"
	};
	
	private static final String TXT_BURN =
		"As you try to read the sign it bursts into greenish flames.";
	
	public static void read( int pos ) {
		
		if (Dungeon.level instanceof DeadEndLevel) {
			
			GameScene.show( new WndMessage( TXT_DEAD_END ) );
			
		} else {
			
			int index = Dungeon.depth - 1;
			
			if (index < TIPS.length) {
				GameScene.show( new WndMessage( TIPS[index] ) );
			} else {
				
				Dungeon.level.destroy( pos );
				GameScene.updateMap( pos );
				GameScene.discoverTile( pos, Terrain.SIGN );
				
				CellEmitter.get( pos ).burst( ElmoParticle.FACTORY, 6 );
				Sample.INSTANCE.play( Assets.SND_BURNING );
				
				GLog.w( TXT_BURN );
				
			}
		}
	}
}
