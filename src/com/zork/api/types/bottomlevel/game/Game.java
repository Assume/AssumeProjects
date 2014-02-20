package com.zork.api.types.bottomlevel.game;

import java.util.ArrayList;
import java.util.List;
import com.zork.api.types.bottomlevel.bag.Bag;
import com.zork.api.types.bottomlevel.doors.Door;
import com.zork.api.types.bottomlevel.doors.Ladder;
import com.zork.api.types.bottomlevel.items.Document;
import com.zork.api.types.bottomlevel.items.Knife;
import com.zork.api.types.bottomlevel.items.MagicalOrb;
import com.zork.api.types.bottomlevel.items.Abilities.Abilities;
import com.zork.api.types.bottomlevel.items.Abilities.BlowFireAbility;
import com.zork.api.types.bottomlevel.items.Abilities.OpenDoorsAbility;
import com.zork.api.types.bottomlevel.items.Abilities.SuperhumanStrength;
import com.zork.api.types.bottomlevel.items.food.Apple;
import com.zork.api.types.bottomlevel.items.food.Bread;
import com.zork.api.types.bottomlevel.items.food.Cheese;
import com.zork.api.types.bottomlevel.items.weapon.Sword;
import com.zork.api.types.bottomlevel.items.weapon.Torch;
import com.zork.api.types.bottomlevel.npcs.fightable.Bees;
import com.zork.api.types.bottomlevel.npcs.fightable.DrMcCarthy;
import com.zork.api.types.bottomlevel.npcs.fightable.EvilBirdMan;
import com.zork.api.types.bottomlevel.npcs.fightable.EvilSpirit;
import com.zork.api.types.bottomlevel.npcs.fightable.Goblin;
import com.zork.api.types.bottomlevel.npcs.fightable.Gremlin;
import com.zork.api.types.bottomlevel.npcs.fightable.Grue;
import com.zork.api.types.bottomlevel.npcs.fightable.Klingon;
import com.zork.api.types.bottomlevel.npcs.fightable.LandShark;
import com.zork.api.types.bottomlevel.npcs.fightable.Ogre;
import com.zork.api.types.bottomlevel.npcs.fightable.Orc;
import com.zork.api.types.bottomlevel.npcs.fightable.Spiders;
import com.zork.api.types.bottomlevel.npcs.fightable.WaterToad;
import com.zork.api.types.bottomlevel.rooms.Room;
import com.zork.api.types.bottomlevel.rooms.TradingRoom;
import com.zork.api.types.bottomlevel.user.Player;
import com.zork.api.types.command.Command;
import com.zork.api.types.command.Parser;
import com.zork.api.types.npcs.NPC;
import com.zork.api.types.toplevel.items.Item;

public class Game
{

    private static Game game = null;

    private static Room initialRoom;

    private Parser parser;

    private boolean notStillAlive = false;

    private NPC boss;

    private boolean bossStillAlive = true;

    public static Game getGame()
    {
	return game == null ? (game = new Game()) : game;
    }

    Player player;

    private boolean finished;

    private Game()
    {
	this(new Player());
	this.createRooms();
	this.parser = new Parser();
	this.finished = false;
    }

