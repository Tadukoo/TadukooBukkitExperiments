Version History
==============

Below is a listing of all updates to Tadukoo Plugin.

Alpha
----------
0.0.1
* First version
* Command /basic Added 
    * Does nothing, can be used by console and player.
0.0.2 command added-basic2-does nothing, can only be used by a player.
0.0.3 Moved commands to separate class
0.0.3.1 Tried fixing basic2 (Failure)
0.0.3.2 Fixed basic2 (Forgot to put it in the main class file lol)
0.0.3.3 Experimenting with different syntax for basic2
0.0.3.4 Fixed mistakes with basic2
0.0.3.5 Added defaults for permissions of basic and basic2 (basic=true, basic2=op) (Plugin fails to load)
0.0.3.6 Fixed errors (Put defaults under commands instead of permissions lol)
0.0.3.7 Fixed permissions (permissions had <Plugin name> at the beginning in the commands section and didn't work right 

lol)
0.0.4 Added sendme command-sends "Sent" (in gold) to the player.
0.0.5 removed sendme command, added heal command (/heal or /h)-heals a player or another player.
0.0.5.1 Added message if player is offline.
0.0.5.2 Now /heal or /h will stop the player from burning as well.
0.0.5.3 Now /heal <player> will send a message to <player> saying "You have been healed by nameOfPersonWhoHealedYou!"
0.0.5.4 Now /heal <player> will send "You have been healed!" (the previous version sent "You have been healed by 

CraftPlayer (name=nameOfPersonWhoHealedYou)", so lol
0.0.6 /heal removed, /tport added (teleports a player to another player)
0.0.6.1 /tport moved to CommandExecutor file
0.0.7 Re-added /heal
0.0.7.1 Added permissions and usage for /heal and /tport
0.0.7.3 Added /kill and permissions and usage for it (After this usage and permissions only count for the number if it 

wasn't included immediately.)
0.0.7.3.1 Fixed a simple mistake in the plugin.yml
0.0.7.4 Fixed mistake with commands? (No longer using a 5th decimal place lol)
0.0.7.5 Fixed mistake with commands? <codingspeak>Apparently I was using the string instead of the command itself?

</codingspeak>
0.0.7.6 ?
0.0.7.7 Fixed mistake with commands? <codingspeak>I used the command type instead of the string type, so it didn't know 

what I meant</codingspeak>
0.0.7.8 Fixed a few problems? Tried fixing the usage messages and the commands not showing offline player messages. 

(Confirmed Fixed)
0.0.8.0 Added blocking TNT and Bedrock from being placed.
0.0.8.1 Addded healing and killing by typing heal and kill in normal chat, respectively
0.0.8.2 Added /flip (flips a coin)
0.0.8.3 Removed /flip and added /feed and /starve
0.0.8.4 Added /suicide and /thelp-shows Tadukoo Plugin help.
0.0.8.5 Removed /basic and /basic2 and added /ping-says pong! (only if a player).
0.0.8.6 Now the console can use commands? (Nope, still broken) Also /suicide is fixed.
0.0.8.7 Now the console can use certain commands.
0.0.8.8 Fixed a bug where the console got a message after typing correct commands.
0.0.8.9 Renamed tadukoopluginmain to Main, MyBlockListener to BlockListener, MyPlayerListener to PlayerListener, and 

TadukooPluginCommandExecutor to MainCommandExecutor. (Basically just more logical names for each class, no known 

performance change).
0.0.9.0 Added /gamemode, /gm, and /gmt
0.0.9.1 Now you can use a, c, and s for adventure, creative, and survival
0.0.9.2 Added /adventure, /creative, /survival, /gma, /gmc, and /gms
0.0.9.3 Added /fly
0.0.9.4 Player is sent a join message when joining.