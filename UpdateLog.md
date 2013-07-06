Version History
==============

Below is a listing of all updates to Tadukoo Plugin, from newest to oldest.

Alpha 0.0.9.4
----------
* Each player is sent a message when joining the server.

Alpha 0.0.9.3
----------
* Added /fly
    * Sets flight on or off for a player.

Alpha 0.0.9.2
----------
* Added /adventure.
    * Also alias /gma.
	* Sets a player's gamemode to adventure.
* Added /creative.
    * Also alias /gmc.
	* Sets a player's gamemode to creative.
* Added /survival.
    * Also alias /gms.
	* Sets a player's gamemode to survival.

Alpha 0.0.9.1
----------
* Added a, c, and s as possible parameters in /gamemode.

Alpha 0.0.9.0
----------
* Added /gamemode.
    * Also alias /gm.
	* Also alias /gmt.

Alpha 0.0.8.9
----------
* Renamed tadukoopluginmain to Main.
* Renamed MyBlockListener to BlockListener.
* Renamed MyPlayerListener to PlayerListener.
* Renamed TadukooPluginCommandExecutor to MainCommandExecutor.
* Basically the classes have more logical names; there is no known performance change).

Alpha 0.0.8.8
----------
* Bug Fix:
    * Console would get the usage message after typing certain commands correctly.
	    * Messages are gone now.

Alpha 0.0.8.7
----------
* Bug Fix:
    * Console can't use commands.
	    * Now certain commands can be used through the console.
* KNOWN BUG:
    * Console would get the usage message after typing certain commands correctly.

Alpha 0.0.8.6
----------
* Bug Fixes:
    * Console can't use commands.
	    * Still broken, but attempted fix.
	* /suicide doesn't work correctly.
	    * Now /suicide does work correctly.
* KNOWN BUG:
    * Console can't use commands.

Alpha 0.0.8.5
----------
* Added /ping
    * Says "Pong!" to the user, if the user is a player.
* Removed /basic.
* Removed /basic2.
* KNOWN BUGS:
    * Console can't use commands.
	* /suicide doesn't work correctly.

Alpha 0.0.8.4
----------
* Added /suicide.
* Added /thelp.
    * Shows help for Tadukoo Plugin commands.

Alpha 0.0.8.3
----------
* Added /feed.
* Added /starve.
* Bug Fix:
    * /flip doesn't work.
	    * Removed /flip.

Alpha 0.0.8.2
----------
* Added /flip.
    * Flips a coin.
* KNOWN BUG:
    * /flip doesn't work.

Alpha 0.0.8.1
----------
* If you type heal in chat, you will be healed.
* If you type kill in chat, you will die.

Alpha 0.0.8.0
----------
* Now TNT and Bedrock disappear when placed.
    * The player will say through the chat "I just placed < TNT/BEDROCK >!"

Alpha 0.0.7.8
----------
* Bug Fixes:
    * Typing a correct command sometimes shows the command usage.
	    * No longer shows.
	* If a player is offline, it won't show the error message.
	    * Error message is now displayed.

Alpha 0.0.7.7
----------
* Bug Fix:
    * Commands don't work.
	    * Fixed mistake with commands.
        * I had used the command type instead of the string type, so it didn't know what I meant.
* KNOWN BUGS:
    * Typing a correct command sometimes shows the command usage.
	* If a player is offline, it won't show the error message.

Alpha 0.0.7.6
----------
* Unknown
* KNOWN BUG:
    * Commands don't work.

Alpha 0.0.7.5
----------
* Bug Fix:
    * Commands don't work.
	    * Apparently I was using the string instead of the command itself?
		* Nope, didn't fix it.
* KNOWN BUGS:
    * Commands don't work.

Alpha 0.0.7.4
----------
* Bug Fix:
    * Commands don't work.
	    * Fix didn't work.
* KNOWN BUG:
    * Commands don't work.

Alpha 0.0.7.3.1
----------
* Fixed a simple mistake in the plugin.yml.
* Update Number Note:
    * No version after this one will have a fifth decimal place.
* KNOWN BUG:
    * Commands don't work.

Alpha 0.0.7.3
----------
* Added /kill and permissions and usage for it.
* Update Number Note:
    * After this usage and permissions only count for the number if it wasn't included immediately.

Alpha 0.0.7.1
----------
* Added permissions and usage for /heal and /tport.

Alpha 0.0.7
----------
* Re-added /heal.
    * This time the alias /h isn't included.

Alpha 0.0.6.1
----------
* /tport moved to CommandExecutor file.
    * It was in the main file.

Alpha 0.0.6
----------
* /heal Removed.
* /tport Added.
    * Teleports a player to another player.
* Bug Fix:
    * /h doesn't work.
	    * /h Removed.

Alpha 0.0.5.4
----------
* Bug Fix:
    * /heal will send "You have been healed by CraftPlayer (name = nameOfPersonWhoHealedYou)".
	    * Now it will send "You have been healed!"

Alpha 0.0.5.3
----------
* Now /heal will send a message to the healed player saying "You have been healed by nameOfPersonWhoHealedYou!"
* KNOWN BUG:
    * /h doesn't work.
	* /heal will send "You have been healed by CraftPlayer (name = nameOfPersonWhoHealedYou)".

Alpha 0.0.5.2
----------
* Now /heal or /h will stop the player from burning as well.
* KNOWN BUG:
    * /h doesn't work.

Alpha 0.0.5.1
----------
* Added error message to commands if a player is offline.
* KNOWN BUG:
    * /h doesn't work.

Alpha 0.0.5
----------
* Removed /sendme command.
* Added /heal command
    * Heals a player.
	* Also added /h alias.
* KNOWN BUG:
    * /h doesn't work.

Alpha 0.0.4
----------
* Added /sendme command.
    * Sends "Sent" (in gold) to the player.

Alpha 0.0.3.7
----------
* Bug Fix:
    * Fixed permissions.
        * Permissions had < Plugin name > at the beginning in the commands section by mistake.

Alpha 0.0.3.6
----------
* Bug Fix:
    * Plugin now loads.
	    * The permission defaults were under the commands by mistake.
* KNOWN BUG:
    * Permissions don't work right.

Alpha 0.0.3.5
----------
* Added defaults for permissions of /basic and /basic2
    * /basic=true
	* /basic2=op
* KNOWN BUG: Plugin fails to load.

Alpha 0.0.3.4
----------
* Bug Fix:
    * /basic2 is fixed.

Alpha 0.0.3.3
----------
* Experimenting with different syntax for /basic2.
* KNOWN BUG: There are mistakes in /basic2.

Alpha 0.0.3.2
----------
* Bug Fix:
    * /basic2 is fixed.

Alpha 0.0.3.1
---------
* Tried to fix /basic2
* KNOWN BUG: /basic2 is not fixed.

Alpha 0.0.3
----------
* Moved commands to a separate class.
* KNOWN BUG: /basic2 doesn't work correctly.

Alpha 0.0.2
----------
* Command /basic2 Added
    * Does nothing, can only be used by a player.

Alpha 0.0.1
----------
* First version
* Command /basic Added 
    * Does nothing, can be used by console and player.