    private void createRooms()
    {
	Room bedroom = new Room(
		"The sun shines through the paneled windows, and you are awoken by a strange, ethereal sound. \nYou feel a sudden urge to explore.");
	Room outside = new Room(
		"You go outside into a dense, lush and green forest. Disorientated and confused, you wildly look around and try to spot a path through the trees.\nLuckily, you spot a treehouse (with a ladder) to the east and a warehouse to the north.");
	Room treehouse = new Room(
		"You enter the treehouse. Built of glorious mahogany wood and cherry oak, the treehouse stands as a testament to this country's magnificent woodworking.");
	Room outside1 = new Room(
		"Once again, the overwhelmingly green flora of the great outdoors confronts you as you converge upon the undergrowth.");
	Room outside2 = new Room(
		"With a cry of exasperation, you are met with the sight of yet more trees. You wonder if the world consists only of giant elm trees and thickly spreading vines.");
	Room outside3 = new Room(
		"As you forge for the umpteenth time onto a vast green canvas, you begin to wonder if this is all that awaits you. Just in time to salvage your sanity, however, you spot a crystal lake to the north.");
	Room outside4 = new Room(
		"\"Maybe\", you think as you bump into another tree, \"I could just live among the trees as one of them...\" Eventually your eyes set sights on a muddy swamp to the north.");
	Room outside5 = new Room(
		"You enter yet another green field; traversing the green greenery yields an innocuous swamp to the north.");
	Room abandonedWarehouse = new Room(
		"You carefully step foot into the creaking warehouse. You struggle to see in the dimly lit room.");
	Room outside6 = new Room(
		"You fall upon nature's domain. A warehouse lies east and a forest lies ahead.");
	Room forest = new Room(
		"Another lush forest meets you. Ahead of you lies a moldy, cavernous cave.");
	Room warehouseKitchen = new Room(
		"You stumble into the kitchen. Hurrah (food)!");
	Room swamp = new Room(
		"You walk forward and are startled by a magnificent swampy underground lair.");
	Room marsh = new Room("A muddy marsh greets you as you walk forward.");
	Room lake = new Room(
		"With boundless gratefulness you walk to a clear, glassy lake. North of you is a rustic cabin.");
	Room cabinLivingRoom = new Room(
		"Uninvited and unwanted, you break into the living room of the peaceful little cabin.");
	Room cabinBedroom = new Room(
		"Caring not for privacy nor law, you intrude further into the cabin bedroom.");
	Room mountainFortress = new Room(
		"A large, stone fortress greets you. Its formidable height and character makes you shiver.");
	Room cave = new Room(
		"You enter the cave with trepidation. A bat flies over your head as you stumble on the moss.");
	Room tradingStation = new TradingRoom(
		"A man with a mushroom haircut gives you a salacious smile and beckons to you with a curled finger. Would you like to chance a trade?");
	Room fortressAmenities = new Room(
		"What luck! You traipse into a room full of boons and items.");
	Room fortressStronghold = new Room(
		"Alack! The time has come...you have entered the fortress stronghold...");
	Room mountains = new Room(
		"You walk into the mountains. It is cold. It is very cold. It is very, very cold.");
	Room cabinBathroom = new Room(
		"You enter the bathroom. Not much to do here.");

	bedroom.setExit("east", new Door(outside), false);
	bedroom.setExit("north", new Door(outside6), false);

	outside.setExit("west", new Door(bedroom), false);
	outside.setExit("north", new Door(abandonedWarehouse), false);
	outside.setExit("ladder", new Ladder(treehouse), true);

	treehouse.setExit("north", new Ladder(outside5), true);
	treehouse.setExit("east", new Door(outside1), true);
	treehouse.setExit("west", new Ladder(outside), true);

	outside1.setExit("north", new Door(outside4), true);
	outside1.setExit("east", new Door(outside2), true);
	outside1.setExit("west", new Door(treehouse), true);

	outside2.setExit("north", new Door(outside3), true);
	outside2.setExit("west", new Door(outside1), true);

	outside3.setExit("north", new Door(lake), true);
	outside3.setExit("south", new Door(outside2), true);
	outside3.setExit("west", new Door(outside4), true);

	outside4.setExit("north", new Door(marsh), true);
	outside4.setExit("east", new Door(outside3), true);
	outside4.setExit("south", new Door(outside1), true);
	outside4.setExit("west", new Door(outside5), true);

	outside5.setExit("north", new Door(swamp), true);
	outside5.setExit("east", new Door(outside4), true);
	outside5.setExit("ladder", new Ladder(treehouse), true);
	outside5.setExit("west", new Door(abandonedWarehouse), true);

	abandonedWarehouse.setExit("north", new Door(warehouseKitchen), false);
	abandonedWarehouse.setExit("east", new Door(outside5), true);
	abandonedWarehouse.setExit("south", new Door(outside), true);
	abandonedWarehouse.setExit("west", new Door(outside6), true);

	outside6.setExit("north", new Door(forest), true);
	outside6.setExit("east", new Door(abandonedWarehouse), false);
	outside6.setExit("south", new Door(bedroom), true);

	forest.setExit("north", new Door(cave), true);
	forest.setExit("south", new Door(outside6), true);

	warehouseKitchen.setExit("south", new Door(abandonedWarehouse), false);

	swamp.setExit("north", new Door(mountainFortress), false);
	swamp.setExit("east", new Door(marsh), true);
	swamp.setExit("south", new Door(outside5), true);

	marsh.setExit("east", new Door(lake), true);
	marsh.setExit("south", new Door(outside4), true);
	marsh.setExit("west", new Door(swamp), true);

	lake.setExit("north", new Door(cabinLivingRoom), false);
	lake.setExit("south", new Door(outside3), true);
	lake.setExit("west", new Door(marsh), true);

	cabinLivingRoom.setExit("north", new Door(cabinBathroom), true);
	cabinLivingRoom.setExit("south", new Door(lake), false);
	cabinLivingRoom.setExit("west", new Door(cabinBedroom), true);

	cabinBedroom.setExit("east", new Door(cabinLivingRoom), true);

	mountainFortress.setExit("north", new Door(fortressStronghold), true);
	mountainFortress.setExit("south", new Door(swamp), true);

	cave.setExit("north", new Door(tradingStation), true);

	tradingStation.setExit("south", new Door(cave), false);
	tradingStation.setExit("east", new Door(fortressAmenities), true);

	fortressAmenities.setExit("east", new Door(fortressStronghold), true);
	fortressAmenities.setExit("west", new Door(tradingStation), true);

	fortressStronghold.setExit("east", new Door(mountains), true);
	fortressStronghold.setExit("south", new Door(mountainFortress), true);
	fortressStronghold.setExit("west", new Door(fortressAmenities), true);

	mountains.setExit("west", new Door(fortressStronghold), true);

	cabinBathroom.setExit("south", new Door(cabinLivingRoom), true);
	List<Abilities> x = new ArrayList<Abilities>();
	x.add(new BlowFireAbility());
	x.add(new OpenDoorsAbility());
	x.add(new SuperhumanStrength());
	outside.setAbilitiesInRoom(x);
	
	List<NPC> a = new ArrayList<NPC>();
	a.add(new Bees(
		"\nBut not before a giant swarm of BEES moves ominously towards you..."));
	outside.setMonstersInRoom(a);

	List<NPC> b = new ArrayList<NPC>();
	b.add(new EvilSpirit(
		"\nLurking in one of the many bushes is an EVILSPIRIT."));
	outside1.setMonstersInRoom(b);

	List<NPC> c = new ArrayList<NPC>();
	c.add(new Klingon(
		"\nYou see a KLINGON. There's no time to contemplate the mixing of genres, because it starts to shout Klingon at you!"));
	outside2.setMonstersInRoom(c);

	List<NPC> d = new ArrayList<NPC>();
	d.add(new Grue("'\nAtop an elm sits a small, sneaky little GRUE."));
	outside3.setMonstersInRoom(d);

	List<NPC> e = new ArrayList<NPC>();
	e.add(new Ogre(
		"\nLumbering out from behind a tree is a giant green OGRE."));
	outside4.setMonstersInRoom(e);

	List<NPC> f = new ArrayList<NPC>();
	f.add(new EvilBirdMan(
		"\nA squawk sends some birds frantically flying out of the trees, and among them is an EVILBIRDMAN."));
	outside5.setMonstersInRoom(f);

	List<NPC> g = new ArrayList<NPC>();
	g.add(new LandShark(
		"\nJust when you think you've seen everything, a giant LANDSHARK comes flopping toward you."));
	outside6.setMonstersInRoom(g);

	List<NPC> h = new ArrayList<NPC>();
	h.add(new Orc(
		"\nIn between the densely packed trees you spot an ORC advancing towards you."));
	forest.setMonstersInRoom(h);

	List<NPC> i = new ArrayList<NPC>();
	i.add(new Goblin(
		"\nAt home in his native habitat, a small GOBLIN swims in the swamp."));
	swamp.setMonstersInRoom(i);

	List<NPC> j = new ArrayList<NPC>();
	j.add(new Ogre("\nQuietly sipping water from the lake is an OGRE."));
	lake.setMonstersInRoom(j);

	List<NPC> k = new ArrayList<NPC>();
	k.add(new WaterToad(
		"\nRibbiting and croaking with undeniable malice, an angry WATERTOAD hops on the marsh lily pads."));
	marsh.setMonstersInRoom(k);

	List<NPC> l = new ArrayList<NPC>();
	l.add(new Gremlin(
		"\nWith his long, sharpened nails a GREMLIN points aggressively at your messy hair."));
	swamp.setMonstersInRoom(l);

	List<NPC> m = new ArrayList<NPC>();
	m.add(new Orc("\nSharpening an axe, a towering ORC sits quietly."));
	forest.setMonstersInRoom(m);

	List<NPC> n = new ArrayList<NPC>();
	n.add(new Spiders(
		"\nYou see a unidentifiable mass of black scuttling on the floor and realize a swarm of SPIDERS is coming for you."));
	cave.setMonstersInRoom(n);

	List<NPC> o = new ArrayList<NPC>();
	boss = new DrMcCarthy(
		"\nThe moment has finally come. A wild DRMCCARTHY appears in front of you. It's time to test your strength.");
	o.add(boss);
	fortressStronghold.setMonstersInRoom(o);

	List<Item> a1 = new ArrayList<Item>();
	a1.add(new Cheese(""));
	a1.add(new Sword(""));
	a1.add(new MagicalOrb());
	treehouse.setItemsInRoom(a1);

	List<Item> b1 = new ArrayList<Item>();
	b1.add(new Knife(""));
	b1.add(new Sword(""));
	abandonedWarehouse.setItemsInRoom(b1);

	List<Item> c1 = new ArrayList<Item>();
	c1.add(new Apple(""));
	c1.add(new Bread(""));
	c1.add(new Cheese(""));
	warehouseKitchen.setItemsInRoom(c1);

	List<Item> d1 = new ArrayList<Item>();
	d1.add(new Document(
		"Cabin rules: \n\t1) NO SHOES IN THE HOUSE \n\t2) DO NOT BRING ANIMAL CARCASSES \n\t3)ENJOY YOURSELF :) "));
	cabinLivingRoom.setItemsInRoom(d1);

	List<Item> e1 = new ArrayList<Item>();
	e1.add(new Apple(""));
	e1.add(new Bread(""));
	e1.add(new Torch(""));
	mountainFortress.setItemsInRoom(e1);

	initialRoom = bedroom;
    }

