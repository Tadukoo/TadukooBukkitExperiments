Tadukoo Plugin
==============

Tadukoo Plugin is a plugin currently in progress for Bukkit, it is being made
for Minecraft 1.6.1, and will include various commands, an economy, permissions,
and much more. Its purpose is as a plugin for [Tadukooverse] (http://tadukooverse.wikia.com).

Tadukoo Plugin is in very early stages of development, so there's not much in it yet, so there may be some 
features or commands that are just for testing at the moment. Also, Tadukoo Plugin is the working name.
It may be changed in the future.

Current Version: Alpha 0.1.0.7

Current Features
----------
* Mainly just commands right now.
* Typing "heal" will heal you.
* Typing "kill" will kill you.
* Typing "sendme" will send the message "Send You" to you.
* TNT and Bedrock disappear after being placed and you say "I just placed < TNT/BEDROCK >".
* Upon joining the player is sent the message "Hello playerName. Welcome to worldName. It is timeInWorld."
    * This is temporarily disabled
* You can customize the motd in the config.yml.
* You can turn /ping on and off in the config.yml.
* In chat, color codes are now available.

Planned Features/Updates
----------
There are so many that I'm not going to list them all yet since this plugin is in such an early stage, but below are a few:

(NOTE: All version numbers listed below are tentative and could change.)
* Alpha 0.1.X
	* Add /sun
	* Add /rain
	* Add /storm
* Alpha 0.2
    * Commands are configurable in the config.yml or a new commands.yml file.
* Alpha 0.2.1
    * /thelp search functionality.
    * /thelp updated to have all commands.
* Alpha 0.3
    * Set-up an economy system.
* Alpha 0.4
    * Set-up more teleportation stuff (Like warps).
* Alpha ?
    * Add permissions for certain command groups (ex. economy commands permission is Tadukooplugin.economy).

Commands
----------
Note: the commands on this page may not be up to date, for the current listing, please view the plugin.yml file.

Key:
  < required > [ optional ]

* /ping
    * Sends "Pong!" back to the sender.
* /tport [ player ] < player >
    * Teleports a player to another player.
* /heal [ player ]
    * Heals a player.
* /kill < player >
    * Kills a player.
* /feed [ player ]
    * Restores a player's hunger.
* /starve < player >
    * Starves a player.
* /suicide
    * Commit suicide.
* /gamemode, /gm, and /gmt [ player ] [ gamemode ]
    * Changes a player's gamemode.
* /gma and /adventure [ player ]
    * Sets a player to gamemode 2.
* /gmc and /creative [ player ]
    * Sets a player to gamemode 1.
* /gms and /survival [ player ]
    * Sets a player to gamemode 0.
* /fly [ player ]
    * Sets flight mode to true or false for a player.
* /killall
    * Kills all players on the server.
* /motd
    * Shows the motd (message of the day).
* /time < day/night >
    * Sets the time to day or night.
* /timer
    * Counts down from 3 and says "GO!".
* /day
    * Sets the time to day.
* /night
    * Sets the time to night.
* /thelp
    * Shows the Tadukoo Plugin help.

Permissions
----------
Will be listed later, they can be viewed in the plugin.yml file.

Known Issues
----------
None at the moment.

Recent Updates
----------
This is only the newest 5 updates, for a full listing of updates, check the wiki, specifically
 [this page] (http://tadukooverse.wikia.com/wiki/Tadukoo Plugin History).

Alpha 0.1.0.9
* Added /day
    * Sets the time to day.
* Added /night
    * Sets the time to night.
* /time day improved
    * Now sets the time to 0 instead of 12000.

Alpha 0.1.0.8
* Changed enabled and disabled messages a bit.

Alpha 0.1.0.7
* Re-disabled Player join motd.
* Added Color Codes.

Alpha 0.1.0.6
* Re-enabled Player join motd.

Alpha 0.1.0.5
* Added /timer
    * Counts down from 3, then says "GO!".

Wiki
----------
Information about Tadukoo Plugin can be found on tadukooverse.wikia.com, the main page for it is [here] (http://tadukooverse.wikia.com/wiki/Tadukoo Plugin).

Copyright
----------

Tadukoo Plugin is released under GNU's general public license (GPLv3), 
more information can be found [here](http://www.gnu.org/licenses/gpl.html).
