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
package com.watabou.pixeldungeon.scenes;

import com.watabou.noosa.Game;
import com.watabou.pixeldungeon.windows.WndStory;

public class IntroScene extends PixelScene {

	private static final String TEXT = 	
		"Many heroes of all kinds, types, genders, sub-genders, and 2017 cross-sub-genders, have ventured into the Dungeon before you. Some of them have returned with treasures and magical " +
		"artifacts. Others have returned looking dreadfully ashamed, and sore in places they didn't even know they HAD places; fractured, but whole....... Most have simply never been heard " +
		"of since. \n\n" +
		"But none have succeeded in retrieving the Great Stone of Nordiarch, " +
		"which is told to be hidden in the depths of the Dungeon, guarded by something or someone, not yet known to man or beast (or to the above noted gender classes.)\n\n" +
		"" +
		"You consider yourself ready for the challenge, but most importantly, you feel that fortune smiles on you. " +
		"It's time to start your own adventure!";
	
	@Override
	public void create() {
		super.create();
		
		add( new WndStory( TEXT ) {
			@Override
			public void hide() {
				super.hide();
				Game.switchScene( InterlevelScene.class );
			}
		} );
		
		fadeIn();
	}
}