    public void play()
    {
	printWelcome();
	while (!this.finished)
	{
	    Command command = parser.getCommand();
	    if (command == null)
		return;
	    if (command.canRun())
	    {
		command.execute();
	    } else
	    {
		System.out.println("That's not valid at this moment.");
	    }
	    if (this.finished)
		return;
	    notStillAlive();
	    if (notStillAlive() == true)
	    {
		continue;
	    }
	    if (bossStillAlive == false)
	    {
		System.out
			.println("CONGRATULATIONS! YOU'VE SNATCHED VICTORY FROM THE DEPTHLESS JAWS OF CHANCE! CONGRATULATIONS..");
		continue;
	    }
	}
	System.out.println("Thank you for playing, good bye.");
    }

    public boolean notStillAlive()
    {
	if (getPlayer().getHealth() > 0)
	{
	    notStillAlive = false;
	    return notStillAlive;
	} else
	{
	    System.out.println("Unfortunately, you have died.");
	    notStillAlive = true;
	    return notStillAlive;
	}
    }

    public void setNotAlive(boolean value)
    {
	notStillAlive = value;
    }

    public void printWelcome()
    {
	System.out.println();
	System.out.println("Welcome to Zork");
	System.out.println("Zork is a new, incredibly boring adventure game");
	System.out.println("Type help if you need help");
	System.out.println();
	System.out.println(Game.getGame().getPlayer().getLocation()
		.getDescription());
    }

    public void end()
    {
	this.finished = true;
    }

    private Game(Player player)
    {
	this.player = player;
    }

    public static Room getInitialRoom()
    {
	return initialRoom;
    }

    public Player getPlayer()
    {
	return player;
    }

    public Bag getBag()
    {
	return player.getBag();
    }

    public static void main(String[] args)
    {
	Game game = new Game();
	game.play();
    }

    public boolean isOver()
    {
	return this.finished;
    }

}
